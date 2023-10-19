package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import service.UserRegistrationService;


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
    private JFXTextField txtConfirmPassword;

    @FXML
    private JFXTextField txtPassword;

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
        userRegistrationService.registerUser(txtNewUserName,txtEmail,txtPassword,txtConfirmPassword,txtContactNumber,cmbUserType);
    }

    @FXML
    void btnSendOnAction(ActionEvent event) {

    }

    @FXML
    void btnViewUsersOAction(ActionEvent event) {

    }

}
