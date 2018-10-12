package be.thomasmore.travelmore.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Busreis")
public class Busreis extends Reis {

    @Column(name = "aantalKilometer")
    private int aantalKilometer;
    @Column(name = "vertrekAdres")
    private String vertrekAdres;
    @Column(name = "aankomstAdres")
    private String aankomstAdres;

    public Busreis() {
    }

    public int getAantalKilometer() {
        return aantalKilometer;
    }

    public void setAantalKilometer(int aantalKilometer) {
        this.aantalKilometer = aantalKilometer;
    }

    public String getVertrekAdres() {
        return vertrekAdres;
    }

    public void setVertrekAdres(String vertrekAdres) {
        this.vertrekAdres = vertrekAdres;
    }

    public String getAankomstAdres() {
        return aankomstAdres;
    }

    public void setAankomstAdres(String aankomstAdres) {
        this.aankomstAdres = aankomstAdres;
    }
}
