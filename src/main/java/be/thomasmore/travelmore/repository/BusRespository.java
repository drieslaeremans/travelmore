package be.thomasmore.travelmore.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BusreisRespository {

    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public List<Busreis> findAll() {
        return entityManager.createNamedQuery(Busreis.FIND_ALL, Bus.class).getResultList();
    }
}

