package controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class DashboardController {

    @FXML private ToggleButton searchBtn, addBtn, locationBtn, sdsBtn, orderBtn, adminBtn;
    @FXML private StackPane contentArea;
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

        // 默认选中按钮
        searchBtn.setSelected(true);
        loadModule("search_form.fxml",true);
        System.out.println("Trying to load: fxml/" + "search_form.fxml");
        System.out.println("Result: " + getClass().getClassLoader().getResource("fxml/" + "search_form.fxml"));

    }

    private void deselectAll() {
        searchBtn.setSelected(false);
        addBtn.setSelected(false);
        locationBtn.setSelected(false);
        sdsBtn.setSelected(false);
        orderBtn.setSelected(false);
        adminBtn.setSelected(false);
    }


    @FXML private void handleSearch() {
        searchBtn.setSelected(true);
        loadModule("search_form.fxml",true);
        System.out.println("Trying to load: fxml/" + "search_form.fxml");
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

    /*
    private void loadModule(String fxmlFileName) {
        try {
            // ✅ Construct path based on actual resource location
            String fullPath = "fxml/" + fxmlFileName;
            System.out.println("DEBUG: Trying to load -> " + fullPath);

            // ✅ Load the FXML file using class loader
            URL resource = getClass().getClassLoader().getResource(fullPath);
            if (resource == null) {
                throw new IOException("Resource not found: " + fullPath);
            }

            FXMLLoader loader = new FXMLLoader(resource);
            Node content = loader.load();

            // ✅ Replace center content area
            contentArea.getChildren().clear();
            contentArea.getChildren().add(content);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to load module: " + fxmlFileName);
        }
    }

     */

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


/*
//这一版可以的，不是不是toggler！！！
import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.StackPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class DashboardController {

    @FXML private ToggleButton searchBtn, addBtn, locationBtn, sdsBtn, orderBtn, adminBtn;
    @FXML private StackPane contentArea;

    @FXML
    private void handleSearch() {
        loadModule("search.fxml");
    }

    @FXML
    private void handleAdd() {
        loadModule("add.fxml");
    }

    @FXML
    private void handleLocation() {
        loadModule("location.fxml");
    }

    @FXML
    private void handleSDS() {
        loadModule("sds.fxml");
    }

    @FXML
    private void handleOrder() {
        loadModule("order.fxml");
    }

    @FXML
    private void handleAdmin() {
        loadModule("admin.fxml");
    }

    private void loadModule(String fxmlFileName) {
        try {
            Parent module = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/modules/" + fxmlFileName));
            contentArea.getChildren().setAll(module);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
public class DashboardController {
    // 暂时不用实现任何方法，只用于绑定 dashboard.fxml 的控制器
}

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {

    @FXML
    private Label logoutLabel;

    @FXML
    private TableView<SidebarItem> sidebarTable;

    @FXML
    private TableColumn<SidebarItem, String> moduleColumn;

    @FXML
    private StackPane contentArea;

    @FXML
    public void initialize() {
        moduleColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        // 添加模块名称列表
        sidebarTable.getItems().addAll(
                new SidebarItem("Search"),
                new SidebarItem("Add a Chemical"),
                new SidebarItem("Locations"),
                new SidebarItem("SDS and File Storage"),
                new SidebarItem("Order Requests"),
                new SidebarItem("Administration")
        );

        // 设置点击事件监听器
        sidebarTable.setOnMouseClicked(event -> {
            SidebarItem selectedItem = sidebarTable.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                loadModuleView(selectedItem.getName());
            }
        });
    }

    private void loadModuleView(String moduleName) {
        try {
            String viewName = switch (moduleName) {
                case "Search" -> "search_view.fxml";
                case "Add a Chemical" -> "add_view.fxml";
                case "Locations" -> "location_view.fxml";
                case "SDS and File Storage" -> "sds_view.fxml";
                case "Order Requests" -> "order_view.fxml";
                case "Administration" -> "admin_view.fxml";
                default -> null;
            };

            if (viewName != null) {
                Parent view = FXMLLoader.load(getClass().getResource("/modules/" + viewName));
                contentArea.getChildren().setAll(view);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleLogout(MouseEvent event) {
        try {
            Parent loginView = FXMLLoader.load(getClass().getResource("/login.fxml"));
            Stage stage = (Stage) logoutLabel.getScene().getWindow();
            stage.setScene(new Scene(loginView, 1280, 720));
            stage.setTitle("MassBay Chemical Inventory Management System");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class SidebarItem {
        private final String name;

        public SidebarItem(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}

 */
