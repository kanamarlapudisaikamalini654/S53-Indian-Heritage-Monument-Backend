package com.heritage.india.controller;

import com.heritage.india.dto.ContactRequest;
import com.heritage.india.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mail")
@CrossOrigin(origins = "http://localhost:5173")
public class MailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-query")
    public String sendQuery(@RequestBody ContactRequest request) {
        // 1. Prepare the email details
        String userEmail = request.getEmail();
        String userName = request.getName();
        String userMessage = request.getMessage();

        String subject = "Heritage India: New Message for " + userName;
        String body = "Hello " + userName + ",\n\n" +
                      "Thank you for contacting the Heritage India Team.\n" +
                      "We have received your message:\n\n\"" + 
                      userMessage + "\"\n\n" +
                      "Our team will review your query and get back to you shortly.";

        // 2. SEND TO THE USER (e.g., Zafeer or Divya)
        // This goes to whatever email was typed into the React form
        emailService.sendEmail(userEmail, subject, body);

        // 3. SEND A COPY TO ADMIN (K. Sai Kamalini)
        // This ensures you always have a record of the message in your inbox
        String adminSubject = "ADMIN ALERT: New Query from " + userName;
        String adminBody = "Admin Notification:\n\n" +
                           "Name: " + userName + "\n" +
                           "Email: " + userEmail + "\n" +
                           "Message: " + userMessage;
                           
        emailService.sendEmail("saikamalini2006@gmail.com", adminSubject, adminBody);

        return "Email sent successfully!";
    }
}