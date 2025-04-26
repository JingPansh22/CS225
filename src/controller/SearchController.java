package controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.net.URL;

public class SearchController {

    @FXML private VBox moduleLeft, moduleRight;  // 2 modules

    @FXML
    public void initialize() {

        loadModule("search_form.fxml", moduleLeft);
        loadModule("search_results.fxml", moduleRight);

    }

    // load fmxl
    private void loadModule(String fxmlFileName, VBox targetBox) {
        try {
            String fullPath = "fxml/" + fxmlFileName;


            URL resource = getClass().getClassLoader().getResource(fullPath);
            if (resource == null) {
                throw new IOException("Resource not found: " + fullPath);
            }

            FXMLLoader loader = new FXMLLoader(resource);
            Node content = loader.load();

            targetBox.getChildren().clear();
            targetBox.getChildren().add(content);

            // debug
            System.out.println("!!!!!Loaded: " + fxmlFileName + " into VBox with fx:id = " + targetBox.getId());

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("!!!!!!Failed to load module: " + fxmlFileName);
        }
    }
}

