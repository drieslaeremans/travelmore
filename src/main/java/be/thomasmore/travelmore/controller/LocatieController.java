package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Locatie;
import be.thomasmore.travelmore.service.LocatieService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class LocatieController {

    private Locatie nieuweLocatie = new Locatie();

    @Inject
    private LocatieService locatieService;

    public Locatie getNieuweLocatie() {
        return nieuweLocatie;
    }

    public void setNieuweLocatie(Locatie nieuweLocatie) {
        this.nieuweLocatie = nieuweLocatie;
    }

    public List<Locatie> getLocaties() {
        return locatieService.findAllLocaties();
    }
}
