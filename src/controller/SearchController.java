package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SearchController {

    @FXML private TextField nameField;
    @FXML private TextField casField;
    @FXML private TextField barcodeField;
    @FXML private TextField locationField;

    @FXML private Button searchBtn;
    @FXML private Button advancedSearchBtn;

    @FXML
    public void initialize() {
        // 初始化时给按钮添加点击事件监听器
        searchBtn.setOnAction(event -> handleSearch());
        advancedSearchBtn.setOnAction(event -> handleAdvancedSearch());
    }

    private void handleSearch() {
        // 点击 Search 按钮时，打印当前所有输入框内容
        System.out.println("[Search] Name: " + nameField.getText());
        System.out.println("[Search] CAS Number: " + casField.getText());
        System.out.println("[Search] Barcode: " + barcodeField.getText());
        System.out.println("[Search] Location: " + locationField.getText());
    }

    private void handleAdvancedSearch() {
        // 点击 Advanced Search 按钮时，打印提示信息
        System.out.println("[Advanced Search] Opening advanced search options...");
    }
}

