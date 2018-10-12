package be.thomasmore.travelmore.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class LocatieController {

    private Locatie newLocatie = new Locatie();

    @Inject
    private LocatieService locatieService;

    public Location getNewLocatie() {
        return newLocatie;
    }

    public void setNewLocatie(Locatie newLocatie) {
        this.newLocatie = newLocatie;
    }

    public List<Locatie> getLocaties(){
        return this.locatieService.findAllLocaties();
    }

    public void addTestLocaties(){
        //maak een nieuwe locatie aan
        Locatie eersteLocatie = new Locatie();

        //maak een nieuwe stad aan genaamd geel
        Stad geel = new stad();

        //geef geel de naam Geel
        geel.setNaam("Geel");

        //maak een nieuw land aan genaamd belgie
        Land belgie = new Land();

        //geef belgie de naam Belgie
        belgie.setNaam("Belgie");

        //geef de stad geel het land belgie
        geel.setLand(belgie);

        this.submit();

    }

    public void submit(){
        this.locatieService.insert(newLocatie);
    }

}
