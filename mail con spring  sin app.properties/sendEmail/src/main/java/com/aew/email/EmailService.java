package com.aew.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

  @Autowired
  private JavaMailSender emailSender;

  public void sendSimpleMessage() {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setSubject("probando probando");
    message.setText("hola ACA va el contenido");
    message.setTo("adrianwilgenhoff@gmail.com");
    message.setFrom("noreply@NameOfApp");

    emailSender.send(message);
  }

}