package util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {
    private static Stage primaryStage;

    public static void setStage(Stage stage) {
        primaryStage = stage;
    }

    public static void switchTo(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getClassLoader().getResource(fxmlPath));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            // ✅ 加载统一样式表
            scene.getStylesheets().add(SceneManager.class.getResource("/styles/styles.css").toExternalForm());

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("加载失败: " + fxmlPath);
        }
    }


    public static void openPopup(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getClassLoader().getResource(fxmlPath));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            // ✅ 加载统一样式表
            scene.getStylesheets().add(SceneManager.class.getResource("/styles/styles.css").toExternalForm());

            Stage popupStage = new Stage();
            popupStage.setScene(scene);
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setTitle("Popup");
            popupStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("弹窗加载失败: " + fxmlPath);
        }
    }

}
