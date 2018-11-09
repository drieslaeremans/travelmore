package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Vliegreis;
import be.thomasmore.travelmore.repository.VliegreisRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class VliegreisService {

    @Inject
    VliegreisRepository vliegreisRepository;

    public Vliegreis findVliegreisById(int id) {
        return vliegreisRepository.findById(id);
    }
}
