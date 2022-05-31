package ba.reservation.hotelreservation.controller.events;

import ba.reservation.hotelreservation.business.model.User;
import ba.reservation.hotelreservation.business.service.Constants;
import ba.reservation.hotelreservation.business.service.user.UserServiceFactory;
import ba.reservation.hotelreservation.controller.Controller;
import ba.reservation.hotelreservation.gui.admin.AdminView;
import ba.reservation.hotelreservation.gui.user.UserView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class LoginEvent implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        String username = Controller.getInstance().getLoginView().getUsernameTextField().getText();
        String password = Controller.getInstance().getLoginView().getPasswordField().getText();
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            //U Constants ćemo staviti poruke
            Controller.getInstance().getLoginView().getMessageLabel().setText(Constants.EMPTY_LOGIN_FIELDS_MESSAGE);
            return;//ne idemo dalje ka bazi ali treba setovati message u labeli
        }
        User user = UserServiceFactory.USER_SERVICE.getUserService().login(username, password);
        if (user == null) {
            Controller.getInstance().getLoginView().getMessageLabel().setText(Constants.BAD_USERNAME_PASSWORD_COMBINATION);
        } else {
            BorderPane view;
            //mijenjamo stage u zavisnosti od privilegije korisnika
            Controller.getInstance().setLoggedUser(user);
            if ("admin".equals(user.getIdPrivilege().getName())) {
                //ADMIN view
                view = new AdminView();
                Controller.getInstance().setAdminView((AdminView) view);
                Controller.getInstance().getPrimaryStage().setTitle("Admin panel: " + user.getName() + " " + user.getSurname());
            } else {
                //USER view
                view = new UserView();
                Controller.getInstance().setUserView((UserView) view);
                Controller.getInstance().getPrimaryStage().setTitle("Korisnički panel HMS: " + user.getName() + " " + user.getSurname());
            }
            Scene scene = new Scene(view, 650, 300);
            Controller.getInstance().getPrimaryStage().setScene(scene);
        }
    }
}