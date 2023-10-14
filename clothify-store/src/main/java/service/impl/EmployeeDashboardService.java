package service.impl;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class EmployeeDashboardService {
    public void exit() {
        Optional<ButtonType> buttonType = new Alert(Alert.AlertType.CONFIRMATION,"Do you really want to Exit ?",ButtonType.YES,ButtonType.NO).showAndWait();
        if(buttonType.get() == ButtonType.YES){
            System.exit(0);
        }
    }

    public void showDashboard(ActionEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/employee_dashboard_form.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showPlaceOrderForm(AnchorPane bodyAnchor) throws IOException {
        URL resource =this.getClass().getResource("/view/placeorder_form.fxml");

        assert resource != null;

        Parent load = (Parent) FXMLLoader.load(resource);
        bodyAnchor.getChildren().clear();
        bodyAnchor.getChildren().add(load);
    }

    public void showProductsForm(AnchorPane bodyAnchor) throws IOException {
        URL resource =this.getClass().getResource("/view/products_form.fxml");

        assert resource != null;

        Parent load = (Parent) FXMLLoader.load(resource);
        bodyAnchor.getChildren().clear();
        bodyAnchor.getChildren().add(load);
    }

    public void showSupplierForm(AnchorPane bodyAnchor) throws IOException {
        URL resource =this.getClass().getResource("/view/supplier_form.fxml");

        assert resource != null;

        Parent load = (Parent) FXMLLoader.load(resource);
        bodyAnchor.getChildren().clear();
        bodyAnchor.getChildren().add(load);
    }

    public void showCustomerForm(AnchorPane bodyAnchor) throws IOException {
        URL resource =this.getClass().getResource("/view/customer_form.fxml");

        assert resource != null;

        Parent load = (Parent) FXMLLoader.load(resource);
        bodyAnchor.getChildren().clear();
        bodyAnchor.getChildren().add(load);
    }

    public void setDateAndTime(Label lblDate, Label lblTime) {
        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.seconds(1), // Update every second
                        new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                LocalTime currentTime = LocalTime.now();
                                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                                String formattedTime = currentTime.format(timeFormatter);
                                lblTime.setText(formattedTime);
                            }
                        }
                )
        );
        timeline.setCycleCount(Timeline.INDEFINITE); // Run indefinitely
        timeline.play();

        LocalDate localDate = LocalDate.now();
        lblDate.setText(localDate.toString());
    }
}
