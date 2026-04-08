package com.heritage.india.service;

import com.heritage.india.entity.User;
import com.heritage.india.entity.User.Role;
import com.heritage.india.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        // 1. If the user somehow didn't pick a role, set the default
        if (user.getRole() == null) {
            user.setRole(Role.Cultural_Enthusiast);
        }
        
        // 2. Save the user (username, email, password, role) to MySQL
        return userRepository.save(user);
    }
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}