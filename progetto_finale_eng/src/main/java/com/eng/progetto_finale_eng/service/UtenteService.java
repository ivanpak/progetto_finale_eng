package com.eng.progetto_finale_eng.service;

import com.eng.progetto_finale_eng.dto.LoginRequest;
import com.eng.progetto_finale_eng.model.Utente;
import com.eng.progetto_finale_eng.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UtenteService {

    public List<Utente> findAll();

    public Utente findById(Integer id);

    public Utente save(Utente u);

    public void delete(Integer id);

    public Integer DTOToId(LoginRequest loginRequest);
}
