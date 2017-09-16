package com.dreamygeeks.mms.material;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by deepak_shingan on 9/14/2017.
 */
@Component
public class MaterialController {


    @FXML
    Button addMaterialButton;
    @FXML
    Button updateMaterialButton;
    @FXML
    Button deleteMaterialButton;

    @Autowired
    MaterialRepository materialRepository;

    public MaterialController() {
        System.out.println("Inside material controller");
    }

    public void save(Material material){
        System.out.println("Saving");
        materialRepository.save(material);
        System.out.println("Saved");
    }

    @FXML
    void addAction(ActionEvent event) {

    }
}
