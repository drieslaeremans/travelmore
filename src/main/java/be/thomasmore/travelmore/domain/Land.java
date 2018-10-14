package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "land")
public class Land {

    @Id
    private int id;
    @Column(name = "naam")
    private String naam;

    @OneToMany(mappedBy = "team")
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
}
