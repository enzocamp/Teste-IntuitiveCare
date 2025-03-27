package br.com.intuitivecare.teste2;

import technology.tabula.Page;
import technology.tabula.TextElement;
import technology.tabula.RectangularTextContainer;
import technology.tabula.Table;
import technology.tabula.extractors.SpreadsheetExtractionAlgorithm;
import technology.tabula.extractors.BasicExtractionAlgorithm;
import technology.tabula.ObjectExtractor;
import technology.tabula.PageIterator;
import technology.tabula.extractors.ExtractionAlgorithm;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Extractor {

    public static void main(String[] args) {
        String inputPdf = "resources/Anexo_I_Rol_2021RN_465.2021_RN627L.2024.pdf";
        String outputCsv = "output/rol_de_procedimentos.csv"; // Arquivo de saída

        try {
            // Cria pasta de saída
            new File("output").mkdirs();

            // Carrega o PDF
            PDDocument document = PDDocument.load(new File(inputPdf));
            ObjectExtractor extractor = new ObjectExtractor(document);
            PageIterator pages = extractor.extract();

            // Algoritmo de extração (pode trocar por SpreadsheetExtractionAlgorithm)
            ExtractionAlgorithm algo = new BasicExtractionAlgorithm();

            FileWriter csvWriter = new FileWriter(outputCsv);

            while (pages.hasNext()) {
                Page page = pages.next();
                List<? extends Table> tables = algo.extract(page);
                
                for (Table table : tables) {
                    for (List<RectangularTextContainer> row : table.getRows()) {
                        for (int i = 0; i < row.size(); i++) {
                            String cellText = row.get(i).getText();

                            // Substituições com regex (substitui apenas palavras exatas)
                            cellText = cellText.replaceAll("\\bOD\\b", "Odontologia");
                            cellText = cellText.replaceAll("\\bAMB\\b", "Ambulatorial");

                            csvWriter.write(cellText);

                            if (i != row.size() - 1) {
                                csvWriter.write(",");
                            }
                        }
                        csvWriter.write("\n");
                    }
                }
              }

            csvWriter.close();
            document.close();
            
         // Compacta o CSV
            CsvZipper.zipCsv(outputCsv, "output/Teste_Enzo.zip");

            System.out.println("✅ CSV exportado com sucesso: " + outputCsv);


        } catch (IOException e) {
            System.err.println("Erro ao processar o PDF: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
