package com.eng.progetto_finale_eng.service;

import com.eng.progetto_finale_eng.model.UtenteHasLibro;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public interface UtenteHasLibroService {

    public List<UtenteHasLibro> getOwnings(Integer idLibro);

    public void returnBook(Integer idLibro);

    public UtenteHasLibro setOwner(Integer idLibro, Integer idUtente);
}
