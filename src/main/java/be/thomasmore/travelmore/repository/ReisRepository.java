package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Reis;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ReisRepository {

    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Reis findById(int id) {
        return entityManager.find(Reis.class, id);
    }

    public List<Reis> findAll() {
        return entityManager.createNamedQuery(Reis.FIND_ALL, Reis.class).getResultList();
    }

    public List<Reis> findAllByVertrekLocation(String vertrekLocatie) {
        return entityManager.createNamedQuery(Reis.FIND_ALL_BY_VERTREK_ADRES, Reis.class).setParameter("naam", vertrekLocatie).getResultList();
    }
}