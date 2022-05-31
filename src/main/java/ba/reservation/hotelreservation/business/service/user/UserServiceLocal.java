package ba.reservation.hotelreservation.business.service.user;

import ba.reservation.hotelreservation.business.model.User;

public interface UserServiceLocal {
    /**
     * Login method
     *
     * @param username
     * @param password
     * @return user or null if user not exist
     */
    public User login(String username, String password);
}
