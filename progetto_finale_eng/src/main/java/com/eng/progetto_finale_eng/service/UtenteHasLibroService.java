package com.eng.progetto_finale_eng.service;

import com.eng.progetto_finale_eng.model.UtenteHasLibro;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public interface UtenteHasLibroService {

    public List<UtenteHasLibro> findAll();
    public List<UtenteHasLibro> findByIdLibro(Integer idLibro);

    public void returnBook(Integer idLibro);

    public UtenteHasLibro setOwner(Integer idLibro, Integer idUtente);
}
