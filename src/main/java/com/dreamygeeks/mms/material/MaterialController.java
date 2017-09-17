package com.dreamygeeks.mms.material;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
    @Autowired
    MaterialRepository materialRepository;

    public MaterialController() {
    }

    @FXML
    void addAction(ActionEvent event) {
        Material material = new Material(nameText.getText(), descriptionText.getText(), hsnText.getText(), unitCombo.getSelectionModel().getSelectedItem().toString(), null);
        materialRepository.save(material);
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
}
