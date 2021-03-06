package be.thomasmore.travelmore.domain;

import javax.persistence.*;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn (name = "GEBRUIKERTYPE", discriminatorType = DiscriminatorType.STRING)
@Entity
@Table(name = "gebruiker")
@NamedQueries({
        @NamedQuery(
                name = Gebruiker.FIND_ALL,
                query = "select g from Gebruiker g"
        ),
        @NamedQuery(
                name = Gebruiker.VALIDATE,
                query = "select g from Gebruiker g where g.email = :email and g.wachtwoord = :wachtwoord"
        )
})
public class Gebruiker {
    public static final String FIND_ALL = "Gebruiker.findAll";
    public static final String VALIDATE = "Gebruiker.validate";

    @Id
    private int id;
    @Column(name = "naam")
    private String naam;
    @Column(name = "email")
    private String email;
    @Column(name = "wachtwoord")
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
