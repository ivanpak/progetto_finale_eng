package com.eng.progetto_finale_eng.controller;

import com.eng.progetto_finale_eng.model.Libro;
import com.eng.progetto_finale_eng.model.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/libri")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> findAll(){
        return libroService.findAll();
    }

    @GetMapping("/id")
    public Utente findById(@RequestParam String id){
        return libroService.findById(id);
    }

    @PostMapping
    public Utente save(@RequestBody Utente utente){
        return libroService.save( utente );
    }
    @DeleteMapping("/id")
    public void delete(@RequestParam String id){
        libroService.delete(id);
    }
}

