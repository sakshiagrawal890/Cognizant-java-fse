public class FactoryMethodPatternExample {
    interface Document {
        void open();
    }

    static class WordDocument implements Document {
        public void open() {
            System.out.println("Opening Word document.");
        }
    }

    static class PdfDocument implements Document {
        public void open() {
            System.out.println("Opening PDF document.");
        }
    }

    static class ExcelDocument implements Document {
        public void open() {
            System.out.println("Opening Excel document.");
        }
    }

    static class DocumentFactory {
        public static Document createDocument(String type) {
            switch (type.toLowerCase()) {
                case "word":
                    return new WordDocument();
                case "pdf":
                    return new PdfDocument();
                case "excel":
                    return new ExcelDocument();
                default:
                    throw new IllegalArgumentException("Unknown document type: " + type);
            }
        }
    }

    public static void main(String[] args) {
        Document doc1 = DocumentFactory.createDocument("Word");
        Document doc2 = DocumentFactory.createDocument("PDF");
        Document doc3 = DocumentFactory.createDocument("Excel");

        doc1.open();
        doc2.open();
        doc3.open();
    }
}