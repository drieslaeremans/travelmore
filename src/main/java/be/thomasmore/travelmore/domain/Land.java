package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "land")
@NamedQueries({
        @NamedQuery(
                name = Land.FIND_ALL,
                query = "select l from Land l"
        ),
        @NamedQuery(
                name = Land.FIND_BY_NAAM,
                query = "select l from Land l where l.naam = :naam"
        )
})
@XmlRootElement(name = "land")
public class Land {
    public static final String FIND_ALL = "Land.findAll";
    public static final String FIND_BY_NAAM = "Land.findByNaam";

    @Id
    private int id;
    @Column(name = "naam")
    private String naam;

    @OneToMany(mappedBy = "land")
    private List<Locatie> locaties = new ArrayList<Locatie>();

    public Land() {
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

    public List<Locatie> getLocaties() {
        return locaties;
    }

    public void setLocaties(List<Locatie> locaties) {
        this.locaties = locaties;
    }
}
