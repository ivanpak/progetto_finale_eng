package com.eng.progetto_finale_eng.repository;

import com.eng.progetto_finale_eng.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {

}
