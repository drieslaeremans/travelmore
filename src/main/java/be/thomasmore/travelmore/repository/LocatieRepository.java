package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Locatie;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class LocatieRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Locatie findById(int id) {
        return entityManager.find(Locatie.class, id);
    }

    public List<Locatie> findAll() {
        return entityManager.createNamedQuery(Locatie.FIND_ALL, Locatie.class).getResultList();
    }

    public Locatie findByNaam(String stadnaam) {
        return entityManager.createNamedQuery(Locatie.FIND_BY_STADNAAM, Locatie.class).setParameter("stadnaam", stadnaam).getSingleResult();
    }

    public void insert(Locatie locatie) {
        entityManager.persist(locatie);
    }

    public void delete(Locatie locatie)
    {
        entityManager.remove(locatie);
    }
}
