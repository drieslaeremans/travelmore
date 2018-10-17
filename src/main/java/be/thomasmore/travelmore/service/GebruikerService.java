package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.repository.GebruikerRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class GebruikerService {

    @Inject
    private GebruikerRepository gebruikerRepository;

    public Gebruiker findGebruikerById(int id) {
        return gebruikerRepository.findById(id);
    }

    public List<Gebruiker> findAllGebruikers() {
        return gebruikerRepository.findAll();
    }

    public void updateNaam(int id, String nieuweNaam) {
        Gebruiker gebruiker = gebruikerRepository.findById(id);
        gebruiker.setNaam(nieuweNaam);
    }

    public void insertGebruiker(Gebruiker gebruiker) {
        gebruikerRepository.insert(gebruiker);
    }
}
