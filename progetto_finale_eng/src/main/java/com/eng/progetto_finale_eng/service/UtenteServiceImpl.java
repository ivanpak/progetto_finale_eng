package com.eng.progetto_finale_eng.service;

import com.eng.progetto_finale_eng.dto.LoginRequest;
import com.eng.progetto_finale_eng.model.Utente;
import com.eng.progetto_finale_eng.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteServiceImpl implements UtenteService{

    @Autowired
    private UtenteRepository utenteRepository;

    public List<Utente> findAll() {
        return utenteRepository.findAll();
    }

    public Utente findById(Integer id) {
        return utenteRepository.findById(id).get();
    }

    public Utente save(Utente u) {
        return utenteRepository.save(u);
    }


    public void delete(Integer id) {
        utenteRepository.deleteById(id);
    }

    public Integer DTOToId(LoginRequest loginRequest){
        return utenteRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword()).getId();
    }
}
