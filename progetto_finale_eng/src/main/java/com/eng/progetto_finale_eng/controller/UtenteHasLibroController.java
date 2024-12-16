package com.eng.progetto_finale_eng.controller;

import com.eng.progetto_finale_eng.exception.LibroNonPossedutoException;
import com.eng.progetto_finale_eng.exception.LibroNonTrovatoException;
import com.eng.progetto_finale_eng.handler.ApiResponse;
import com.eng.progetto_finale_eng.model.UtenteHasLibro;
import com.eng.progetto_finale_eng.service.UtenteHasLibroService;
import com.eng.progetto_finale_eng.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;

@RestController
@RequestMapping("api/v1/ownership")
@CrossOrigin
public class UtenteHasLibroController {

    @Autowired
    private UtenteHasLibroService utenteHasLibroService;

    @Autowired
    private UtenteService utenteService;

    @GetMapping
    public List<UtenteHasLibro> findAll() {
        return utenteHasLibroService.findAll();
    }

    @GetMapping("/{idLibro}")
    public List<UtenteHasLibro> getOwnings(@PathVariable("idLibro") Integer idLibro) {
        return utenteHasLibroService.findByIdLibro(idLibro);
    }

    @PostMapping("/{idLibro}")
    public ResponseEntity<ApiResponse> returnBook(@PathVariable("idLibro") Integer idLibro) {
        try {
            utenteHasLibroService.returnBook(idLibro);
            return ResponseEntity.ok(new ApiResponse(true, "Libro restituito con successo!"));
        } catch (LibroNonTrovatoException e) {
            // Gestione di un errore specifico quando il libro non è trovato
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(false, "Libro non trovato con ID: " + idLibro));
        } catch (LibroNonPossedutoException e) {
            // Gestione di un errore specifico quando il libro non è posseduto dall'utente
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ApiResponse(false, "Il libro non è posseduto dall'utente."));
        } catch (Exception e) {
            // Gestione di errori generici
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(false, "Errore imprevisto durante la restituzione del libro."));
        }
    }


    @PostMapping("/toUtente/{idLibro}")
    public UtenteHasLibro setOwner(@PathVariable("idLibro") Integer idLibro) {
        for(UtenteHasLibro u: getOwnings(idLibro)){
            if(u.getData_di_fine()==null){
                System.out.println("Libro non disponibile");
                return null;
            }
        }
        if (AuthController.getSession() == null) {
            System.out.println("Nessun utente in sessione");
            return null;
        } else {
            Integer idUtente = utenteService.DTOToId(AuthController.getSession());
            return utenteHasLibroService.setOwner(idLibro, idUtente);
        }

    }
}
