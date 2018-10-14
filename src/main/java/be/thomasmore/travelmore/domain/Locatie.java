package be.thomasmore.travelmore.domain;

import javax.persistence.*;

@Entity

public class Locatie {

    @Id
    private int id;

    @Column(name = "stadnaam")
    private int stadnaam;

    @ManyToOne
    @JoinColumn(name = "landId")
    private Land land;

    public Locatie() {
    }



}
