package ua.markonomikon.util;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import ua.markonomikon.model.Customer;
import ua.markonomikon.model.Invoice;
import java.io.IOException;

public class PdfDocumentUtil {
    public static void createPdf(String outputFile, Customer customer, Invoice invoice) throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
        contentStream.setLeading(14.5f);

        contentStream.beginText();
        contentStream.newLineAtOffset(15, 800);

        contentStream.showText("Name: " + customer.name);
        contentStream.newLine();
        contentStream.showText("Surname: " + customer.surname);
        contentStream.newLine();
        contentStream.showText("Street: " + customer.street);
        contentStream.newLine();
        contentStream.showText("City: " + customer.city);
        contentStream.newLine();
        contentStream.showText("Country: " + customer.country);
        contentStream.newLine();
        contentStream.newLine();
        contentStream.showText("Description: " + invoice.description);
        contentStream.newLine();
        contentStream.showText("Date: " + invoice.date);
        contentStream.newLine();
        contentStream.showText("Price: " + invoice.price);
        contentStream.newLine();

        contentStream.endText();
        contentStream.close();

        document.save(outputFile);
        document.close();
    }
}

