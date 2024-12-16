package com.eng.progetto_finale_eng.dto;

import com.eng.progetto_finale_eng.repository.UtenteRepository;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@Builder
public class LoginRequest {

    private String email;
    private String password;

    @Autowired
    private UtenteRepository utenteRepository;

    // Getter and Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
