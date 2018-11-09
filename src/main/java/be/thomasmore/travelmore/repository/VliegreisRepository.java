package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Vliegreis;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class VliegreisRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Vliegreis findById(int id) {
        return entityManager.find(Vliegreis.class, id);
    }

}
