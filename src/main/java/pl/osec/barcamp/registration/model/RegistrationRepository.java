package pl.osec.barcamp.registration.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

import static pl.osec.barcamp.registration.model.Registration.GET_ALL_REGISTRATIONS_QUERY;

@Stateless
public class RegistrationRepository {

    @PersistenceContext
    private EntityManager em;

    public Registration save(Registration registration) {
        em.persist(registration);
        return registration;
    }

    public Registration findRegistrationBy(long id) {
        return em.find(Registration.class, id);
    }

    public List<Registration> getAllRegistrations() {
        TypedQuery<Registration> query =
                em.createNamedQuery(GET_ALL_REGISTRATIONS_QUERY, Registration.class);
        return query.getResultList();
    }
}
