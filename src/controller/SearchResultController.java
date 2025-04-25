package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.ChemicalEntry;

public class SearchResultController {

    @FXML private TableView<ChemicalEntry> resultTable;
    @FXML private TableColumn<ChemicalEntry, String> nameColumn;
    @FXML private TableColumn<ChemicalEntry, String> manufacturerColumn;
    @FXML private TableColumn<ChemicalEntry, String> unitColumn;
    @FXML private TableColumn<ChemicalEntry, Integer> quantityColumn;
    @FXML private TableColumn<ChemicalEntry, String> locationColumn;
    @FXML private TableColumn<ChemicalEntry, String> hazardColumn;
    @FXML private TableColumn<ChemicalEntry, String> expirationDateColumn;

    private final ObservableList<ChemicalEntry> data = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // 绑定列与 ChemicalEntry 属性
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        manufacturerColumn.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
        unitColumn.setCellValueFactory(new PropertyValueFactory<>("unit"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        hazardColumn.setCellValueFactory(new PropertyValueFactory<>("hazard"));
        expirationDateColumn.setCellValueFactory(new PropertyValueFactory<>("expirationDate"));

        resultTable.setItems(data);
    }

    // ✅ 外部调用此方法，添加搜索结果
    public void updateResults(ObservableList<ChemicalEntry> results) {
        data.setAll(results);
    }
}
