package ba.reservation.hotelreservation.controller;


import ba.reservation.hotelreservation.business.model.User;
import ba.reservation.hotelreservation.controller.events.EventBus;
import ba.reservation.hotelreservation.gui.admin.AdminView;
import ba.reservation.hotelreservation.gui.login.LoginView;
import ba.reservation.hotelreservation.gui.user.UserView;
import javafx.stage.Stage;

public class Controller {

    private LoginView loginView;
    private UserView userView;
    private AdminView adminView;
    private User loggedUser;
    private final EventBus eventBus = new EventBus();
    private Stage primaryStage;

    private Controller() {
    }

    public EventBus getEventBus() {
        return eventBus;
    }


    public void setLoginView(LoginView loginView) {
        this.loginView = loginView;
    }

    public LoginView getLoginView() {
        return loginView;
    }

    public void setAdminView(AdminView adminView) {
        this.adminView = adminView;
    }

    public AdminView getAdminView() {
        return adminView;
    }

    public void setUserView(UserView userView) {
        this.userView = userView;
    }

    public UserView getUserView() {
        return userView;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }



    private static Controller INSTANCE = null;

    public static Controller getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Controller();
        }
        return INSTANCE;
    }
}
