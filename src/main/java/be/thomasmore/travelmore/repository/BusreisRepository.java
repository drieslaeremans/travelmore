package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Busreis;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BusreisRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Busreis findById(int id) {
        return entityManager.find(Busreis.class, id);
    }

}