package com.eng.progetto_finale_eng.controller;

import com.eng.progetto_finale_eng.dto.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
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

   // @GetMapping
   // public String getQualcosa(){
    //    return "OOOOOOOOOOO";
    //}

    /*
    @GetMapping
    public List<Utente> elencoUtenti(){

        return authService.getUtenti();

    }*/

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {

        boolean isAuthenticated = authService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());

        System.out.println("SONO NEL AUTH CONTROLLER");
        System.out.println(loginRequest.getEmail());


        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}