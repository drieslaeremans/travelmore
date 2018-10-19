package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "REISTYPE", discriminatorType = DiscriminatorType.STRING)
@Entity
@Table(name = "reis")
@NamedQueries({
        @NamedQuery(
                name = Reis.FIND_ALL,
                query = "SELECT r from Reis r"
        ),
        @NamedQuery(
                name = Reis.FIND_ALL_BY_VERTREK_ADRES,
                query = "SELECT r from Reis r WHERE r.naam = :naam"
        )
})
public class Reis {
    public static final String FIND_ALL = "Reis.findAll";
    public static final String FIND_ALL_BY_VERTREK_ADRES = "Reis.findAllByVertrekAdres";

    @Id
    private int id;
    @Column(name = "naam")
    private String naam;
    @Column(name = "startDatum")
    @Temporal(TemporalType.DATE)
    private Date startDatum;
    @Column(name = "eindDatum")
    @Temporal(TemporalType.DATE)
    private Date eindDatum;
    @Column(name = "prijsPerPersoon")
    private double prijsPerPersoon;
    @Column(name = "aantalPlaatsen")
    private int aantalPlaatsen;

    @ManyToOne
    @JoinColumn(name = "vertrekLocatieId", referencedColumnName = "id")
    private Locatie vertrekLocatie;

    @ManyToOne
    @JoinColumn(name = "aankomstLocatieId", referencedColumnName = "id")
    private Locatie aankomstLocatie;

    @OneToMany(mappedBy = "reis")
    private List<Boeking> boekings = new ArrayList<Boeking>();

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

    public Date getStartDatum() {
        return startDatum;
    }

    public void setStartDatum(Date startDatum) {
        this.startDatum = startDatum;
    }

    public Date getEindDatum() {
        return eindDatum;
    }

    public void setEindDatum(Date eindDatum) {
        this.eindDatum = eindDatum;
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

    public Locatie getVertrekLocatie() {
        return vertrekLocatie;
    }

    public void setVertrekLocatie(Locatie vertrekLocatie) {
        this.vertrekLocatie = vertrekLocatie;
    }

    public Locatie getAankomstLocatie() {
        return aankomstLocatie;
    }

    public void setAankomstLocatie(Locatie aankomstLocatie) {
        this.aankomstLocatie = aankomstLocatie;
    }

    public List<Boeking> getBoekings() {
        return boekings;
    }

    public void setBoekings(List<Boeking> boekings) {
        this.boekings = boekings;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
