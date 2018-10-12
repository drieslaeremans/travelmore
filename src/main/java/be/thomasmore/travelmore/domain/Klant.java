package be.thomasmore.travelmore.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Klant")
@DiscriminatorValue("Klant")
public class Klant extends Gebruiker {

    @Column(name = "adres")
    private String adres;
    @Column(name = "geboorteDatum")
    private Date geboorteDatum;

    public Klant() {
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public Date getGeboorteDatum() {
        return geboorteDatum;
    }

    public void setGeboorteDatum(Date geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }
}
