package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SearchController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField casField;

    @FXML
    private TextField barcodeField;

    @FXML
    private TextField locationField;

    @FXML
    private Button advancedSearchBtn;

    @FXML
    public void initialize() {
        // ✅ 可在此添加初始化逻辑
        System.out.println("SearchController initialized");
    }
}

