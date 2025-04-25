package controller;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import util.SceneManager;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        System.out.println("DEBUG - Username: " + username + ", Password: " + password);

        if ("admin".equals(username) && "1234".equals(password)) {
            SceneManager.switchTo("fxml/dashboard.fxml");
            System.out.println(getClass().getClassLoader().getResource("fxml/dashboard.fxml"));  // debug

        } else {
            System.out.println("登录失败，用户名或密码错误。");
        }
    }
}

/*
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.io.IOException;
import java.net.URL;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        System.out.println("DEBUG - Username: " + username + ", Password: " + password);

        if ("admin".equals(username) && "1234".equals(password)) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/dashboard.fxml"));
                Parent dashboardRoot = loader.load();
                Scene dashboardScene = new Scene(dashboardRoot, 1280, 720);

                Stage stage = (Stage) usernameField.getScene().getWindow();
                stage.setScene(dashboardScene);
                stage.setTitle("Dashboard");
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("登录失败，用户名或密码错误。");
        }
    }

}


 */