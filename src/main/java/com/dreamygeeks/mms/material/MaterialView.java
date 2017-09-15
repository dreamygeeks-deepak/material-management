package com.dreamygeeks.mms.material;


import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by deepak_shingan on 9/14/2017.
 */
@Component
public class MaterialView {
    private GridPane view ;
    private TextField nameText;
    private Label nameLabel;
    private Button button;
    @Autowired
    private MaterialController controller = new MaterialController();

    public MaterialView() {
        System.out.println("Inside View");
        System.out.println(""+controller);
        createGUI();
    }

    public void createGUI() {
        createLayout();
        addFields();
        addConfiguration();
    }

    private void addFields() {
        nameText = new TextField();
        nameLabel = new Label("Name");
        button = new Button("Ok");
        view.addRow(0, nameLabel, nameText);
        view.addRow(0, button);

    }

    private void addConfiguration(){
        button.setOnAction((event) -> {
            System.out.println("hahaha");
            controller.save(new Material(nameText.getText()));
        } );
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