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
            System.out.println("Fail,username or password invalid.");
        }
    }
}

