package service;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import dao.custom.impl.UserImpl;
import dto.UserDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class UserRegistrationService {

    UserImpl user = new UserImpl();

    public void back(ActionEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/login_form.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void registerUser(JFXTextField txtNewUserName, JFXTextField txtEmail, JFXPasswordField txtPassword, JFXPasswordField txtConfirmPassword, JFXTextField txtContactNumber, JFXComboBox<?> cmbUserType) {
        if(txtPassword.getText().equals(txtConfirmPassword.getText())){
            UserDto userDto = new UserDto(
                    1,
                    txtNewUserName.getText(),
                    txtPassword.getText(),
                    txtEmail.getText(),
                    txtContactNumber.getText(),
                    cmbUserType.getValue().toString()
                    );
            if(user.save(userDto)){
                new Alert(Alert.AlertType.INFORMATION,"User Registered!").show();
            }
        }
    }

    public void setItems(JFXComboBox<String> cmbUserType) {
        ObservableList<String> observableList = FXCollections.observableArrayList("Admin","Employee");
        cmbUserType.setItems(observableList);
    }

    public void clear(JFXTextField txtNewUserName, JFXTextField txtEmail, JFXPasswordField txtPassword, JFXPasswordField txtConfirmPassword, JFXTextField txtContactNumber, JFXComboBox<String> cmbUserType) {
        txtNewUserName.setText("");
        txtEmail.setText("");
        txtPassword.setText("");
        txtConfirmPassword.setText("");
        txtContactNumber.setText("");
        cmbUserType.setValue(null);
    }
}
