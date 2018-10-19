package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "locatie")
@NamedQueries({
        @NamedQuery(
                name = Locatie.FIND_ALL,
                query = "SELECT l from Locatie l"
        ),
        @NamedQuery(
                name = Locatie.FIND_BY_STADNAAM,
                query = "select l from Locatie l where l.stadnaam = :stadnaam"
        )
})
public class Locatie {
    public static final String FIND_ALL = "Location.findAll";
    public static final String FIND_BY_STADNAAM = "Location.findByStadnaam";

    @Id
    private int id;

    @Column(name = "stadnaam")
    private String stadnaam;

    @ManyToOne
    @JoinColumn(name = "landId", referencedColumnName = "id")
    private Land land;

    @OneToMany(mappedBy = "vertrekLocatie", fetch = FetchType.EAGER)
    private List<Reis> vertrekkendeReizen = new ArrayList<Reis>();

    @OneToMany(mappedBy = "aankomstLocatie", fetch = FetchType.EAGER)
    private List<Reis> aankomendeReizen = new ArrayList<Reis>();

    public Locatie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStadnaam() {
        return stadnaam;
    }

    public void setStadnaam(String stadnaam) {
        this.stadnaam = stadnaam;
    }

    public Land getLand() {
        return land;
    }

    public void setLand(Land land) {
        this.land = land;
    }

    public List<Reis> getVertrekkendeReizen() {
        return vertrekkendeReizen;
    }

    public void setVertrekkendeReizen(List<Reis> vertrekkendeReizen) {
        this.vertrekkendeReizen = vertrekkendeReizen;
    }

    public List<Reis> getAankomendeReizen() {
        return aankomendeReizen;
    }

    public void setAankomendeReizen(List<Reis> aankomendeReizen) {
        this.aankomendeReizen = aankomendeReizen;
    }

    public String getLandEnStadNaam() { return land.getNaam() + ", " + stadnaam; }
}
