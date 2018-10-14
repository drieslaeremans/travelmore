package be.thomasmore.travelmore.domain;

import javax.persistence.*;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn (name = "GEBRUIKERTYPE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Gebruiker")
@Entity
public class Gebruiker {

    @Id
    private int id;
    private String naam;
    private String email;
    private String wachtwoord;

    public Gebruiker() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
