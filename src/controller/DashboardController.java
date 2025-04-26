package controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;  // 新增：因为现在要操作 BorderPane的 center区域
import javafx.application.Platform;    // 新增：为了 Platform.runLater 延迟初始化

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class DashboardController {

    // ==================== 顶部 Sidebar 按钮 ====================
    @FXML private ToggleButton searchBtn, addBtn, locationBtn, sdsBtn, orderBtn, adminBtn;

    private ToggleGroup sidebarGroup; // Sidebar按钮分组

    @FXML
    public void initialize() {
        listResourcesDebug(); // Debug输出，可以保留

        // 检查按钮是否成功绑定
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

        //  默认高亮 Search按钮
        searchBtn.setSelected(true);

        // 【新增】延迟执行，避免 getScene() 为 null
        Platform.runLater(() -> {
            loadCenterModule("search.fxml");
        });
    }

    // ==================== Sidebar 按钮点击 ====================

    @FXML
    private void handleSearch() {
        searchBtn.setSelected(true);
        loadCenterModule("search.fxml");  // 加载 Search模块
    }

    @FXML
    private void handleAdd() {
        addBtn.setSelected(true);
        loadCenterModule("add.fxml");  // 加载 Add模块
    }

    @FXML
    private void handleLocation() {
        locationBtn.setSelected(true);
        loadCenterModule("location.fxml");  // 加载 Location模块
    }

    @FXML
    private void handleSDS() {
        sdsBtn.setSelected(true);
        loadCenterModule("sds.fxml");  // 加载 SDS模块
    }

    @FXML
    private void handleOrder() {
        orderBtn.setSelected(true);
        loadCenterModule("order.fxml");  // 加载 Order模块
    }

    @FXML
    private void handleAdmin() {
        adminBtn.setSelected(true);
        loadCenterModule("admin.fxml");  // 加载 Admin模块
    }

    // ==================== 新版加载模块方法 (换整个 center区域) ====================

    private void loadCenterModule(String fxmlFileName) {
        try {
            String fullPath = "fxml/" + fxmlFileName;
            URL resource = getClass().getClassLoader().getResource(fullPath);
            if (resource == null) {
                throw new IOException("Resource not found: " + fullPath);
            }

            FXMLLoader loader = new FXMLLoader(resource);
            Node content = loader.load();

            // 找到 BorderPane的 Root
            Parent root = searchBtn.getScene().getRoot();
            if (root instanceof BorderPane mainPane) {
                mainPane.setCenter(content);  // 替换 center 区域
            } else {
                System.err.println("Root is not BorderPane!");
            }

            System.out.println("Successfully loaded: " + fxmlFileName);

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to load module: " + fxmlFileName);
        }
    }

    // ==================== Debug列出资源路径 ====================

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
