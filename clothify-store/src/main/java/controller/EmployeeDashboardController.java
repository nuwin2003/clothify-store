package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import service.impl.EmployeeDashboardService;

import java.io.IOException;

public class EmployeeDashboardController {
    @FXML
    private JFXButton btnExit;

    @FXML
    private JFXButton btnDashboard;

    @FXML
    private JFXButton btnProducts;

    @FXML
    private JFXButton btnPlaceOrder;

    @FXML
    private JFXButton btnSuppliers;

    @FXML
    private JFXButton btnCustomers;

    @FXML
    private AnchorPane bodyAnchor;

    @FXML
    private Label lblTime;

    @FXML
    private Label lblDate;

    @FXML
    private JFXButton btnLogOut;

    EmployeeDashboardService employeeDashboardService = new EmployeeDashboardService();

    public void initialize(){
        employeeDashboardService.setDateAndTime(lblDate,lblTime);
    }
    @FXML
    void btnCustomersOnAction(ActionEvent event) throws IOException {
        employeeDashboardService.showCustomerForm(bodyAnchor);
    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) {
        employeeDashboardService.showDashboard(event);
    }

    @FXML
    void btnExitOnAction(ActionEvent event) {
        employeeDashboardService.exit();
    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) throws IOException {
        employeeDashboardService.showPlaceOrderForm(bodyAnchor);
    }

    @FXML
    void btnProductsOnAction(ActionEvent event) throws IOException {
        employeeDashboardService.showProductsForm(bodyAnchor);
    }
    @FXML
    void btnSuppliersOnAction(ActionEvent event) throws IOException {
        employeeDashboardService.showSupplierForm(bodyAnchor);
    }
    @FXML
    void btnLogOutOnAction(ActionEvent event) {
        employeeDashboardService.logOut(event);
    }
}
