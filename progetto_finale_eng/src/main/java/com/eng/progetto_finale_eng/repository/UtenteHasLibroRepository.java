package com.eng.progetto_finale_eng.repository;

import com.eng.progetto_finale_eng.model.Utente;
import com.eng.progetto_finale_eng.model.UtenteHasLibro;
import org.hibernate.annotations.processing.SQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UtenteHasLibroRepository extends JpaRepository<UtenteHasLibro, Integer> {

    /*@SQL("select u.* from Utente as u join UtenteHasLibro as ul on u.id=ul.idUtente where ul.data_di_fine is null")
    Optional<Utente> getCurrentOwner();*/

    List<UtenteHasLibro> findByIdLibro(Integer idLibro);
}
