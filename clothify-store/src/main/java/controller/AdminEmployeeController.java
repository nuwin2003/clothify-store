package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.EmployeeDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import service.impl.EmployeeService;

import java.util.Optional;

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
    private TableView<EmployeeDto> tblEmployee;

    @FXML
    private TableColumn<?, ?> colEmpId;

    @FXML
    private TableColumn<?, ?> colEmpName;

    @FXML
    private TableColumn<?, ?> colEmpEmail;

    @FXML
    private TableColumn<?, ?> colContactNumber;

    EmployeeService employeeService = new EmployeeService();

    public void initialize(){
        employeeService.loadTable(tblEmployee,colEmpId,colEmpName,colEmpEmail,colContactNumber);
    }
    @FXML
    void btnClearOnAction(ActionEvent event) {
        employeeService.clear(txtEmployeeId,txtEmployeeName,txtEmployeeEmail,txtContactNumber);
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        Optional<ButtonType> buttonType = new Alert(Alert.AlertType.CONFIRMATION,"Do you want to Delete this Employee ?",ButtonType.YES,ButtonType.NO).showAndWait();
        if(buttonType.get() == ButtonType.YES){
            employeeService.delete(txtEmployeeId);
            employeeService.loadTable(tblEmployee,colEmpId,colEmpName,colEmpEmail,colContactNumber);
            employeeService.clear(txtEmployeeId,txtEmployeeName,txtEmployeeEmail,txtContactNumber);
        }
    }

    @FXML
    void btnRegisterEmployeeOnAction(ActionEvent event) {
        Optional<ButtonType> buttonType = new Alert(Alert.AlertType.CONFIRMATION,"Do you want to Register this Employee ?",ButtonType.YES,ButtonType.NO).showAndWait();
        if(buttonType.get() == ButtonType.YES){
            employeeService.save(txtEmployeeId,txtEmployeeName,txtEmployeeEmail,txtContactNumber);
            employeeService.loadTable(tblEmployee,colEmpId,colEmpName,colEmpEmail,colContactNumber);
            employeeService.clear(txtEmployeeId,txtEmployeeName,txtEmployeeEmail,txtContactNumber);
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        Optional<ButtonType> buttonType = new Alert(Alert.AlertType.CONFIRMATION,"Do you want to Update this Employee ?",ButtonType.YES,ButtonType.NO).showAndWait();
        if(buttonType.get() == ButtonType.YES){
            employeeService.update(txtEmployeeId,txtEmployeeName,txtEmployeeEmail,txtContactNumber);
            employeeService.loadTable(tblEmployee,colEmpId,colEmpName,colEmpEmail,colContactNumber);
            employeeService.clear(txtEmployeeId,txtEmployeeName,txtEmployeeEmail,txtContactNumber);
        }
    }

    @FXML
    void tblEmployeeOnClick(MouseEvent event) {
        employeeService.loadEmployeeDetails(tblEmployee,txtEmployeeId,txtEmployeeName,txtEmployeeEmail,txtContactNumber);
    }
}
