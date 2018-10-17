package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Boeking;
import be.thomasmore.travelmore.domain.Land;
import be.thomasmore.travelmore.domain.Locatie;
import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.service.BoekingService;
import be.thomasmore.travelmore.service.LandService;
import be.thomasmore.travelmore.service.LocatieService;
import be.thomasmore.travelmore.service.ReisService;

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

    public List<Land> getLanden() {
        return landService.findAllLanden();
    }

    public List<Locatie> getLocaties() {
        return locatieService.findAllLocaties();
    }

    public List<Reis> getReizen() {
        return reisService.findAllReizen();
    }

    public List<Boeking> getBoekings() {
        return boekingService.findAllBoekings();
    }
}
