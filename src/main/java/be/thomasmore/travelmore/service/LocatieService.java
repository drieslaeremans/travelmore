package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Locatie;
import be.thomasmore.travelmore.dto.LocatieDto;
import be.thomasmore.travelmore.repository.LocatieRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class LocatieService {

    @Inject
    private LocatieRepository locatieRepository;

    public Locatie findLocatieById(int id) {
        return locatieRepository.findById(id);
    }

    public LocatieDto findLocatieDtoById(int id) {
        Locatie locatie = locatieRepository.findById(id);
        LocatieDto dto = new LocatieDto();
        dto.setId(locatie.getId());
        dto.setLandNaam(locatie.getLand().getNaam());
        dto.setStadnaam(locatie.getStadnaam());
        return dto;
    }

    public List<Locatie> findAllLocaties() {
        return locatieRepository.findAll();
    }

    public List<LocatieDto> findAllLocatiesDto() {
        List<LocatieDto> dtos = new ArrayList<>();
        for (Locatie locatie : locatieRepository.findAll()) {
            LocatieDto dto = new LocatieDto();
            dto.setId(locatie.getId());
            dto.setLandNaam(locatie.getLand().getNaam());
            dto.setStadnaam(locatie.getStadnaam());
            dtos.add(dto);
        }
        return dtos;
    }

    public List<Locatie> findAllLocatiesMetRelaties() {
        List<Locatie> locaties = locatieRepository.findAll();
        for (Locatie l : locaties) {
            l.getAankomendeReizen().size();
            l.getVertrekkendeReizen().size();
        }

        return locaties;
    }

    public List<String> findAllLocatiesLandEnStadNaam() {
        List<Locatie> locaties = locatieRepository.findAll();
        List<String> locatiesLandEnStadNaam = new ArrayList<>();
        for (Locatie l : locaties) {
            locatiesLandEnStadNaam.add(l.getLandEnStadNaam());
        }

        return locatiesLandEnStadNaam;
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
    public void removeLocatie(int id){
        Locatie locatie = locatieRepository.findById(id);
        locatieRepository.delete(locatie);
    }
}
