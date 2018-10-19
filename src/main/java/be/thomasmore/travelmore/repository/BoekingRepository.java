package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Boeking;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class BoekingRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Boeking findById(int id) {
        return entityManager.find(Boeking.class, id);
    }

    public List<Boeking> findAll() {
        return entityManager.createNamedQuery(Boeking.FIND_ALL, Boeking.class).getResultList();
    }

    public void insert(Boeking boeking) {
        entityManager.persist(boeking);
    }

//    public List<Boeking> findAllByKlantId(int klantId) {
//        Query q = entityManager.createNamedQuery(Boeking.FIND_ALL_BY_KLANTID, Boeking.class);
//        q.setParameter("klantId", klantId);
//        return q.getResultList();
//    }
}
