package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import java.util.Date;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "REISTYPE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Reis")
@Entity
public class Reis {

    @Id
    private int id;
    private String naam;
    private Date datumVertrek;
    private Date datumTerug;
    private double prijsPerPersoon;
    private int aantalPlaatsen;
    private int vertrekLocatieId;
    private int aankomstLocatieId;

    public Reis() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Date getDatumVertrek() {
        return datumVertrek;
    }

    public void setDatumVertrek(Date datumVertrek) {
        this.datumVertrek = datumVertrek;
    }

    public Date getDatumTerug() {
        return datumTerug;
    }

    public void setDatumTerug(Date datumTerug) {
        this.datumTerug = datumTerug;
    }

    public double getPrijsPerPersoon() {
        return prijsPerPersoon;
    }

    public void setPrijsPerPersoon(double prijsPerPersoon) {
        this.prijsPerPersoon = prijsPerPersoon;
    }

    public int getAantalPlaatsen() {
        return aantalPlaatsen;
    }

    public void setAantalPlaatsen(int aantalPlaatsen) {
        this.aantalPlaatsen = aantalPlaatsen;
    }

    public int getVertrekLocatieId() {
        return vertrekLocatieId;
    }

    public void setVertrekLocatieId(int vertrekLocatieId) {
        this.vertrekLocatieId = vertrekLocatieId;
    }

    public int getAankomstLocatieId() {
        return aankomstLocatieId;
    }

    public void setAankomstLocatieId(int aankomstLocatieId) {
        this.aankomstLocatieId = aankomstLocatieId;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
