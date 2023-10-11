package service;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class LoginFormService {
    public void exit(){
        Optional<ButtonType> buttonType = new Alert(Alert.AlertType.CONFIRMATION,"Do you want to exit ?",ButtonType.YES,ButtonType.NO).showAndWait();
        if(buttonType.get() == ButtonType.YES){
            System.exit(0);
        }
    }
}
