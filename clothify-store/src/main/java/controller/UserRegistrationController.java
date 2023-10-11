package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

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
    private JFXComboBox<?> cmbUserType;

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
}
