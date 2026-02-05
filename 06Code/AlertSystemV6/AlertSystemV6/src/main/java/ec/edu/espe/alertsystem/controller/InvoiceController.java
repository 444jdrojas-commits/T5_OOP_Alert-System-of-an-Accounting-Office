package ec.edu.espe.alertsystem.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import ec.edu.espe.alertsystem.model.Invoice;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Paulo Ramos
 */
public class InvoiceController {

    public void saveInvoice(double amount, String details) {

        MongoCollection<Document> collection
                = MongoConnection.getConnection().getCollection("invoices");

        int nextInvoiceNumber = getNextInvoiceNumber();

        Document doc = new Document()
                .append("invoiceNumber", nextInvoiceNumber)
                .append("amountPaid", amount)
                .append("details", details)
                .append("status", "Pendiente");

        collection.insertOne(doc);
    }

    private int getNextInvoiceNumber() {

        MongoCollection<Document> collection
                = MongoConnection.getConnection().getCollection("invoices");

        Document last = collection
                .find()
                .sort(new Document("invoiceNumber", -1))
                .first();

        if (last == null) {
            return 1;
        }

        return last.getInteger("invoiceNumber") + 1;
    }

    public static List<Document> getInvoices() {

        List<Document> invoices = new ArrayList<>();

        MongoCollection<Document> collection
                = MongoConnection.getDatabase().getCollection("invoices");

        try (MongoCursor<Document> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                invoices.add(cursor.next());
            }
        }

        return invoices;
    }

    public static double calculateIva(double subtotal) {
        return subtotal * utils.TaxConfig.getInstance().getIva();
    }

    public static double calculateTotal(double subtotal) {
        return subtotal + calculateIva(subtotal);
    }

    public static void actualizarPagoFactura(int invoiceNumber, Date paymentDate) {
        MongoCollection<Document> collection = MongoConnection.getDatabase().getCollection("invoices");

        Document filter = new Document("invoiceNumber", invoiceNumber);

        Document update = new Document("$set", new Document("status", "Pagado").append("paymentDate", paymentDate));

        collection.updateOne(filter, update);
    }

    public static Invoice getInvoiceByNumber(int invoiceNumber) {

        MongoCollection<Document> collection
                = MongoConnection.getDatabase().getCollection("invoices");

        Document doc = collection.find(
                new Document("invoiceNumber", invoiceNumber)
        ).first();

        if (doc == null) {
            return null;
        }

        Invoice invoice = new Invoice();
        invoice.setInvoiceNumber(doc.getInteger("invoiceNumber"));

        Number amount = (Number) doc.get("amountPaid");
        invoice.setAmountPaid((float) amount.doubleValue());

        invoice.setDetails(doc.getString("details"));
        invoice.setStatus(doc.getString("status"));
        invoice.setPaymentDate(doc.getDate("paymentDate"));

        return invoice;
    }

    public static String extractClientName(String details) {
        if (details == null) {
            return null;
        }

        if (details.contains("Cliente:")) {
            return details.substring(details.indexOf("Cliente:") + 8).trim();
        }
        return null;
    }
}
