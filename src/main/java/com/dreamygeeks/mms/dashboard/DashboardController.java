package com.dreamygeeks.mms.dashboard;

import com.dreamygeeks.mms.welcome.WelcomeController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by deepak_shingan on 9/15/2017.
 */
@Component
public class DashboardController {
    @Autowired
    WelcomeController welcomeController;
    @FXML
    private Text titleText;
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
    @FXML
    private GridPane welcomeScreen;

    public DashboardController() {
    }

    @FXML
    void initialize() {
        handleWelcomeScreenAction();
    }

    @FXML protected void handlematerialButtonAction(ActionEvent event){
        invisibleAll();
        materialScreen.setVisible(true);
    }

    @FXML protected void handleCompanyButtonAction(ActionEvent event){
        invisibleAll();
        companyScreen.setVisible(true);
    }

    @FXML
    public void handleWelcomeScreenAction() {
        invisibleAll();
        welcomeScreen.setVisible(true);
        welcomeController.loadCompanyWiseSales();
        welcomeController.loadCompanyWisePurchase();
        welcomeController.loadPurchaseSaleCompare();
        welcomeController.loadWeeklyInMaterial();

    }

    private void invisibleAll() {
        companyScreen.setVisible(false);
        materialScreen.setVisible(false);
        welcomeScreen.setVisible(false);
    }
}
