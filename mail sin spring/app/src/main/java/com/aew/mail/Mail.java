package com.aew.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mail {
	public static void mandarCorreo() {
		// El correo gmail de envío
		String correoEnvia = "adrianwilgenhoff@gmail.com";
		String claveCorreo = "aew3335695310";

		// La configuración para enviar correo
		Properties properties = new Properties();

		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.user", correoEnvia);
		properties.put("mail.password", claveCorreo);

		// Obtener la sesion
		Session session = Session.getInstance(properties, null);
		try {
			// Crear el cuerpo del mensaje
			MimeMessage mimeMessage = new MimeMessage(session);

			// Agregar quien envía el correo
			mimeMessage.setFrom(new InternetAddress(correoEnvia, "Adrian E. Wilgenhoff"));

			// Los destinatarios puede ser mas de 1
			InternetAddress[] internetAddresses = { new InternetAddress("adrianwilgenhoff@gmail.com") };
			// new InternetAddress("correo2@gmail.com"),
			// new InternetAddress("correo3@gmail.com") };

			// Agregar los destinatarios al mensaje
			mimeMessage.setRecipients(Message.RecipientType.TO, internetAddresses);

			// Agregar el asunto al correo
			mimeMessage.setSubject("Corre de Prueba");

			// Creo la parte del mensaje
			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			mimeBodyPart.setText("Te envío este mensaje como prueba de que funciona mi programa de envio de correo.");

			// MimeBodyPart mimeBodyPartAdjunto = new MimeBodyPart();
			// mimeBodyPartAdjunto.attachFile("C:/Users/Public/Pictures/Sample
			// Pictures/Penguins.jpg");

			// Crear el multipart para agregar la parte del mensaje anterior
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(mimeBodyPart);
			// multipart.addBodyPart(mimeBodyPartAdjunto);

			// Agregar el multipart al cuerpo del mensaje
			mimeMessage.setContent(multipart);

			// Enviar el mensaje
			Transport transport = session.getTransport("smtp");
			transport.connect(correoEnvia, claveCorreo);
			transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());

			transport.close();
			System.out.println("¡Correo electrónico enviado exitosamente!");

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("¡Correo electrónico NO enviado");
		}

	}

	public static void main(String[] args) {
		Mail.mandarCorreo();
	}
}
