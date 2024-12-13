package com.eng.progetto_finale_eng.controller;

import com.eng.progetto_finale_eng.model.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/utenti")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    @GetMapping
    public List<Utente> findAll(){
        return utenteService.findAll();
    }

    @GetMapping("/id")
    public Utente findById(@RequestParam String id){
        return utenteService.findById(id);
    }

    @PostMapping
    public Utente save(@RequestBody Utente utente){
        return utenteService.save( utente );
    }
    @DeleteMapping("/id")
    public void delete(@RequestParam String id){
        utenteService.delete(id);
    }
}