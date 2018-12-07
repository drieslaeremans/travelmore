package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Gebruiker;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

public class GebruikerRepository {

    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Gebruiker findById(int id) {
        return entityManager.find(Gebruiker.class, id);
    }

    public List<Gebruiker> findAll() {
        return entityManager.createNamedQuery(Gebruiker.FIND_ALL, Gebruiker.class).getResultList();
    }

    public void insert(Gebruiker gebruiker) {
        entityManager.persist(gebruiker);
    }

    public Gebruiker validate(String email, String wachtwoord) {
        Gebruiker gebruiker = new Gebruiker();
        try {
            gebruiker = entityManager.createNamedQuery(Gebruiker.VALIDATE, Gebruiker.class).setParameter("email", email).setParameter("wachtwoord", wachtwoord).getSingleResult();
        }
        catch (NoResultException nre){
            return null;
        }
        return gebruiker;
    }

}
