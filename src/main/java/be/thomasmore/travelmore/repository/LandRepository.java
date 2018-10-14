package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Land;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class LandRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Land findById(int id) {
        return entityManager.find(Land.class, id);
    }

    public Land findByNaam(String naam) {
        return entityManager.createNamedQuery(Land.FIND_BY_NAAM, Land.class).setParameter("naam", naam).getSingleResult();
    }

    public List<Land> findAll() {
        return entityManager.createNamedQuery(Land.FIND_ALL, Land.class).getResultList();
    }

    public void insert(Land land) {
        entityManager.persist(land);
        System.out.println(land.getNaam() + " is opgeslagen");
    }
}
