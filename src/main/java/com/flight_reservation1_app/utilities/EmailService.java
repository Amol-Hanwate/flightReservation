package com.flight_reservation1_app.utilities;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

	@Autowired
    private  JavaMailSender mailSender;

   
    public void sendEmail(String toAddress, String filePath) {
    	MimeMessage message = mailSender.createMimeMessage();
        try {
            
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true); 

            messageHelper.setTo(toAddress);
            messageHelper.setSubject("Itinerary of Flight");
            messageHelper.setText("Please find the attached itinerary.");

            FileSystemResource file = new FileSystemResource(new File(filePath));
            messageHelper.addAttachment("Itinerary.pdf", file);

            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

