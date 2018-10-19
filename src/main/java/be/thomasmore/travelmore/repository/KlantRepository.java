package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Klant;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class KlantRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Klant findById(int id) {
        return entityManager.find(Klant.class, id);
    }

    public List<Klant> findAllKlanten() {
        return entityManager.createNamedQuery(Klant.FIND_ALL, Klant.class).getResultList();
    }

    public void insert(Klant klant) {
        entityManager.persist(klant);
    }
}
