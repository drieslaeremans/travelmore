package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Land;
import be.thomasmore.travelmore.domain.Locatie;
import be.thomasmore.travelmore.dto.LandDto;
import be.thomasmore.travelmore.repository.LandRepository;
import be.thomasmore.travelmore.repository.LocatieRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Stateless
public class LandService {

    @Inject
    private LandRepository landRepository;
    private LocatieRepository locatieRepository;

    public Land findLandById(int id) {
        return landRepository.findById(id);
    }

    public LandDto findLandDtoById(int id) {
        Land land = landRepository.findById(id);
        LandDto dto = new LandDto();
        dto.setId(land.getId());
        dto.setNaam(land.getNaam());
        return dto;
    }

    public List<Land> findAllLanden() {
        return landRepository.findAll();
    }

    public List<Land> findAllLandenMetRelaties() {
        List<Land> landen = landRepository.findAll();
        for (Land l : landen) {
            l.getLocaties().size();
        }

        return landen;
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
