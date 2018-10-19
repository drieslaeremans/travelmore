package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("Klant")
@NamedQueries({
        @NamedQuery(
                name = Klant.FIND_ALL,
                query = "select k from Klant k"
        )
})
public class Klant extends Gebruiker {
    public static final String FIND_ALL = "Klant.findAll";

    @Column(name = "geboortedatum")
    @Temporal(TemporalType.DATE)
    private Date geboortedatum;

    @OneToMany(mappedBy = "klant")
    private List<Boeking> boekings = new ArrayList<Boeking>();

    public Klant() {
    }

    public Date getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(Date geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public List<Boeking> getBoekings() {
        return boekings;
    }

    public void setBoekings(List<Boeking> boekings) {
        this.boekings = boekings;
    }
}
