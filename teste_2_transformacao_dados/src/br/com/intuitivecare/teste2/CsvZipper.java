package br.com.intuitivecare.teste2;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CsvZipper {

    public static void zipCsv(String filePath, String zipName) {
        File csvFile = new File(filePath);
        File zipFile = new File(zipName);

        try (
            FileOutputStream fos = new FileOutputStream(zipFile);
            ZipOutputStream zipOut = new ZipOutputStream(fos);
            FileInputStream fis = new FileInputStream(csvFile)
        ) {
            ZipEntry zipEntry = new ZipEntry(csvFile.getName());
            zipOut.putNextEntry(zipEntry);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) >= 0) {
                zipOut.write(buffer, 0, length);
            }

            System.out.println("✅ Arquivo ZIP criado com sucesso: " + zipName);

        } catch (IOException e) {
            System.err.println("Erro ao criar o ZIP: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
