package be.thomasmore.travelmore.dto;

import be.thomasmore.travelmore.domain.Locatie;

import java.io.Serializable;
import java.util.List;

public class LandDto implements Serializable {
    private int id;
    private String naam;


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
