package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;

public class SearchController {

    @FXML private VBox moduleLeft;
    @FXML private VBox moduleRight;

    @FXML
    public void initialize() {
        // load left module
        loadSubview("search_form.fxml", moduleLeft);

        // loadright module
        loadSubview("search_results.fxml", moduleRight);

        // debug
        System.out.println("Loading search_form.fxml into moduleLeft");
        loadSubview("search_form.fxml", moduleLeft);
        System.out.println("Loading search_results.fxml into moduleRight");
        loadSubview("search_results.fxml", moduleRight);

    }
    @FXML
    private void handleSearch() {
        // 处理搜索逻辑
        System.out.println("Search button clicked!");
    }
    /**
     *  fxml --> VBox
     */
    private void loadSubview(String fxmlFile, VBox targetBox) {
        try {
            String path = "fxml/" + fxmlFile;
            System.out.println("Trying to load: " + path);  // debug

            // i am working on form/results fxml
            if ("search_form.fxml".equals(fxmlFile)) {
                targetBox.getChildren().clear();
                targetBox.getChildren().add(new Label("Placeholder for search form"));
            } else if ("search_results.fxml".equals(fxmlFile)) {
                targetBox.getChildren().clear();
                targetBox.getChildren().add(new Label("Placeholder for search results"));
            } else {

                URL resource = getClass().getClassLoader().getResource(path);
                if (resource == null) {
                    throw new IOException("Resource not found: " + path);
                }

                FXMLLoader loader = new FXMLLoader(resource);
                Node content = loader.load();
                targetBox.getChildren().clear();
                targetBox.getChildren().add(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to load: " + fxmlFile);
        }
    }

}

