package com.eng.progetto_finale_eng.repository;

import com.eng.progetto_finale_eng.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer> {
    Utente findByEmailAndPassword(String email, String password);

    Optional<Utente> findByEmail(String email);
}
