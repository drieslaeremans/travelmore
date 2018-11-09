package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.repository.ReisRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ReisService {

    @Inject
    ReisRepository reisRepository;

    public Reis findReisById(int id) {
        return reisRepository.findById(id);
    }

    public Reis findReisByIdMetRelaties(int id) {
        Reis r = reisRepository.findById(id);
        r.getBoekings().size();

        return r;
    }

    public List<Reis> findAllReizen() {
        return reisRepository.findAll();
    }

    public List<Reis> findAllReizenMetRelaties() {
        List<Reis> reizen = reisRepository.findAll();
        for (Reis r : reizen) {
            r.getBoekings().size();
        }

        return reizen;
    }

    public List<Reis> findAllReizenByVertrekLocatie(String vertrekLocatie) { return reisRepository.findAllByVertrekLocation(vertrekLocatie);}

    public List<Reis> findAllReizenByVertrekLocatieMetRelaties(String vertrekLocatie) {
        List<Reis> reizen = reisRepository.findAllByVertrekLocation(vertrekLocatie);
        for (Reis r : reizen) {
            r.getBoekings().size();
        }

        return reizen;
    }


}
