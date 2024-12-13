package service;

import model.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UtenteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UtenteRepository utenteRepository;

    public boolean authenticate(String email, String password) {

        System.out.println("SONO NEL SERVICE DI AUTH");

        Optional<Utente> utente = utenteRepository.findByEmail(email);

        return utente.isPresent() && utente.get().getPassword().equals(password);
    }

    public List<Utente> getUtenti() {

        return utenteRepository.findAll();
    }
}
