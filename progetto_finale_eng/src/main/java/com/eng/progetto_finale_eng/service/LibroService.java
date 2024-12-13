package com.eng.progetto_finale_eng.service;

import com.eng.progetto_finale_eng.model.Libro;

import java.util.List;

public interface LibroService {
    public List<Libro> findAll();

    public Libro findById(Integer id);

    public Libro save(Libro l);

    public Libro update(Integer id, Libro l);

    public void delete(Integer id);
}
