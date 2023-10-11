package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import service.LoginFormService;

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
    private Label lblForgotPassword;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXButton btnSignIn;

    @FXML
    private JFXButton btnExit;

    LoginFormService loginFormService = new LoginFormService();

    @FXML
    void btnExitOnClick(ActionEvent event) {
        loginFormService.exit();
    }
}
