package controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class DashboardController {

    @FXML private ToggleButton searchBtn, addBtn, locationBtn, sdsBtn, orderBtn, adminBtn;
    @FXML private VBox moduleLeft, moduleRight;

    private ToggleGroup sidebarGroup;

    @FXML
    public void initialize() {
        listResourcesDebug(); // debug

        System.out.println("searchBtn = " + searchBtn);
        System.out.println("addBtn = " + addBtn);
        System.out.println("locationBtn = " + locationBtn);
        System.out.println("sdsBtn = " + sdsBtn);
        System.out.println("orderBtn = " + orderBtn);
        System.out.println("adminBtn = " + adminBtn);
        sidebarGroup = new ToggleGroup();

        searchBtn.setToggleGroup(sidebarGroup);
        addBtn.setToggleGroup(sidebarGroup);
        locationBtn.setToggleGroup(sidebarGroup);
        sdsBtn.setToggleGroup(sidebarGroup);
        orderBtn.setToggleGroup(sidebarGroup);
        adminBtn.setToggleGroup(sidebarGroup);


        searchBtn.setSelected(true);
        loadModule("search.fxml",true);
        System.out.println("Trying to load: fxml/" + "search.fxml");
        System.out.println("Result: " + getClass().getClassLoader().getResource("fxml/" + "search.fxml"));

    }

    private void deselectAll() {
        searchBtn.setSelected(false);
        addBtn.setSelected(false);
        locationBtn.setSelected(false);
        sdsBtn.setSelected(false);
        orderBtn.setSelected(false);
        adminBtn.setSelected(false);
    }

    // loadModuleAndSelect(ToggleButton button, String fxmlFileName) can be written to optimise
    @FXML private void handleSearch() {
        searchBtn.setSelected(true);
        loadModule("search.fxml",true);
        System.out.println("Trying to load: fxml/" + "search.fxml");
    }

    @FXML private void handleAdd() {
        addBtn.setSelected(true);
        loadModule("add.fxml",true);
    }

    @FXML private void handleLocation() {
        locationBtn.setSelected(true);
        loadModule("location.fxml",true);
    }

    @FXML private void handleSDS() {
        sdsBtn.setSelected(true);
        loadModule("sds.fxml",true);
    }

    @FXML private void handleOrder() {
        orderBtn.setSelected(true);
        loadModule("order.fxml",true);
    }

    @FXML private void handleAdmin() {
        adminBtn.setSelected(true);
        loadModule("admin.fxml",true);
    }

    private void loadModule(String fxmlFileName, boolean toLeft) {
        try {
            String fullPath = "fxml/" + fxmlFileName;
            URL resource = getClass().getClassLoader().getResource(fullPath);
            if (resource == null) {
                throw new IOException("Resource not found: " + fullPath);
            }

            FXMLLoader loader = new FXMLLoader(resource);
            Node content = loader.load();

            if (toLeft) {
                moduleLeft.getChildren().clear();
                moduleLeft.getChildren().add(content);
            } else {
                moduleRight.getChildren().clear();
                moduleRight.getChildren().add(content);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to load module: " + fxmlFileName);
        }
    }


    //debug path ( if put sidebar fxml not in fxml will be error
    public void listResourcesDebug() {
        System.out.println("=== Listing resources under fxml/modules/ ===");
        try {
            Enumeration<URL> resources = getClass().getClassLoader().getResources("fxml/modules");
            while (resources.hasMoreElements()) {
                System.out.println("Found: " + resources.nextElement());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}

