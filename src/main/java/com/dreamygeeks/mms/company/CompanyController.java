package com.dreamygeeks.mms.company;

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
 * Created by deepak_shingan on 9/17/2017.
 */
@Component
public class CompanyController {

    @FXML
    TextField companySearchText;
    @FXML
    TextField idText;
    @FXML
    TextField nameText;
    @FXML
    TextArea descriptionTextArea;
    @FXML
    TextArea addressTextArea;
    @FXML
    TextField phoneNumber1Text;
    @FXML
    TextField phoneNumber2Text;
    @FXML
    TextField emailText;
    @FXML
    CheckBox supplierCheckbox;
    @FXML
    CheckBox customerCheckBox;
    @FXML
    TableView companyTable;
    @Autowired
    CompanyRepository companyRepository;

    ObservableList<Company> data = FXCollections.observableArrayList();
    FilteredList<Company> filteredData = new FilteredList<>(data, p -> true);

    public CompanyController() {
    }

    private Company getCompanyObject() {
        return new Company(nameText.getText(),
                descriptionTextArea.getText(),
                addressTextArea.getText(),
                Long.parseLong(phoneNumber1Text.getText()),
                Long.parseLong(phoneNumber2Text.getText()),
                emailText.getText(),
                supplierCheckbox.isSelected(),
                customerCheckBox.isSelected()
        );
    }

    @FXML
    void addAction(ActionEvent event) {
        Company company = getCompanyObject();
        companyRepository.save(company);
        tableRefresh();
    }

    @FXML
    void updateAction(ActionEvent event) {
        Company company = getCompanyObject();
        company.setId(Long.parseLong(idText.getText()));
        companyRepository.save(company);
        tableRefresh();
    }

    @FXML
    void deleteAction(ActionEvent event) {
        companyRepository.delete(Long.parseLong(idText.getText()));
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
        SortedList<Company> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(companyTable.comparatorProperty());
        companyTable.setItems(sortedData);
    }

    private void onTableRowSelect() {
        companyTable.setRowFactory(tv -> {
            TableRow<Company> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    Company rowData = row.getItem();
                    displayOnForm(rowData);
                }
            });
            return row;
        });
    }

    private void displayOnForm(Company company) {
        idText.setText(company.getId().toString());
        nameText.setText(company.getName());
        descriptionTextArea.setText(company.getDescription());
        addressTextArea.setText(company.getAddress());
        phoneNumber1Text.setText(company.getPhoneNumber1().toString());
        phoneNumber2Text.setText(company.getPhoneNumber2().toString());
        emailText.setText(company.getEmail());
        customerCheckBox.setSelected(company.isCustomer());
        supplierCheckbox.setSelected(company.isSuppier());
    }

    private void setSearchAction() {
        companySearchText.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(company -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
                if (company.getId().toString().toLowerCase().contains(lowerCaseFilter) ||
                        company.getName().toLowerCase().contains(lowerCaseFilter) ||
                        company.getDescription().toLowerCase().contains(lowerCaseFilter) ||
                        company.getAddress().toLowerCase().contains(lowerCaseFilter) ||
                        company.getEmail().toString().contains(lowerCaseFilter) ||
                        company.getPhoneNumber1().toString().toLowerCase().contains(lowerCaseFilter) ||
                        company.getPhoneNumber2().toString().toLowerCase().contains(lowerCaseFilter)
                        ) {
                    return true; // Filter matches first name.
                }
                return false; // Does not match.
            });
        });
    }

    private void getDataAndSetToTable() {
        Iterable<Company> companyData = companyRepository.findAllByOrderByIdAsc();
        data.clear();
        for (Company company : companyData) {
            data.add(company);
        }
    }


}
