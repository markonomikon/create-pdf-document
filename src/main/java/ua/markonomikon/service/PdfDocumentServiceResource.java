package ua.markonomikon.service;

import io.quarkus.qute.Engine;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import ua.markonomikon.model.Customer;
import ua.markonomikon.model.Invoice;
import ua.markonomikon.util.PdfDocumentUtil;

import java.io.File;

import static ua.markonomikon.management.AppConstants.PDF_DOCUMENT_PATH;

import java.io.IOException;

@Path(PDF_DOCUMENT_PATH)
public class PdfDocumentServiceResource {
    @Inject
    Engine engine;
    @GET
    public Response getPDF() throws IOException {
        Customer customer = new Customer();
        customer.name = "Timon";
        customer.surname = "Pumba";
        customer.street = "41st Street Washington";
        customer.city = "Kansas";
        customer.country = "USA";

        Invoice invoice = new Invoice();
        invoice.description = "Java Coffee Multipack 12X500G";
        invoice.date = "";
        invoice.price = 99.99;

        String data = PdfDocumentUtil.getPdfReceiptContent(engine, customer, invoice);

        File tempPdf = File.createTempFile("pdf-document", ".pdf");
        PdfDocumentUtil.createPdf(tempPdf.getAbsolutePath(), data);

        return Response.ok(tempPdf, "application/pdf")
                .header("Content-Disposition", "attachment; filename=pdf-document.pdf")
                .build();
    }
}

