package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.*;
import be.thomasmore.travelmore.service.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class LandController {

    @Inject
    private LandService landService;
    @Inject
    private LocatieService locatieService;
    @Inject
    private ReisService reisService;
    @Inject
    private BoekingService boekingService;
    @Inject
    private GebruikerService gebruikerService;
    @Inject
    private KlantService klantService;

    public List<Land> getLanden() {
        return landService.findAllLandenMetRelaties();
    }

    public List<Locatie> getLocaties() {
        return locatieService.findAllLocatiesMetRelaties();
    }

    public List<String> getLandEnStadLocaties() {
        return locatieService.findAllLocatiesLandEnStadNaam();
    }

    public List<Reis> getReizen() {
        return reisService.findAllReizenMetRelaties();
    }

    public List<Boeking> getBoekings() {
        return boekingService.findAllBoekings();
    }

    public List<Gebruiker> getGebruikers() {
        return gebruikerService.findAllGebruikers();
    }

    public List<Klant> getKlanten() { return klantService.findAllKlanten(); }
}
