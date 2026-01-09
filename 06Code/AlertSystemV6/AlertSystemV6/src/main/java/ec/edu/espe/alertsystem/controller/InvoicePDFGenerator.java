package ec.edu.espe.alertsystem.controller;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import ec.edu.espe.alertsystem.model.Invoice;
import java.util.Map;
import javax.swing.JOptionPane;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import ec.edu.espe.alertsystem.model.Customer;
import java.io.File;
import java.text.SimpleDateFormat;

/**
 *
 * @author Paulo Ramos
 */
public class InvoicePDFGenerator {

    public static void generate(Invoice invoice) {

        try {
            String desktopPath = System.getProperty("user.home")
                    + File.separator + "Desktop";

            String folderPath = desktopPath + File.separator + "Facturas";
            File folder = new File(folderPath);

            if (!folder.exists()) {
                folder.mkdirs();
            }

            String path = folderPath + File.separator
                    + "factura_" + invoice.getInvoiceNumber() + ".pdf";

            PdfWriter writer = new PdfWriter(path);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            String logoPath = InvoicePDFGenerator.class
                    .getClassLoader()
                    .getResource("pena.png")
                    .getPath();

            ImageData imageData = ImageDataFactory.create(logoPath);
            Image logo = new Image(imageData);

            logo.setWidth(100);
            logo.setTextAlignment(TextAlignment.CENTER);

            document.add(logo);

            document.add(new Paragraph("Peña & M Group")
                    .setBold()
                    .setFontSize(16)
                    .setTextAlignment(TextAlignment.CENTER));

            document.add(new Paragraph("Factura N° " + invoice.getInvoiceNumber())
                    .setTextAlignment(TextAlignment.CENTER));

            document.add(new Paragraph("Fecha: " + sdf.format(invoice.getPaymentDate()))
                    .setTextAlignment(TextAlignment.CENTER));

            document.add(new Paragraph("\n"));

            document.add(new Paragraph("Estado: " + invoice.getStatus()));
            document.add(new Paragraph("Fecha de pago: "
                    + sdf.format(invoice.getPaymentDate())));

            document.add(new Paragraph("\n"));

            document.add(new Paragraph("Descripción").setBold());
            document.add(new Paragraph(invoice.getDetails()));

            document.add(new Paragraph("\n"));

            Table table = new Table(UnitValue.createPercentArray(new float[]{70, 30}))
                    .useAllAvailableWidth();

            table.addHeaderCell("Concepto");
            table.addHeaderCell("Valor");

            double subtotal = invoice.getAmountPaid();
            double iva = subtotal * 0.15;
            double total = subtotal + iva;

            table.addCell("Subtotal");
            table.addCell(String.format("$ %.2f", subtotal));

            table.addCell("IVA 15%");
            table.addCell(String.format("$ %.2f", iva));

            table.addCell(new Paragraph("TOTAL").setBold());
            table.addCell(new Paragraph(String.format("$ %.2f", total)).setBold());

            document.add(table);

            document.add(new Paragraph("\nGracias por su pago")
                    .setTextAlignment(TextAlignment.CENTER));

            document.close();

            JOptionPane.showMessageDialog(null,
                    "Factura guardada en:\n" + path);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String generate(Invoice invoice, Customer customer) {

        try {
            String desktopPath = System.getProperty("user.home")
                    + File.separator + "Desktop";

            String folderPath = desktopPath + File.separator + "Facturas";
            File folder = new File(folderPath);

            if (!folder.exists()) {
                folder.mkdirs();
            }

            String path = folderPath + File.separator
                    + "factura_" + invoice.getInvoiceNumber() + ".pdf";

            PdfWriter writer = new PdfWriter(path);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            String logoPath = InvoicePDFGenerator.class
                    .getClassLoader()
                    .getResource("pena.png")
                    .getPath();

            ImageData imageData = ImageDataFactory.create(logoPath);
            Image logo = new Image(imageData);

            logo.setWidth(100);
            logo.setTextAlignment(TextAlignment.CENTER);
            document.add(logo);

            document.add(new Paragraph("Peña & M Group")
                    .setBold()
                    .setFontSize(16)
                    .setTextAlignment(TextAlignment.CENTER));

            document.add(new Paragraph("Factura N° " + invoice.getInvoiceNumber())
                    .setTextAlignment(TextAlignment.CENTER));

            document.add(new Paragraph("Fecha: " + sdf.format(invoice.getPaymentDate()))
                    .setTextAlignment(TextAlignment.CENTER));

            document.add(new Paragraph("\n"));

            // 🔹 DATOS DEL CLIENTE
            document.add(new Paragraph("Cliente: " + customer.getName()));
            document.add(new Paragraph("Correo: " + customer.getEmail()));

            document.add(new Paragraph("\n"));

            document.add(new Paragraph("Estado: " + invoice.getStatus()));
            document.add(new Paragraph("Fecha de pago: "
                    + sdf.format(invoice.getPaymentDate())));

            document.add(new Paragraph("\n"));

            document.add(new Paragraph("Descripción").setBold());
            document.add(new Paragraph(invoice.getDetails()));

            document.add(new Paragraph("\n"));

            Table table = new Table(UnitValue.createPercentArray(new float[]{70, 30}))
                    .useAllAvailableWidth();

            table.addHeaderCell("Concepto");
            table.addHeaderCell("Valor");

            double subtotal = invoice.getAmountPaid();
            double iva = subtotal * 0.15;
            double total = subtotal + iva;

            table.addCell("Subtotal");
            table.addCell(String.format("$ %.2f", subtotal));

            table.addCell("IVA 15%");
            table.addCell(String.format("$ %.2f", iva));

            table.addCell(new Paragraph("TOTAL").setBold());
            table.addCell(new Paragraph(String.format("$ %.2f", total)).setBold());

            document.add(table);

            document.add(new Paragraph("\nGracias por su pago")
                    .setTextAlignment(TextAlignment.CENTER));

            document.close();

            return path;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
