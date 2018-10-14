package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Locatie;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class LocatieRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Locatie findLocatieById(int id) {
        return entityManager.find(Locatie.class, id);
    }

    public List<Locatie> findAllLocaties() {
        return entityManager.createNamedQuery(Locatie.FIND_ALL, Locatie.class).getResultList();
    }

    public void insertLocatie(Locatie locatie) {
        entityManager.persist(locatie);
    }
}
