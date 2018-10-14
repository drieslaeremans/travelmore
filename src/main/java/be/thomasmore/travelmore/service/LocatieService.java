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
        return locatieRepository.findLocatieById(id);
    }

    public List<Locatie> findAllLocaties() {
        return locatieRepository.findAllLocaties();
    }
}
