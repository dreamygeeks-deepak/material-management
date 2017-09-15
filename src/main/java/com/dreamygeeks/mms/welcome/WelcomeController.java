package com.dreamygeeks.mms.welcome;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import org.springframework.stereotype.Component;

/**
 * Created by deepak_shingan on 9/15/2017.
 */
@Component
public class WelcomeController {
    @FXML
    PieChart companyWiseSales;
    @FXML
    PieChart companyWisePurchase;
    @FXML
    StackedAreaChart purchaseSaleCompare;
    @FXML
    BarChart weeklyInMaterial;

    public WelcomeController() {
    }

    public void loadCompanyWiseSales() {
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Amul Dairy", 100),
                        new PieChart.Data("Renuka Foods", 200),
                        new PieChart.Data("Chandan Hotel", 50),
                        new PieChart.Data("Radhika ", 75),
                        new PieChart.Data("Chitale Foods", 110),
                        new PieChart.Data("GreenPark Hotels", 300),
                        new PieChart.Data("A1 Biryani", 111),
                        new PieChart.Data("Raja Sweets", 30),
                        new PieChart.Data("Amar Foods", 75),
                        new PieChart.Data("Hotel GoodLuck", 55),
                        new PieChart.Data("Laxmi Sweets", 225),
                        new PieChart.Data("Bikaner Dry Fruits", 99));
        companyWiseSales.setData(pieChartData);
    }

    public void loadCompanyWisePurchase() {
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Amul Dairy", 100),
                        new PieChart.Data("Renuka Foods", 200),
                        new PieChart.Data("Chandan Hotel", 50),
                        new PieChart.Data("Radhika ", 75),
                        new PieChart.Data("Chitale Foods", 110),
                        new PieChart.Data("GreenPark Hotels", 300),
                        new PieChart.Data("A1 Biryani", 111),
                        new PieChart.Data("Raja Sweets", 30),
                        new PieChart.Data("Amar Foods", 75),
                        new PieChart.Data("Hotel GoodLuck", 55),
                        new PieChart.Data("Laxmi Sweets", 225),
                        new PieChart.Data("Bikaner Dry Fruits", 99));
        companyWisePurchase.setData(pieChartData);
        companyWisePurchase.setVisible(true);

    }

    public void loadPurchaseSaleCompare() {
        final NumberAxis xAxis = new NumberAxis(1, 31, 1);
        final NumberAxis yAxis = new NumberAxis();

        XYChart.Series seriesApril = new XYChart.Series();
        seriesApril.setName("Sales");
        seriesApril.getData().add(new XYChart.Data(1, 4));
        seriesApril.getData().add(new XYChart.Data(3, 10));
        seriesApril.getData().add(new XYChart.Data(6, 15));
        seriesApril.getData().add(new XYChart.Data(9, 8));
        seriesApril.getData().add(new XYChart.Data(12, 5));
        seriesApril.getData().add(new XYChart.Data(15, 18));
        seriesApril.getData().add(new XYChart.Data(18, 15));
        seriesApril.getData().add(new XYChart.Data(21, 13));
        seriesApril.getData().add(new XYChart.Data(24, 19));
        seriesApril.getData().add(new XYChart.Data(27, 21));
        seriesApril.getData().add(new XYChart.Data(30, 21));

        XYChart.Series seriesMay = new XYChart.Series();
        seriesMay.setName("Purchase");
        seriesMay.getData().add(new XYChart.Data(1, 20));
        seriesMay.getData().add(new XYChart.Data(3, 15));
        seriesMay.getData().add(new XYChart.Data(6, 13));
        seriesMay.getData().add(new XYChart.Data(9, 12));
        seriesMay.getData().add(new XYChart.Data(12, 14));
        seriesMay.getData().add(new XYChart.Data(15, 18));
        seriesMay.getData().add(new XYChart.Data(18, 25));
        seriesMay.getData().add(new XYChart.Data(21, 25));
        seriesMay.getData().add(new XYChart.Data(24, 23));
        seriesMay.getData().add(new XYChart.Data(27, 26));
        seriesMay.getData().add(new XYChart.Data(31, 26));

        purchaseSaleCompare.getData().add(seriesApril);
        purchaseSaleCompare.getData().add(seriesMay);
    }

    public void loadWeeklyInMaterial() {
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();

        xAxis.setLabel("Material");
        yAxis.setLabel("Value");

        XYChart.Series series1 = new XYChart.Series();
        //series1.setName("Materials");
        series1.getData().add(new XYChart.Data("Milk", 25604));
        series1.getData().add(new XYChart.Data("Rava", 20148));
        series1.getData().add(new XYChart.Data("Poha", 10000));
        series1.getData().add(new XYChart.Data("Nuts", 35407));
        series1.getData().add(new XYChart.Data("Daal", 12000));


        weeklyInMaterial.getData().add(series1);
    }
}
