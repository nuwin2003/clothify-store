package service;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import dao.custom.impl.UserImpl;
import entity.UserEntity;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class LoginFormService {

    UserImpl user = new UserImpl();

    String userType;
    public void exit(){
        Optional<ButtonType> buttonType = new Alert(Alert.AlertType.CONFIRMATION,"Do you really want to Exit ?",ButtonType.YES,ButtonType.NO).showAndWait();
        if(buttonType.get() == ButtonType.YES){
            System.exit(0);
        }
    }

    public void login(ActionEvent event, JFXTextField txtUserName, JFXPasswordField txtPassword){
        String userName = txtUserName.getText();
        String password = txtPassword.getText();

        UserEntity userEntity = user.findUser(userName,password);

        if(userEntity!= null && userEntity.getType().equals("Admin") && userType.equals(userEntity.getType())) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/admin_dashboard_form.fxml"))));
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (userEntity != null && userEntity.getType().equals("Employee") && userType.equals(userEntity.getType())) {
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/employee_dashboard_form.fxml"))));
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else{
            new Alert(Alert.AlertType.ERROR,"Login Error!").show();
        }
    }

    public void signIn(ActionEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/user_registration_form.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void forgotPassword(ActionEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/forgot_password_form.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void btnAdminStyle(JFXButton btnAdmin, JFXButton btnEmployee){
        userType = "Admin";
        btnAdmin.setStyle("-fx-background-color: #2d3436");
        btnEmployee.setStyle("-fx-background-color: #636e72");
    }
    public void btnEmployeeStyle(JFXButton btnAdmin, JFXButton btnEmployee){
        userType = "Employee";
        btnAdmin.setStyle("-fx-background-color: #636e72");
        btnEmployee.setStyle("-fx-background-color: #2d3436");
    }
    public void clear(JFXTextField txtUserName, JFXPasswordField txtPassword){
        txtUserName.setText("");
        txtPassword.setText("");
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
