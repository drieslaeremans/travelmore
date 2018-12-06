package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.SessionUtils;
import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.domain.Klant;
import be.thomasmore.travelmore.service.*;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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
            session.setAttribute("type", gebruiker.getClass().getSimpleName());

            return "reis";
        } else {
            error();
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

        registered();
        return "login";

    }

    public void uitloggen () throws IOException {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(ec.getRequestContextPath() + "/reis.xhtml");
    }

    public void error() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Foute login gegevens."));
    }

    public void registered() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Succesvol",  "De gebruiker is geregistreerd.") );    }
}
