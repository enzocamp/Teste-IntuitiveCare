package br.com.intuitivecare.teste1;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipCompressor {
    private static final Logger logger = Logger.getLogger(ZipCompressor.class.getName());

    public static void compressDirectory(String directoryPath, String zipFileName) {
        File folder = new File(directoryPath);
        File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".pdf"));

        if (files == null || files.length == 0) {
            logger.warning("No PDF files found to compress in directory: " + directoryPath);
            return;
        }

        try (FileOutputStream fos = new FileOutputStream(zipFileName);
             ZipOutputStream zipOut = new ZipOutputStream(fos)) {

            for (File fileToZip : files) {
                try (FileInputStream fis = new FileInputStream(fileToZip)) {
                    ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
                    zipOut.putNextEntry(zipEntry);

                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = fis.read(buffer)) >= 0) {
                        zipOut.write(buffer, 0, length);
                    }
                }
            }

            logger.info("Compression completed successfully: " + zipFileName);

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error during compression process", e);
        }
    }
}
