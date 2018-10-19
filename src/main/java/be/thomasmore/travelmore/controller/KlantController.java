package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Klant;
import be.thomasmore.travelmore.service.KlantService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

@ManagedBean
@SessionScoped
public class KlantController {

    @Inject
    private KlantService klantService;

    private Klant klant = klantService.findKlantById(3);

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }
}
