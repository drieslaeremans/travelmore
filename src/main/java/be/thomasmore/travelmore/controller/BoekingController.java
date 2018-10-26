package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.SessionUtils;
import be.thomasmore.travelmore.domain.Boeking;
import be.thomasmore.travelmore.domain.Klant;
import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.service.BoekingService;
import be.thomasmore.travelmore.service.KlantService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class BoekingController {

    @Inject
    private BoekingService boekingService;
    @Inject
    private KlantService klantService;

    private Boeking nieuweBoeking;

    private Boeking boeking;

    public Boeking getNieuweBoeking() {
        return nieuweBoeking;
    }

    public void setNieuweBoeking(Boeking nieuweBoeking) {
        this.nieuweBoeking = nieuweBoeking;
    }

    public Boeking getBoeking() {
        return boeking;
    }

    public void setBoeking(Boeking boeking) {
        this.boeking = boeking;
    }

    public String boeken(Reis reis) {
        nieuweBoeking = new Boeking();
        nieuweBoeking.setReis(reis);
        HttpSession session = SessionUtils.getSession();
        nieuweBoeking.setKlant(klantService.findKlantById(Integer.parseInt(session.getAttribute("id").toString() )));
        return "boeken";
    }

    public String boekingAanmaken() {
        boekingService.insertBoeking(nieuweBoeking);
        System.out.println("Boeking " + nieuweBoeking.getReis().getNaam() + " aangemaakt");
        return this.toonBevestiging();
    }

    public double berekenPrijs(int personen) {
        return Math.floor(nieuweBoeking.getReis().getPrijsPerPersoon() * personen);
    }

    public String toonBevestiging( ) {

        return "bevestiging";
    }

    public double berekenPrijsBoeking(int personen) {
        return Math.floor(boeking.getReis().getPrijsPerPersoon() * personen);
    }

    public String detailsBoeking(Boeking boeking) {
        this.boeking = boeking;
        return "detailsBoeking";
    }

    public String wijzigStatusBetaald() {
        boekingService.updateStatusBetaald(boeking.getId());
        System.out.println("Boeking " + boeking.getReis().getNaam() + " is betaald");
        this.toonBevestiging();
        return "boekingen";
    }
}
