package com.example.proloco.Bean;

import java.util.Date;

public class Anagrafica {

    private String nome;
    private String cognome;
    private String sesso;
    private String caricaSociale;
    private String dataIscrizione;
    private String codiceFiscale;
    private String dataNascita;
    private String comuneNascita;
    private String statoEsteroNascita;
    private String comuneEsteroNascita;
    private String comune;
    private String indirizzo;
    private String cap;


    public Anagrafica() {}

    public Anagrafica(String nome, String cognome, String sesso, String caricaSociale, String dataIscrizione, String codiceFiscale, String dataNascita, String comuneNascita, String statoEsteroNascita, String comuneEsteroNascita, String comune, String indirizzo, String cap) {
        this.nome = nome;
        this.cognome = cognome;
        this.sesso = sesso;
        this.caricaSociale = caricaSociale;
        this.dataIscrizione = dataIscrizione;
        this.codiceFiscale = codiceFiscale;
        this.dataNascita = dataNascita;
        this.comuneNascita = comuneNascita;
        this.statoEsteroNascita = statoEsteroNascita;
        this.comuneEsteroNascita = comuneEsteroNascita;
        this.comune = comune;
        this.indirizzo = indirizzo;
        this.cap = cap;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getSesso() { return sesso; }

    public void setSesso(String sesso) { this.sesso = sesso; }

    public String getCaricaSociale() { return caricaSociale; }

    public void setCaricaSociale(String caricaSociale) { this.caricaSociale = caricaSociale; }

    public String getDataIscrizione() { return dataIscrizione; }

    public void setDataIscrizione(String dataIscrizione) { this.dataIscrizione = dataIscrizione; }

    public String getComuneNascita() { return comuneNascita; }

    public void setComuneNascita(String comuneNascita) { this.comuneNascita = comuneNascita; }

    public String getStatoEsteroNascita() { return statoEsteroNascita; }

    public void setStatoEsteroNascita(String statoEsteroNascita) { this.statoEsteroNascita = statoEsteroNascita; }

    public String getComuneEsteroNascita() { return comuneEsteroNascita; }

    public void setComuneEsteroNascita(String comuneEsteroNascita) { this.comuneEsteroNascita = comuneEsteroNascita; }

    public String getComune() { return comune; }

    public void setComune(String comune) { this.comune = comune; }

    public String getCap() { return cap; }

    public void setCap(String cap) { this.cap = cap; }
}
