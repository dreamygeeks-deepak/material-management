package com.dreamygeeks.mms.material;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
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
        Material material = new Material(nameText.getText(), descriptionText.getText(), hsnText.getText(), unitCombo.getSelectionModel().getSelectedItem().toString(), null);
        materialRepository.save(material);
        updateTableContent();
    }

    @FXML
    void updateAction(ActionEvent event) {
        Material material = new Material(nameText.getText(), descriptionText.getText(), hsnText.getText(), unitCombo.getSelectionModel().getSelectedItem().toString(), null);
        material.setId(Long.parseLong(idText.getText()));
        materialRepository.save(material);
    }

    @FXML
    void deleteAction(ActionEvent event) {
        materialRepository.delete(Long.parseLong(idText.getText()));
    }

    @FXML
    void initialize() {
        Iterable<Material> materialData = materialRepository.findAll();
        for (Material material : materialData) {
            data.add(material);
        }

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
        materialTable.setItems(filteredData);
    }

    @FXML
    void updateTableContent() {

    }
}
