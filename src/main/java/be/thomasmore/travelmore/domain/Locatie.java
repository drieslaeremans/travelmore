package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "locatie")
public class Locatie {

    @Id
    private int id;

    @Column(name = "stadnaam")
    private String stadnaam;

    @ManyToOne
    @JoinColumn(name = "landId", referencedColumnName = "id")
    private Land land;

    @OneToMany(mappedBy = "vertrekLocatie")
    private List<Reis> vertrekkendeReizen = new ArrayList<Reis>();

    @OneToMany(mappedBy = "aankomstLocatie")
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
}
