package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import service.UserRegistrationService;

import java.util.Optional;


public class UserRegistrationController {
    @FXML
    private JFXTextField txtAdminUserName;

    @FXML
    private JFXPasswordField txtAdminPassword;

    @FXML
    private JFXButton btnCheck;

    @FXML
    private JFXTextField txtOTP;

    @FXML
    private JFXButton btnSend;

    @FXML
    private JFXComboBox<String> cmbUserType;

    @FXML
    private JFXTextField txtNewUserName;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXPasswordField txtConfirmPassword;

    @FXML
    private JFXButton btnRegister;

    @FXML
    private JFXButton btnViewUsers;

    @FXML
    private JFXTextField txtContactNumber;

    @FXML
    private JFXButton btnBack;

    UserRegistrationService userRegistrationService = new UserRegistrationService();

    public void initialize(){
        userRegistrationService.setItems(cmbUserType);
    }
    @FXML
    void btnBackOnAction(ActionEvent event) {
        userRegistrationService.back(event);
    }

    @FXML
    void btnCheckOnAction(ActionEvent event) {

    }

    @FXML
    void btnRegisterOnAction(ActionEvent event) {
        Optional<ButtonType> buttonType = new Alert(Alert.AlertType.CONFIRMATION,"Do you want to Register this User ?",ButtonType.YES,ButtonType.NO).showAndWait();
        if(buttonType.get() == ButtonType.YES){
            userRegistrationService.registerUser(txtNewUserName,txtEmail,txtPassword,txtConfirmPassword,txtContactNumber,cmbUserType);
            userRegistrationService.clear(txtNewUserName,txtEmail,txtPassword,txtConfirmPassword,txtContactNumber,cmbUserType);
        }
    }

    @FXML
    void btnSendOnAction(ActionEvent event) {

    }

    @FXML
    void btnViewUsersOAction(ActionEvent event) {

    }

}
