package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Locatie;
import be.thomasmore.travelmore.repository.LocatieRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class LocatieService {

    @Inject
    private LocatieRepository locatieRepository;

    public Locatie findLocatieById(int id) {
        return locatieRepository.findById(id);
    }

    public List<Locatie> findAllLocaties() {
        return locatieRepository.findAll();
    }

    public List<Locatie> findAllLocatiesMetRelaties() {
        List<Locatie> locaties = locatieRepository.findAll();
        for (Locatie l : locaties) {
            l.getAankomendeReizen().size();
            l.getVertrekkendeReizen().size();
        }

        return locaties;
    }

    public Locatie findLocatieByStadnaam(String stadnaam) {
        return locatieRepository.findByNaam(stadnaam);
    }

    public void updateStadnaam(int id, String nieuweStadnaam) {
            Locatie locatie = locatieRepository.findById(id);
            locatie.setStadnaam(nieuweStadnaam);
    }

    public void insertLocatie(Locatie locatie) {
        locatieRepository.insert(locatie);
    }
}
