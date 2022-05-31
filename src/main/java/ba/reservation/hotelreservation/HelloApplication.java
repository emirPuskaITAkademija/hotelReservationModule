package ba.reservation.hotelreservation;

import ba.reservation.hotelreservation.business.model.User;
import ba.reservation.hotelreservation.business.service.user.UserServiceFactory;
import ba.reservation.hotelreservation.controller.Controller;
import ba.reservation.hotelreservation.gui.login.LoginView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        LoginView loginView = new LoginView();
        Controller.getInstance().setPrimaryStage(primaryStage);
        Controller.getInstance().setLoginView(loginView);

        Scene scene = new Scene(loginView, 650, 180);

        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
//        String username = "ferida.bobar";
//        String password = "ferida123";
//        User user = UserServiceFactory.USER_SERVICE.getUserService().login(username, password);
//        System.out.println(user);
    }
}