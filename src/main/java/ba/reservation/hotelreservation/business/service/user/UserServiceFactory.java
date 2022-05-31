package ba.reservation.hotelreservation.business.service.user;

public enum UserServiceFactory {
    USER_SERVICE(new UserService());

    private UserServiceLocal userService;

    UserServiceFactory(UserServiceLocal userServiceLocal){
        this.userService = userServiceLocal;
    }

    public UserServiceLocal getUserService() {
        return userService;
    }
}
