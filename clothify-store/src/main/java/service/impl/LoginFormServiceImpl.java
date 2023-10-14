package service.impl;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import service.LoginFormService;

import java.io.IOException;
import java.util.Optional;

public class LoginFormServiceImpl implements LoginFormService {

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
        if(userName.equalsIgnoreCase("Nuwin") && password.equals("47212") && userType.equals("Admin")) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/admin_dashboard_form.fxml"))));
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (userName.equalsIgnoreCase("Nuwin") && password.equals("47212") && userType.equals("Employee")) {
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/employee_dashboard_form.fxml"))));
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else{
            Optional<ButtonType> buttonType = new Alert(Alert.AlertType.ERROR,"Login Error!",ButtonType.OK).showAndWait();
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
}
