package ba.reservation.hotelreservation.business.service.user;

import ba.reservation.hotelreservation.business.model.Privilege;
import ba.reservation.hotelreservation.business.service.Constants;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class PrivilegeService {

    public List<Privilege> findAll(){
        return getEntityManager().createQuery("from Privilege ").getResultList();
    }


    private EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory(Constants.PU_NAME).createEntityManager();
    }
}
