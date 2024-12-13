package com.eng.progetto_finale_eng.controller;

import com.eng.progetto_finale_eng.model.Libro;
import com.eng.progetto_finale_eng.model.Utente;
import com.eng.progetto_finale_eng.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/libri")
@CrossOrigin
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> findAll(){
        return libroService.findAll();
    }

    @GetMapping("/id")
    public Libro findById(@RequestParam Integer id){
        return libroService.findById(id);
    }

    @PostMapping
    public Libro save(@RequestBody Libro libro){
        return libroService.save( libro );
    }
    @DeleteMapping("/id")
    public void delete(@RequestParam Integer id){
        libroService.delete(id);
    }
}

