package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Boeking;
import be.thomasmore.travelmore.repository.BoekingRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class BoekingService {

    @Inject
    private BoekingRepository boekingRepository;

    public Boeking findBoekingById(int id) {
        return boekingRepository.findById(id);
    }

    public List<Boeking> findAllBoekings() {
        return boekingRepository.findAll();
    }

    public void updateAantalPersonen(int id, int nieuwAantal) {
        Boeking boeking = boekingRepository.findById(id);
        boeking.setAantalPersonen(nieuwAantal);
    }

    public void insertBoeking(Boeking boeking) {
        boekingRepository.insert(boeking);
    }

//    public List<Boeking> findAllBoekingsByKlantId( int klantId) {
////        return boekingRepository.findAllByKlantId(klantId);
////    }

    public void updateStatusBetaald(int id) {
        Boeking boeking = boekingRepository.findById(id);
        boeking.setBetaald(true);
    }
}
