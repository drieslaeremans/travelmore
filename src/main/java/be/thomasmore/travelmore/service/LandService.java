package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Land;
import be.thomasmore.travelmore.repository.LandRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class LandService {

    @Inject
    private LandRepository landRepository;

    public Land findLandById(int id) {
        return landRepository.findById(id);
    }

    public List<Land> findAllLanden() {
        return landRepository.findAll();
    }

    public Land findLandByNaam(String naam) {
        return landRepository.findByNaam(naam);
    }

    public void updateNaamLand(int id, String nieuweNaam) {
        Land land = landRepository.findById(id);
        land.setNaam(nieuweNaam);
    }

    public void insertLand(Land land) {
        landRepository.insert(land);
    }
}
