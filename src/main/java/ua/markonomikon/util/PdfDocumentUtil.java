package ua.markonomikon.util;

import io.quarkus.qute.Engine;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import ua.markonomikon.model.Customer;
import ua.markonomikon.model.Invoice;
import java.io.IOException;

public class PdfDocumentUtil {
    public static void createPdf(String outputFile, String text) throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
        contentStream.setLeading(14.5f);

        contentStream.beginText();
        contentStream.newLineAtOffset(25, 700);

        // Write your content here
        contentStream.showText(text);

        contentStream.endText();
        contentStream.close();

        document.save(outputFile);
        document.close();
    }
    public static String getPdfReceiptContent(Engine engine, Customer customer, Invoice invoice) {
        Template myTemplatePdf = engine.parse("pdf-document.html");
        TemplateInstance templateInstancePdf = myTemplatePdf
                .data("customer", customer)
                .data("invoice", invoice);
        return templateInstancePdf.render();
    }
}

