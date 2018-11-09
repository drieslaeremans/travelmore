package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Busreis;
import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.repository.BusreisRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class BusreisService {

    @Inject
    BusreisRepository busreisRepository;

    public Busreis findBusreisById(int id) {
        return busreisRepository.findById(id);
    }

}
