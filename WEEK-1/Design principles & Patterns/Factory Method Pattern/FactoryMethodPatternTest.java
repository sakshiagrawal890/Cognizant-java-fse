/**
 * Exercise 2: Factory Method Pattern - Test Class
 * 
 * Demonstrates the creation of different document types
 * using the Factory Method Pattern.
 */
public class FactoryMethodPatternTest {

    public static void main(String[] args) {

        // Create a Word Document using its factory
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        System.out.println("--- Word Document ---");
        wordDoc.open();
        wordDoc.save();
        wordDoc.close();

        System.out.println();

        // Create a PDF Document using its factory
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        System.out.println("--- PDF Document ---");
        pdfDoc.open();
        pdfDoc.save();
        pdfDoc.close();

        System.out.println();

        // Create an Excel Document using its factory
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        System.out.println("--- Excel Document ---");
        excelDoc.open();
        excelDoc.save();
        excelDoc.close();
    }
}
