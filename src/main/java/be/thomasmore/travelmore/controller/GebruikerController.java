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
    private GebruikerService gebruikerService;


    public GebruikerService getGebruikerService() {
        return gebruikerService;
    }

    public void setGebruikerService(GebruikerService gebruikerService) {
        this.gebruikerService = gebruikerService;
    }

    public String inloggen(String email, String wachtwoord) {

        Gebruiker gebruiker = new Gebruiker();
        gebruiker = gebruikerService.validate(email, wachtwoord);

        if(gebruiker != null){

            HttpSession session = SessionUtils.getSession();

            session.setAttribute("id", gebruiker.getId());
            session.setAttribute("naam", gebruiker.getNaam());
            session.setAttribute("email", gebruiker.getEmail());

            return "reis";
        }


        return "inloggen";
    }

    public String registreren(String naam, String geboorteDatum, String email, String wachtwoord) {
        Gebruiker gebruiker = new Klant();
        Date date = new Date();

        DateFormat format = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy");
        try {
            date = format.parse(geboorteDatum);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        gebruiker.setNaam(naam);
        ((Klant) gebruiker).setGeboortedatum(date);
        gebruiker.setEmail(email);
        gebruiker.setWachtwoord(wachtwoord);

        gebruikerService.insertGebruiker(gebruiker);

        return "login";

    }

    public String uitloggen () {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "inloggen";
    }
}
