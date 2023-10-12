package service.impl;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;

public class AdminDashboardService {
    public void exit() {
        Optional<ButtonType> buttonType = new Alert(Alert.AlertType.CONFIRMATION,"Do you really want to Exit ?",ButtonType.YES,ButtonType.NO).showAndWait();
        if(buttonType.get() == ButtonType.YES){
            System.exit(0);
        }
    }

    public void showDashboard(ActionEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/admin_dashboard_form.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showEmployeeForm(AnchorPane bodyAnchor) throws IOException {
        URL resource =this.getClass().getResource("/view/admin_employee_form.fxml");

        assert resource != null;

        Parent load = (Parent) FXMLLoader.load(resource);
        bodyAnchor.getChildren().clear();
        bodyAnchor.getChildren().add(load);
    }

    public void showPlaceOrderForm(AnchorPane bodyAnchor) throws IOException {
        URL resource =this.getClass().getResource("/view/admin_placeorder_form.fxml");

        assert resource != null;

        Parent load = (Parent) FXMLLoader.load(resource);
        bodyAnchor.getChildren().clear();
        bodyAnchor.getChildren().add(load);
    }

    public void showProductsForm(AnchorPane bodyAnchor) throws IOException {
        URL resource =this.getClass().getResource("/view/admin_products_form.fxml");

        assert resource != null;

        Parent load = (Parent) FXMLLoader.load(resource);
        bodyAnchor.getChildren().clear();
        bodyAnchor.getChildren().add(load);
    }

    public void showSupplierForm(AnchorPane bodyAnchor) throws IOException {
        URL resource =this.getClass().getResource("/view/admin_supplier_form.fxml");

        assert resource != null;

        Parent load = (Parent) FXMLLoader.load(resource);
        bodyAnchor.getChildren().clear();
        bodyAnchor.getChildren().add(load);
    }

    public void showCustomerForm(AnchorPane bodyAnchor) throws IOException {
        URL resource =this.getClass().getResource("/view/admin_customer_form.fxml");

        assert resource != null;

        Parent load = (Parent) FXMLLoader.load(resource);
        bodyAnchor.getChildren().clear();
        bodyAnchor.getChildren().add(load);
    }
}
