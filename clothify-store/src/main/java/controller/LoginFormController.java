package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import service.LoginFormService;
import service.impl.LoginFormServiceImpl;

public class LoginFormController {
    @FXML
    private JFXButton btnAdmin;

    @FXML
    private JFXButton btnEmployee;

    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXButton btnForgotPassword;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXButton btnSignIn;

    @FXML
    private JFXButton btnExit;

    LoginFormService loginFormServiceImpl = new LoginFormServiceImpl();

    @FXML
    void btnExitOnClick(ActionEvent event) {
        loginFormServiceImpl.exit();
    }
    @FXML
    void btnLoginOnAction(ActionEvent event) {
        loginFormServiceImpl.login(event,txtUserName,txtPassword);
    }
    @FXML
    void btnSignInOnAction(ActionEvent event) {
        loginFormServiceImpl.signIn(event);
    }
    @FXML
    void btnForgotPasswordOnAction(ActionEvent event) {
        loginFormServiceImpl.forgotPassword(event);
    }
    @FXML
    void btnClearOnAction(ActionEvent event) {
        loginFormServiceImpl.clear(txtUserName,txtPassword);
    }
    @FXML
    void btnAdminOnAction(ActionEvent event) {
        loginFormServiceImpl.btnAdminStyle(btnAdmin,btnEmployee);
    }
    @FXML
    void btnEmployeeOnAction(ActionEvent event) {
        loginFormServiceImpl.btnEmployeeStyle(btnAdmin,btnEmployee);
    }
}
