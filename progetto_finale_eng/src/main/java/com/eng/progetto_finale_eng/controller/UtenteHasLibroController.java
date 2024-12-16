package com.eng.progetto_finale_eng.controller;

import com.eng.progetto_finale_eng.model.UtenteHasLibro;
import com.eng.progetto_finale_eng.service.UtenteHasLibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/ownership")
public class UtenteHasLibroController {

    @Autowired
    private UtenteHasLibroService utenteHasLibroService;

    @GetMapping
    public List<UtenteHasLibro> findAll() {
        return utenteHasLibroService.findAll();
    }

    @GetMapping("/{idLibro}")
    public List<UtenteHasLibro> getOwnings(@PathVariable("idLibro") Integer idLibro) {
        return utenteHasLibroService.findByIdLibro(idLibro);
    }

    @PostMapping("/{idLibro}")
    public void returnBook(@PathVariable("idLibro") Integer idLibro) {
        utenteHasLibroService.returnBook(idLibro);
    }

    @PostMapping("/{idLibro}/{idUtente}")
    public UtenteHasLibro setOwner(@PathVariable("idLibro") Integer idLibro, @PathVariable("idUtente") Integer idUtente) {
        return utenteHasLibroService.setOwner(idLibro, idUtente);
    }
}