package com.dreamygeeks.mms.material;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by deepak_shingan on 9/14/2017.
 */
@Component
public class MaterialController {

    @FXML
    TextField idText;
    @FXML
    TextField nameText;
    @FXML
    TextArea descriptionText;
    @FXML
    TextField hsnText;
    @FXML
    Button addMaterialButton;
    @FXML
    Button updateMaterialButton;
    @FXML
    Button deleteMaterialButton;
    @FXML
    ComboBox unitCombo;
    @FXML
    ComboBox companyCombo;
    @FXML
    TextField minimumStockLimitText;
    @FXML
    TextField currentMaterialStockText;
    @FXML
    TableView<Material> materialTable;
    @Autowired
    MaterialRepository materialRepository;
    @FXML
    TextField searchText;

    ObservableList<Material> data = FXCollections.observableArrayList();
    FilteredList<Material> filteredData = new FilteredList<>(data, p -> true);

    public MaterialController() {
    }

    @FXML
    void addAction(ActionEvent event) {
        Material material = getMaterialObject();
        materialRepository.save(material);
        tableRefresh();
    }

    private Material getMaterialObject() {
        return new Material(nameText.getText(),
                descriptionText.getText(),
                hsnText.getText(),
                unitCombo.getSelectionModel().getSelectedItem().toString(),
                Integer.parseInt(minimumStockLimitText.getText()),
                Integer.parseInt(currentMaterialStockText.getText()));
    }

    @FXML
    void updateAction(ActionEvent event) {
        Material material = getMaterialObject();
        material.setId(Long.parseLong(idText.getText()));
        materialRepository.save(material);
        tableRefresh();
    }

    @FXML
    void deleteAction(ActionEvent event) {
        materialRepository.delete(Long.parseLong(idText.getText()));
        tableRefresh();
    }

    @FXML
    void initialize() {
        onTableRowSelect();
        tableRefresh();
    }

    private void tableRefresh() {
        getDataAndSetToTable();
        setSearchAction();

        //Add Auto-Sort
        SortedList<Material> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(materialTable.comparatorProperty());
        materialTable.setItems(sortedData);
    }

    private void onTableRowSelect() {
        materialTable.setRowFactory(tv -> {
            TableRow<Material> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    Material rowData = row.getItem();
                    displayOnForm(rowData);
                }
            });
            return row;
        });
    }

    private void displayOnForm(Material material) {
        idText.setText(material.getId().toString());
        nameText.setText(material.getName());
        descriptionText.setText(material.getDescription());
        hsnText.setText(material.getHsn());
        unitCombo.getSelectionModel().select(material.getUnit());
        minimumStockLimitText.setText(material.getMinimumStockLimit().toString());
        currentMaterialStockText.setText(material.getCurrentMaterialStock().toString());
    }

    private void setSearchAction() {
        searchText.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(material -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
                if (material.getName().toLowerCase().contains(lowerCaseFilter) ||
                        material.getDescription().toLowerCase().contains(lowerCaseFilter) ||
                        material.getHsn().toLowerCase().contains(lowerCaseFilter) ||
                        material.getId().toString().contains(lowerCaseFilter) ||
                        material.getUnit().toLowerCase().contains(lowerCaseFilter)
                        ) {
                    return true; // Filter matches first name.
                }
                return false; // Does not match.
            });
        });
    }

    private void getDataAndSetToTable() {
        Iterable<Material> materialData = materialRepository.findAllByOrderByIdAsc();
        data.clear();
        for (Material material : materialData) {
            data.add(material);
        }
    }
}
