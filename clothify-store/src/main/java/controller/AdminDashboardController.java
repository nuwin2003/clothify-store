package controller;


import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import service.AdminDashboardService;

import java.io.IOException;

public class AdminDashboardController {
    @FXML
    private JFXButton btnExit;

    @FXML
    private JFXButton btnEmployees;

    @FXML
    private JFXButton btnProducts;

    @FXML
    private JFXButton btnPlaceOrder;

    @FXML
    private JFXButton btnSuppliers;

    @FXML
    private JFXButton btnCustomers;

    @FXML
    private JFXButton btnReports;

    @FXML
    private JFXButton btnDashboard;

    @FXML
    private Label lblTime;

    @FXML
    private Label lblDate;

    @FXML
    private JFXButton btnLogOut;

    @FXML
    private AnchorPane bodyAnchor;

    AdminDashboardService adminDashboardService = new AdminDashboardService();

    public void initialize(){
        adminDashboardService.setDateAndTime(lblDate,lblTime);
    }
    @FXML
    void btnCustomersOnAction(ActionEvent event) throws IOException {
        adminDashboardService.showCustomerForm(bodyAnchor);
    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) {
        adminDashboardService.showDashboard(event);
    }

    @FXML
    void btnEmployeesOnAction(ActionEvent event) throws IOException {
        adminDashboardService.showEmployeeForm(bodyAnchor);
    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) throws IOException {
        adminDashboardService.showPlaceOrderForm(bodyAnchor);
    }

    @FXML
    void btnProductsOnAction(ActionEvent event) throws IOException {
        adminDashboardService.showProductsForm(bodyAnchor);
    }

    @FXML
    void btnReportsOnAction(ActionEvent event) {

    }

    @FXML
    void btnSuppliersOnAction(ActionEvent event) throws IOException {
        adminDashboardService.showSupplierForm(bodyAnchor);
    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) {
        adminDashboardService.logOut(event);
    }

    @FXML
    void btnExitOnAction(ActionEvent event) {
        adminDashboardService.exit();
    }

}
