package ec.edu.espe.alertsystem.controller;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 *
 * @author Paulo Ramos
 */
public class EmailSender {

    private static final String FROM_EMAIL = "v4485007@gmail.com";
    private static final String PASSWORD = "xhgryyiacmxdmvrl";

    private static Session getSession() {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");

        return Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM_EMAIL, PASSWORD);
            }
        });
    }

    // ================= FACTURA =================
    public static void sendInvoiceByEmail(
            String toEmail,
            String clientName,
            String pdfPath
    ) {

        try {
            Message message = new MimeMessage(getSession());
            message.setFrom(new InternetAddress(FROM_EMAIL));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(toEmail)
            );

            message.setSubject("Factura electrónica - Alert System");

            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setContent(
                    "<h2>Factura Electrónica</h2>"
                    + "<p>Estimado/a <b>" + clientName + "</b>,</p>"
                    + "<p>Adjuntamos su factura electrónica.</p>"
                    + "<br><p><b>Peña & M Group</b></p>",
                    "text/html; charset=utf-8"
            );

            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.attachFile(new File(pdfPath));

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(textPart);
            multipart.addBodyPart(attachmentPart);

            message.setContent(multipart);

            Transport.send(message);
            System.out.println("Factura enviada a " + toEmail);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= NOTIFICACIÓN DE TAREA =================
    public static void sendTaskNotification(
            String toEmail,
            String assistantName,
            String taskDescription,
            Date deliveryDate
    ) {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            Message message = new MimeMessage(getSession());
            message.setFrom(new InternetAddress(FROM_EMAIL));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(toEmail)
            );

            message.setSubject("⏰ Tarea próxima a vencer");

            message.setContent(
                    "<p>Hola <b>" + assistantName + "</b>,</p>"
                    + "<p>Tienes una tarea próxima a vencer:</p>"
                    + "<ul>"
                    + "<li><b>Tarea:</b> " + taskDescription + "</li>"
                    + "<li><b>Fecha límite:</b> " + sdf.format(deliveryDate) + "</li>"
                    + "</ul>"
                    + "<p>— Alert System</p>",
                    "text/html; charset=utf-8"
            );

            Transport.send(message);
            System.out.println("Notificación enviada a " + toEmail);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
