package com.dreamygeeks.mms.dashboard;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import org.springframework.stereotype.Component;

/**
 * Created by deepak_shingan on 9/15/2017.
 */
@Component
public class DashboardController {
    @FXML private Button materialButton;
    @FXML private Button companyButton;
    @FXML private Button purchaseOrderButton;
    @FXML private Button salesOrderButton;
    @FXML private Button salesReportButton;
    @FXML private Button purcahseReportButton;
    @FXML private Button franchiseReportButton;
    @FXML private Button stockAlertButton;
    @FXML private Button damageExpiryReportButton;
    @FXML private Button adjustMentEntriesReportButton;

    @FXML private StackPane centerStackPane;

    @FXML private GridPane materialScreen;
    @FXML private GridPane companyScreen;

    public DashboardController() {}

    @FXML protected void handlematerialButtonAction(ActionEvent event){
        System.out.println("I am here1");
        companyScreen.setVisible(false);
        materialScreen.setVisible(true);
    }

    @FXML protected void handleCompanyButtonAction(ActionEvent event){
        System.out.println("I am here");
        companyScreen.setVisible(true);
        materialScreen.setVisible(false);
    }

}
