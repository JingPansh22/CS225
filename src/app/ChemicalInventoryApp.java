package app;

import javafx.application.Application;
import javafx.stage.Stage;
import util.SceneManager;

public class ChemicalInventoryApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        SceneManager.setStage(primaryStage); // ✅ 初始化主窗口给 SceneManager
        SceneManager.switchTo("fxml/login.fxml"); // ✅ 使用统一跳转逻辑
    }

    public static void main(String[] args) {
        launch(args);
    }
}


/*
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChemicalInventoryApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/login.fxml"));
        primaryStage.setTitle("MassBay Chemical Inventory Management System");
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

 */

