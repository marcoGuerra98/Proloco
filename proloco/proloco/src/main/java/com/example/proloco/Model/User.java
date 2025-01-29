package com.example.proloco.Model;

import com.example.proloco.Bean.Anagrafica;

public class User {

    private int id;
    private Anagrafica anagrafica;
    private String email;
    private String numeroCellulare;
    private String statoIscrizione;


    public User() {}
    public User(int id, Anagrafica anagrafica, String email, String numeroCellulare, String statoIscrizione) {
        this.id = id;
        this.anagrafica = anagrafica;
        this.email = email;
        this.numeroCellulare = numeroCellulare;
        this.statoIscrizione = statoIscrizione;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Anagrafica getAnagrafica() {
        return anagrafica;
    }

    public void setAnagrafica(Anagrafica anagrafica) {
        this.anagrafica = anagrafica;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroCellulare() {
        return numeroCellulare;
    }

    public void setNumeroCellulare(String numeroCellulare) {
        this.numeroCellulare = numeroCellulare;
    }

    public String getStatoIscrizione() {return statoIscrizione;}

    public void setStatoIscrizione(String statoIscrizione) {this.statoIscrizione = statoIscrizione;}
}
