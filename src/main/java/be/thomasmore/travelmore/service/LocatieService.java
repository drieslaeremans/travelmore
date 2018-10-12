package be.thomasmore.travelmore.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class LocatieService {
    @Inject
    private LocatieRepository locationRepository;

    public Locatie findLocatieById(int id) {
        return LocatieRepository.findById(id);
    }

    public List<Locatie> findAllLocaties() {
        return LocatieRepository.findAll();
    }

    public Locatie findLocationByCode(String code) {
        return LocatieRepository.findByCode(code);
    }

    public void updateName(int id, int landId, int stadId) {
        Locatie locatie = locationRepository.findById(id);
        locatie.setLandId(landId);
        locatie.setStadId(stadId);
    }

    public void insert(Locatie locatie) {
        locationRepository.insert(locatie);
    }

}
