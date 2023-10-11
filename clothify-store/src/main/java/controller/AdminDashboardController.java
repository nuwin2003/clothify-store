package controller;


import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import service.impl.AdminDashboardService;

import java.io.IOException;
import java.net.URL;

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
    private AnchorPane bodyAnchor;

    AdminDashboardService adminDashboardService = new AdminDashboardService();

    @FXML
    void btnCustomersOnAction(ActionEvent event) {

    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) {

    }

    @FXML
    void btnEmployeesOnAction(ActionEvent event) throws IOException {
        URL resource =this.getClass().getResource("/view/admin_employee_form.fxml");

        assert resource != null;

        Parent load = (Parent) FXMLLoader.load(resource);
        this.bodyAnchor.getChildren().clear();
        this.bodyAnchor.getChildren().add(load);
    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) throws IOException {
        URL resource =this.getClass().getResource("/view/admin_placeorder_form.fxml");

        assert resource != null;

        Parent load = (Parent) FXMLLoader.load(resource);
        this.bodyAnchor.getChildren().clear();
        this.bodyAnchor.getChildren().add(load);
    }

    @FXML
    void btnProductsOnAction(ActionEvent event) throws IOException {
        URL resource =this.getClass().getResource("/view/admin_products_form.fxml");

        assert resource != null;

        Parent load = (Parent) FXMLLoader.load(resource);
        this.bodyAnchor.getChildren().clear();
        this.bodyAnchor.getChildren().add(load);
    }

    @FXML
    void btnReportsOnAction(ActionEvent event) {

    }

    @FXML
    void btnSuppliersOnAction(ActionEvent event) throws IOException {
        URL resource =this.getClass().getResource("/view/admin_supplier_form.fxml");

        assert resource != null;

        Parent load = (Parent) FXMLLoader.load(resource);
        this.bodyAnchor.getChildren().clear();
        this.bodyAnchor.getChildren().add(load);
    }

    @FXML
    void btnExitOnAction(ActionEvent event) {
        adminDashboardService.exit(event);
    }
}
