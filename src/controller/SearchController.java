package controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javafx.scene.control.TextField; // ✅ 新增：为了绑定左侧输入框
import javafx.scene.control.Button;    // ✅ 新增：为了绑定左侧搜索按钮
import javafx.scene.control.TableView; // ✅ 新增：为了绑定右侧搜索结果表格
import javafx.scene.control.TableColumn;
import javafx.collections.FXCollections;

import model.GenericDao; // ✅ 调用 DAO 查询数据库

public class SearchController {

    // ================== 左右模块占位 VBox ==================
    @FXML private VBox moduleLeft;
    @FXML private VBox moduleRight;

    // ================== 左侧表单控件 ==================
    @FXML private TextField nameField;
    @FXML private TextField casField;
    @FXML private TextField barcodeField;
    @FXML private TextField locationField;
    @FXML private Button search_form_Button; // ✅ 新增，绑定搜索按钮

    // ================== 右侧结果表格控件 ==================
    @FXML private TableView<Map<String, Object>> resultsTable;

    // ================== DAO实例 ==================
    private final GenericDao dao = new GenericDao();

    @FXML
    public void initialize() {
        // 初始化时，只加载左边 search_form.fxml
        loadFormToLeft();

        // 等左边模块加载完后，绑定按钮监听
        if (search_form_Button != null) {
            search_form_Button.setOnAction(event -> {
                System.out.println(" Search Form Button clicked!");
                handleSearch();  // 点击后执行查询逻辑
            });
        } else {
            System.err.println("search_form_Button is NULL! 检查 FXML 绑定！");
        }
    }

    // ================== 加载左边 search_form.fxml ==================
    private void loadFormToLeft() {
        try {
            String fullPath = "fxml/search_form.fxml";
            URL resource = getClass().getClassLoader().getResource(fullPath);
            if (resource == null) throw new IOException("Resource not found: " + fullPath);

            FXMLLoader loader = new FXMLLoader(resource);
            Node content = loader.load();

            // 清空并放到左边 VBox
            if (moduleLeft != null) {
                moduleLeft.getChildren().clear();
                moduleLeft.getChildren().add(content);
            }

            // 绑定左侧控件
            nameField = (TextField) content.lookup("#nameField");
            casField = (TextField) content.lookup("#casField");
            barcodeField = (TextField) content.lookup("#barcodeField");
            locationField = (TextField) content.lookup("#locationField");
            search_form_Button = (Button) content.lookup("#search_form_Button");

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to load search_form.fxml");
        }
    }

    // ================== 加载右边 search_results.fxml ==================
    private void loadResultsToRight() {
        try {
            String fullPath = "fxml/search_results.fxml";
            URL resource = getClass().getClassLoader().getResource(fullPath);
            if (resource == null) throw new IOException("Resource not found: " + fullPath);

            FXMLLoader loader = new FXMLLoader(resource);
            Node content = loader.load();

            if (moduleRight != null) {
                moduleRight.getChildren().clear();
                moduleRight.getChildren().add(content);
            }

            // 绑定右边表格控件
            resultsTable = (TableView<Map<String, Object>>) content.lookup("#resultsTable");

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to load search_results.fxml");
        }
    }

    // ================== 点击Search按钮后的搜索逻辑 ==================
    @FXML
    private void handleSearch() {
        if (dao == null) {
            System.err.println("DAO is not initialized.");
            return;
        }

        // 延迟到用户点击时，才加载右边 search_results.fxml
        if (resultsTable == null) {
            loadResultsToRight();
        }

        if (resultsTable == null) {
            System.err.println("ResultsTable not initialized.");
            return;
        }

        // 读取输入
        String name = nameField != null ? nameField.getText().trim() : "";
        String cas = casField != null ? casField.getText().trim() : "";
        String barcode = barcodeField != null ? barcodeField.getText().trim() : "";
        String location = locationField != null ? locationField.getText().trim() : "";

        // 暂时只按 name 搜索（可以后面扩展多字段）
        List<Map<String, Object>> results = dao.search("Chemical", name);

        // 更新右边表格
        updateResultsTable(results);
    }

    // ================== 动态更新右边 TableView内容 ==================
    private void updateResultsTable(List<Map<String, Object>> results) {
        resultsTable.getItems().clear();
        resultsTable.getColumns().clear();

        if (results == null || results.isEmpty()) return;

        Map<String, Object> firstRow = results.get(0);
        for (String key : firstRow.keySet()) {
            TableColumn<Map<String, Object>, String> column = new TableColumn<>(key);
            column.setCellValueFactory(cellData -> {
                Object value = cellData.getValue().get(key);
                return new javafx.beans.property.SimpleStringProperty(value == null ? "" : value.toString());
            });
            resultsTable.getColumns().add(column);
        }

        resultsTable.setItems(FXCollections.observableArrayList(results));
    }
}
