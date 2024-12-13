package com.eng.progetto_finale_eng.service;

import com.eng.progetto_finale_eng.model.Libro;
import com.eng.progetto_finale_eng.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    public Libro findById(Integer id) {
        return libroRepository.findById(id).get();
    }

    public Libro save(Libro l) {
        return libroRepository.save(l);
    }


    public void delete(Integer id) {
        libroRepository.deleteById(id);
    }
}
