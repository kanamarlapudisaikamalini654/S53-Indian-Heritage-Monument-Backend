package com.heritage.india.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfig {

    // 1. This part fixes the 401 Unauthorized error
   
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .csrf(csrf -> csrf.disable())
	        // ADD THIS LINE BELOW
	        .cors(org.springframework.security.config.Customizer.withDefaults()) 
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers("/api/**").permitAll()
	            .anyRequest().authenticated()
	        );
	    return http.build();
	}
    // 2. This part fixes the CORS error for React (Port 5173)
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:5173")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                     .allowCredentials(true);
            }
        };
    }
}