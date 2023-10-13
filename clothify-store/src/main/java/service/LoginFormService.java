package service;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;

public interface LoginFormService {
    public void exit();
    public void login(javafx.event.ActionEvent event);
    public void signIn(javafx.event.ActionEvent event);
    public void forgotPassword(javafx.event.ActionEvent event);

    public void btnAdminStyle(JFXButton btnAdmin, JFXButton btnEmployee);

    public void btnEmployeeStyle(JFXButton btnAdmin, JFXButton btnEmployee);

    public void clear(JFXTextField txtUserName, JFXPasswordField txtPassword);
}
