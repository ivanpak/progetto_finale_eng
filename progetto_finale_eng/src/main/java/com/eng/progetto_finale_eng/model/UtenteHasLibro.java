package com.eng.progetto_finale_eng.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class UtenteHasLibro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer idUtente;
    Integer idLibro;
    Date data_di_inizio;
    Date data_di_fine;

    public UtenteHasLibro(Integer idUtente, Integer idLibro, Date data_di_inizio, Date data_di_fine) {
        this.idUtente = idUtente;
        this.idLibro = idLibro;
        this.data_di_inizio = data_di_inizio;
        this.data_di_fine = data_di_fine;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Integer idUtente) {
        this.idUtente = idUtente;
    }

    public Integer getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public Date getData_di_inizio() {
        return data_di_inizio;
    }

    public void setData_di_inizio(Date data_di_inizio) {
        this.data_di_inizio = data_di_inizio;
    }

    public Date getData_di_fine() {
        return data_di_fine;
    }

    public void setData_di_fine(Date data_di_fine) {
        this.data_di_fine = data_di_fine;
    }
}
