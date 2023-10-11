package controller;


import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import service.impl.AdminDashboardService;

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

    AdminDashboardService adminDashboardService = new AdminDashboardService();
    @FXML
    void btnExitOnAction(ActionEvent event) {
        adminDashboardService.exit(event);
    }
}
