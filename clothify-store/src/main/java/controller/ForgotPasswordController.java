package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import javafx.fxml.FXML;

public class ForgotPasswordController {
    @FXML
    private JFXButton btnSendOTP;

    @FXML
    private JFXButton btnEnter;

    @FXML
    private JFXPasswordField txtNewPassword;

    @FXML
    private JFXPasswordField txtConfirmPassword;

    @FXML
    private JFXButton btnSave;
}
