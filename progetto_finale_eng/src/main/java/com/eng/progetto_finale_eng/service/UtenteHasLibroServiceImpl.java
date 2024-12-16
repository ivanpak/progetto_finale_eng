package com.eng.progetto_finale_eng.service;

import com.eng.progetto_finale_eng.model.Utente;
import com.eng.progetto_finale_eng.model.UtenteHasLibro;
import com.eng.progetto_finale_eng.repository.UtenteHasLibroRepository;
import com.eng.progetto_finale_eng.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UtenteHasLibroServiceImpl implements UtenteHasLibroService {

    @Autowired
    private UtenteHasLibroRepository utenteHasLibroRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    public List<UtenteHasLibro> findAll() {
        return utenteHasLibroRepository.findAll();
    }

    public List<UtenteHasLibro> findByIdLibro(Integer idLibro) {
        return utenteHasLibroRepository.findByIdLibro(idLibro);
    }


    /*public Utente getCurrentOwner(Integer idLibro) {
        List<UtenteHasLibro> ownings = utenteHasLibroRepository.findByIdLibro(idLibro);
        UtenteHasLibro currentOwning = ownings.stream().filter(o -> o.getData_di_fine() == null).findFirst().orElseThrow(RuntimeException::new);
        return utenteRepository.findById(currentOwning.getIdUtente()).orElseThrow(RuntimeException::new);
    }*/

    public void returnBook(Integer idLibro) {
        List<UtenteHasLibro> ownings = utenteHasLibroRepository.findByIdLibro(idLibro);
        UtenteHasLibro currentOwning = ownings.stream().filter(o -> o.getData_di_fine() == null).findFirst().orElseThrow(RuntimeException::new);
        currentOwning.setData_di_fine(Date.from(Instant.now()));
        utenteHasLibroRepository.save(currentOwning);
    }

    public UtenteHasLibro setOwner(Integer idLibro, Integer idUtente) {
        List<UtenteHasLibro> ownings = utenteHasLibroRepository.findByIdLibro(idLibro);
        List<UtenteHasLibro> pendingOwnings = ownings.stream().filter(o -> o.getData_di_fine() == null).toList();
        if(pendingOwnings.size()>0) {
            throw new RuntimeException();
        } else {
            return utenteHasLibroRepository.save(new UtenteHasLibro(idUtente, idLibro, Date.from(Instant.now()), null));
        }

    }
}
