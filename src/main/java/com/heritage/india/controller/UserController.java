package com.heritage.india.controller;

import com.heritage.india.entity.User;
import com.heritage.india.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
// Allows your React app (Port 5173) to communicate with the Backend (Port 8080)
@CrossOrigin(origins = "http://localhost:5175", allowCredentials = "true")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        // Fetch the user from the database using the email provided in the login form
        User existingUser = userService.findByEmail(user.getEmail());
        
        // Verify if the user exists and the password matches
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            
            /* CRITICAL FIX: We return the full 'existingUser' object. 
               This sends JSON like {"username": "sai_kamalini24", "role": "Admin"} 
               to React instead of just a message string.
            */
            return ResponseEntity.ok(existingUser); 
        }
        
        // Return 401 Unauthorized if the login fails
        return ResponseEntity.status(401).body("Invalid Credentials");
    }
}