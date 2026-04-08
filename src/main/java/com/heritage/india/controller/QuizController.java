package com.heritage.india.controller;

import com.heritage.india.entity.QuizResult;
import com.heritage.india.repository.QuizRepository;
import com.heritage.india.service.EmailService; // 1. IMPORT the Service
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
@CrossOrigin(origins = "http://localhost:5175")
public class QuizController {

    @Autowired
    private QuizRepository quizRepository;

    // 2. INJECT the EmailService (This fixes the "error email.service")
    @Autowired
    private EmailService emailService;

    // 3. SUBMIT: Saves result and sends email to the SPECIFIC student
    @PostMapping("/submit")
    public String submitResult(@RequestBody QuizResult result) {
        // Save to MySQL
        quizRepository.save(result);
        
        // Prepare the email details dynamically from the 'result' object
        String recipientEmail = result.getStudentEmail(); 
        String studentName = result.getStudentName();
        int score = result.getScore();
        
        String subject = "Heritage India: Quiz Results for " + studentName;
        String body = "Hello " + studentName + ",\n\n" +
                      "Congratulations on completing the Heritage India Quiz!\n" +
                      "Your Final Score: " + score + " / 5\n\n" +
                      "Keep exploring Indian Heritage!";

        // Send the email to the student's actual email address
        emailService.sendEmail(recipientEmail, subject, body);
        
        return "Score saved and email sent to " + recipientEmail;
    }

    // 4. ADMIN FETCH: Gets all results for Kamalini's Admin Dashboard
    @GetMapping("/admin/results")
    public List<QuizResult> getAllResults() {
        return quizRepository.findAll();
    }
}