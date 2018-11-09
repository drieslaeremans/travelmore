package be.thomasmore.travelmore.dto;

import java.io.Serializable;

public class LocatieDto implements Serializable {
    private int id;
    private String stadnaam;
    private String landNaam;


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

    public String getLandNaam() {
        return landNaam;
    }

    public void setLandNaam(String landNaam) {
        this.landNaam = landNaam;
    }
}
