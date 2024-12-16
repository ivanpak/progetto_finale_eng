package com.eng.progetto_finale_eng.controller;

import com.eng.progetto_finale_eng.dto.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.eng.progetto_finale_eng.service.AuthService;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthService authService;


    private static LoginRequest sessionUser;


    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {

        boolean isAuthenticated = authService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());

        if (isAuthenticated) {
            sessionUser=loginRequest;
            return "Login successful";
        } else {
            return "Invalid credentials";
        }
    }
    @GetMapping("/logout")
    public String logout(){
        sessionUser=null;
        return "Logout successful";
    }

    public static LoginRequest getSession(){
        return sessionUser;
    }

}