package com.dreamygeeks.mms.view;

import com.dreamygeeks.mms.controller.MaterialController;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Material;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by deepak_shingan on 9/14/2017.
 */
public class MaterialView implements MMSView{
    private GridPane view ;
    private TextField nameText;
    private Label nameLabel;
    @Autowired
    private MaterialController controller ;

    @Autowired
    private Material model;


    public MaterialView() {
        System.out.println(""+model);
        System.out.println(""+controller);
        createGUI();
    }

    @Override
    public void createGUI() {
        createLayout();
        addFields();
    }

    private void addFields() {
        nameText = new TextField();
        nameLabel = new Label("Name");
        view.addRow(0, nameLabel, nameText);
    }

    private void createLayout() {
        view = new GridPane();

        ColumnConstraints leftCol = new ColumnConstraints();
        leftCol.setHalignment(HPos.RIGHT);
        leftCol.setHgrow(Priority.NEVER);

        ColumnConstraints rightCol = new ColumnConstraints();
        rightCol.setHgrow(Priority.SOMETIMES);

        view.getColumnConstraints().addAll(leftCol, rightCol);

        view.setAlignment(Pos.CENTER);
        view.setHgap(5);
        view.setVgap(10);
    }


    public Parent asParent() {
        return view;
    }
}