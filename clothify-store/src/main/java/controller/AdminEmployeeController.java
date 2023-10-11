package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AdminEmployeeController {
    @FXML
    private JFXTextField txtEmployeeId;

    @FXML
    private JFXTextField txtEmployeeName;

    @FXML
    private JFXTextField txtEmployeeEmail;

    @FXML
    private JFXTextField txtContactNumber;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXButton btnRegisterEmployee;

    @FXML
    private TableView<?> tblEmployee;

    @FXML
    private TableColumn<?, ?> colEmpId;

    @FXML
    private TableColumn<?, ?> colEmpName;

    @FXML
    private TableColumn<?, ?> colEmpEmail;

    @FXML
    private TableColumn<?, ?> ColContactNumber;
}
