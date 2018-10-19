package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.SessionUtils;
import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.domain.Klant;
import be.thomasmore.travelmore.service.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@ManagedBean
@ViewScoped
public class GebruikerController {

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

    public LandService getLandService() {
        return landService;
    }

    public void setLandService(LandService landService) {
        this.landService = landService;
    }

    public LocatieService getLocatieService() {
        return locatieService;
    }

    public void setLocatieService(LocatieService locatieService) {
        this.locatieService = locatieService;
    }

    public ReisService getReisService() {
        return reisService;
    }

    public void setReisService(ReisService reisService) {
        this.reisService = reisService;
    }

    public BoekingService getBoekingService() {
        return boekingService;
    }

    public void setBoekingService(BoekingService boekingService) {
        this.boekingService = boekingService;
    }

    public GebruikerService getGebruikerService() {
        return gebruikerService;
    }

    public void setGebruikerService(GebruikerService gebruikerService) {
        this.gebruikerService = gebruikerService;
    }

    public String inloggen(String email, String wachtwoord) {

        Gebruiker gebruiker = new Gebruiker();
        gebruiker = this.gebruikerService.validate(email, wachtwoord);

        if(gebruiker.getEmail() == email && gebruiker.getWachtwoord() == wachtwoord){

            HttpSession session = SessionUtils.getSession();
            session.setAttribute("gebruikersemail", gebruiker.getEmail());
            return "reis";
        }


        return "login_fout";
    }

    public String registreren(String naam, String geboorteDatum, String email, String wachtwoord) {
        Gebruiker gebruiker = new Gebruiker();
        Date date = new Date();

        Klant klant = new Klant();

        DateFormat format = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy");
        try {
            date = format.parse(geboorteDatum);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        klant.setNaam(naam);
        klant.setGeboortedatum(date);
        klant.setEmail(email);
        klant.setWachtwoord(wachtwoord);

        this.gebruikerService.insertGebruiker(klant);

        return "login";

    }
}
