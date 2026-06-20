public class FactoryMethodDemo {

    public static void main(String[] args) {

        DocumentFactory wordFactory = new WordFactory();
        wordFactory.openDocument();

        DocumentFactory pdfFactory = new PdfFactory();
        pdfFactory.openDocument();

        DocumentFactory excelFactory = new ExcelFactory();
        excelFactory.openDocument();
    }
}