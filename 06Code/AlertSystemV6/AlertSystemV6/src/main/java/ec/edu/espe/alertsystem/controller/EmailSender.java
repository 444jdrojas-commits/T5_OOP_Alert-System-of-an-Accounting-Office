package ec.edu.espe.alertsystem.controller;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.io.File;
import java.util.Properties;

/**
 *
 * @author Paulo Ramos
 */
public class EmailSender {

    public static void sendInvoiceByEmail(
            String toEmail,
            String clientName,
            String pdfPath
    ) {

        final String fromEmail = "v4485007@gmail.com";
        final String password = "xhgryyiacmxdmvrl"; 

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props,
                new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(toEmail)
            );

            message.setSubject("Factura electrónica - Alert System");

            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setContent(
                    "<h2>Factura Electrónica</h2>"
                    + "<p>Estimado/a <b>" + clientName + "</b>,</p>"
                    + "<p>Adjuntamos su factura electrónica generada por <b>Peña & M Group</b>.</p>"
                    + "<p>Si tiene alguna duda, no dude en contactarnos.</p>"
                    + "<br>"
                    + "<p>Atentamente,<br>"
                    + "<b>Peña & M Group</b></p>",
                    "text/html; charset=utf-8"
            );

            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.attachFile(new File(pdfPath));

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(textPart);
            multipart.addBodyPart(attachmentPart);

            message.setContent(multipart);

            Transport.send(message);

            System.out.println("Correo enviado correctamente");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
