package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Klant;
import be.thomasmore.travelmore.repository.KlantRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class KlantService {

    @Inject
    private KlantRepository klantRepository;

    public Klant findKlantById(int id) {
        return klantRepository.findById(id);
    }

    public List<Klant> findAllKlanten() {
        return klantRepository.findAllKlanten();
    }

    public void insertKlant(Klant klant) {
        klantRepository.insert(klant);
    }
}
