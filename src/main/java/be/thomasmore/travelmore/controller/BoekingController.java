package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Boeking;
import be.thomasmore.travelmore.domain.Klant;
import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.service.BoekingService;
import be.thomasmore.travelmore.service.KlantService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

@ManagedBean
@SessionScoped
public class BoekingController {

    @Inject
    private BoekingService boekingService;
    @Inject
    private KlantService klantService;

    private Boeking nieuweBoeking = new Boeking();

    public Boeking getNieuweBoeking() {
        return nieuweBoeking;
    }

    public void setNieuweBoeking(Boeking nieuweBoeking) {
        this.nieuweBoeking = nieuweBoeking;
    }

    public String boeken(Reis reis) {
        nieuweBoeking = new Boeking();
        nieuweBoeking.setReis(reis);
        nieuweBoeking.setKlant(klantService.findKlantById(3));
        nieuweBoeking.setAantalPersonen(50);
        return "boeken";
    }

    public String boekingAanmaken() {
        boekingService.insertBoeking(nieuweBoeking);
        System.out.println("Boeking " + nieuweBoeking.getReis().getNaam() + " aangemaakt");
        return this.toonBevestiging();
    }

    public String toonBevestiging( ) {

        return "bevestiging";
    }
}
