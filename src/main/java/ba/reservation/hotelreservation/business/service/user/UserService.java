package ba.reservation.hotelreservation.business.service.user;

import ba.reservation.hotelreservation.business.model.User;
import ba.reservation.hotelreservation.business.service.Constants;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

class UserService implements UserServiceLocal{
    @Override
    public User login(String username, String password) {
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            return null;
        }
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createNamedQuery("User.findByUsernameAndPassword");
        query.setParameter("username", username); // idemo u named query i provjerimo kako smo dali ime parametru
        query.setParameter("password", password);
        try {
            User user = (User) query.getSingleResult();
            return user;
        } catch (NoResultException exception) {
            System.err.format("Not exist user: %s", username);
            return null;
        } catch (NonUniqueResultException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    @Override
    public void create(User user) {
        EntityManager entityManager  = getEntityManager();
        // begin transaction
        entityManager.getTransaction().begin();
        if (!entityManager.contains(user)) {
            // persist object - add to entity manager
            entityManager.persist(user);
            // flush em - save to DB
            entityManager.flush();
        }
        // commit transaction at all
        entityManager.getTransaction().commit();
    }

    private EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory(Constants.PU_NAME).createEntityManager();
    }
}
