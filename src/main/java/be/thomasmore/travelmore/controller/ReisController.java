package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.*;
import be.thomasmore.travelmore.service.*;
import org.primefaces.util.DateUtils;
import sun.swing.BakedArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@ManagedBean
@ViewScoped
public class ReisController {

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
    @Inject
    private BusreisService busreisService;
    @Inject
    private VliegreisService vliegreisService;

    private List<Reis> filteredReisList;

    public List<Land> getLanden() {
        return landService.findAllLanden();
    }

    public List<Land> getLandenMetRelaties() {
        return landService.findAllLandenMetRelaties();
    }

    public List<Locatie> getLocaties() {
        return locatieService.findAllLocatiesMetRelaties();
    }

    public List<Reis> getReizen() {
        return reisService.findAllReizen();
    }

    public List<Reis> getReizenMetRelaties() {
        return reisService.findAllReizenMetRelaties();
    }

    public List<Boeking> getBoekings() {
        return boekingService.findAllBoekings();
    }

    public List<Gebruiker> getGebruikers() {
        return gebruikerService.findAllGebruikers();
    }

    public List<Reis> getFilteredReisList() {
        return filteredReisList;
    }

    public void setFilteredReisList(List<Reis> filteredReisList) {
        this.filteredReisList = filteredReisList;
    }

    public Busreis getBusreis (int id) {
        return busreisService.findBusreisById(id);
    }

    public Vliegreis getVliegreis (int id) {
        return vliegreisService.findVliegreisById(id);
    }

    public boolean filterByGreater(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if(filterText == null||filterText.equals("")) {
            return true;
        }

        if(value == null) {
            return false;
        }

        return ((Comparable) value).compareTo(Double.valueOf(filterText)) < 0;
    }

    public boolean filterByLesser(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if(filterText == null||filterText.equals("")) {
            return true;
        }

        if(value == null) {
            return false;
        }

        return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
    }

    public boolean filterByDate(Object value, Object filter, Locale locale) {

        if( filter == null || filter == "" || filter == " " ) {
            return true;
        }

        if( value == null ) {
            return false;
        }

        SimpleDateFormat filterFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
        SimpleDateFormat valueFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date filterDate = null;
        Date valueDate = null;

        try {
            filterDate = filterFormat.parse(filter.toString());
            valueDate = valueFormat.parse(value.toString());
        } catch (ParseException e) {
            return false;
        }

        return filterDate.getTime() == valueDate.getTime();
    }

}
