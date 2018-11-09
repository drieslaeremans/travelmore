package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.*;
import be.thomasmore.travelmore.service.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class ReisController {

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

    private List<Reis> filteredReisList;

    public List<Land> getLanden() {
        return landService.findAllLanden();
    }

    public List<Land> getLandenMetRelaties() {
        return landService.findAllLandenMetRelaties();
    }

    public List<Locatie> getLocaties() {
        return locatieService.findAllLocatiesMetRelaties();
    }

    public List<Reis> getReizen() {
        return reisService.findAllReizen();
    }

    public List<Reis> getReizenMetRelaties() {
        return reisService.findAllReizenMetRelaties();
    }

    public List<Boeking> getBoekings() {
        return boekingService.findAllBoekings();
    }

    public List<Gebruiker> getGebruikers() {
        return gebruikerService.findAllGebruikers();
    }

    public List<Reis> zoekOpVertrekLocatie(String vertrekLocatie) {
        return reisService.findAllReizenByVertrekLocatie(vertrekLocatie);
    }

    public List<Reis> getFilteredReisList() {
        return filteredReisList;
    }

    public void setFilteredReisList(List<Reis> filteredReisList) {
        this.filteredReisList = filteredReisList;
    }

}
