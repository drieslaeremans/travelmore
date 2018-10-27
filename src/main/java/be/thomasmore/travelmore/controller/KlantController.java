package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.SessionUtils;
import be.thomasmore.travelmore.domain.Klant;
import be.thomasmore.travelmore.service.KlantService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class KlantController {

    @Inject
    private KlantService klantService;

    private Klant klant;

    HttpSession session = SessionUtils.getSession();

    public Klant getKlant() {
        return klantService.findKlantById(Integer.parseInt(session.getAttribute("id").toString()));
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }
}
