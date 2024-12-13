package com.eng.progetto_finale_eng.service;

import com.eng.progetto_finale_eng.model.Libro;
import org.springframework.stereotype.Service;

import java.util.List;


public interface LibroService {
    public List<Libro> findAll();

    public Libro findById(Integer id);

    public Libro save(Libro l);


    public void delete(Integer id);
}
