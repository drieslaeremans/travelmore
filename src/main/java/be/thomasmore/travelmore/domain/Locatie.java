package be.thomasmore.travelmore.domain;

import javax.persistence.*;

@Entity
@Table(name = "locatie")
@NamedQueries(
        {
                @NamedQuery(
                        name = Locatie.FIND_ALL,
                        query = "SELECT l FROM Locatie l"
                )
        }
)
public class Locatie {
    public static final String FIND_ALL = "Locatie.findAll";

    @Id
    private int id;

    @Column(name = "stadnaam")
    private int stadnaam;

    @ManyToOne
    @JoinColumn(name = "landId")
    private Land land;

    public Locatie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStadnaam() {
        return stadnaam;
    }

    public void setStadnaam(int stadnaam) {
        this.stadnaam = stadnaam;
    }

    public Land getLand() {
        return land;
    }

    public void setLand(Land land) {
        this.land = land;
    }
}
