package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import service.impl.ForgotPasswordService;

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

    @FXML
    private JFXButton btnBack;

    ForgotPasswordService forgotPasswordService = new ForgotPasswordService();
    @FXML
    void btnBackOnAction(ActionEvent event) {
        forgotPasswordService.back(event);
    }
}
