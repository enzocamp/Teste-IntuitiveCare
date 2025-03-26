package br.com.intuitivecare.teste1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.net.URL;

public class Scraper {
	
	private static final Logger logger = Logger.getLogger(Scraper.class.getName());
	
    public static void main(String[] args) {
        String url = "https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos";
        String destinationFolder   = "downloads/";

        try {
            // Cria pasta para salvar os arquivos
            new java.io.File(destinationFolder).mkdirs();

            // Conecta e busca os links da página
            Document doc = Jsoup.connect(url).get();
            Elements links = doc.select("a[href$=.pdf]");

            for (Element link : links) {
                String text = link.text().toLowerCase();
                if (text.contains("anexo i") || text.contains("anexo ii")) {
                    String href = link.attr("abs:href");
					String fileName = href.substring(href.lastIndexOf('/') + 1);
					
					logger.info("Downloading: " + fileName);
					downloadFile(href, destinationFolder + fileName);
                }
            }

            System.out.println("Download finalizado!");
            ZipCompressor.compressDirectory(destinationFolder  , destinationFolder + "anexos.zip");
        } catch (IOException e) {
        	 logger.log(Level.SEVERE, "Error during download", e);
        }
    }

    public static void downloadFile(String url, String destino) throws IOException {
    	//Aqui há um aviso por conta da versão Java 20 + esse contrutor usado foi marcado como deprecated, para forçar o uso de fábricas modernas com verificação robusta, como URI.create().toURL().
        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(destino)) {
        	
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        }
    }
}
