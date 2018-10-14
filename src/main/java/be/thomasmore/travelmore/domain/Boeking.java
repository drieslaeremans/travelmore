package be.thomasmore.travelmore.domain;

import javax.persistence.*;

@Entity
@Table(name = "boeking")
public class Boeking {

    @Id
    private int id;
    @Column(name = "aantalPersonen")
    private int aantalPersonen;
    @Column(name = "betaald")
    private boolean betaald;

    @ManyToOne
    @JoinColumn(name = "reisId")
    private Reis reis;

    @ManyToOne
    @JoinColumn(name = "klantId")
    private Klant klant;

    public Boeking() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAantalPersonen() {
        return aantalPersonen;
    }

    public void setAantalPersonen(int aantalPersonen) {
        this.aantalPersonen = aantalPersonen;
    }

    public boolean isBetaald() {
        return betaald;
    }

    public void setBetaald(boolean betaald) {
        this.betaald = betaald;
    }

    public Reis getReis() {
        return reis;
    }

    public void setReis(Reis reis) {
        this.reis = reis;
    }

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }


}
