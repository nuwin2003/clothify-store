package service.impl;

import com.jfoenix.controls.JFXTextField;
import dao.custom.impl.EmployeeImpl;
import dto.EmployeeDto;
import entity.EmployeeEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EmployeeService {

    EmployeeImpl employee = new EmployeeImpl();
    public void save(JFXTextField txtEmployeeId, JFXTextField txtEmployeeName, JFXTextField txtEmployeeEmail, JFXTextField txtContactNumber) {
        EmployeeDto employeeDto = new EmployeeDto(
                Integer.parseInt(txtEmployeeId.getText()),
                txtEmployeeName.getText(),
                txtEmployeeEmail.getText(),
                txtContactNumber.getText()
        );
        if(employee.save(employeeDto)){
            new Alert(Alert.AlertType.INFORMATION,"Employee Saved!").showAndWait();
        }
    }

    public void clear(JFXTextField txtEmployeeId, JFXTextField txtEmployeeName, JFXTextField txtEmployeeEmail, JFXTextField txtContactNumber) {
        txtEmployeeId.setText("");
        txtEmployeeName.setText("");
        txtEmployeeEmail.setText("");
        txtContactNumber.setText("");
    }

    public void loadTable(TableView<EmployeeDto> tblEmployee, TableColumn<?,?> colEmpId, TableColumn<?,?> colEmpName, TableColumn<?,?> colEmpEmail, TableColumn<?,?> colContactNumber) {
        colEmpId.setCellValueFactory(new PropertyValueFactory<>("empId"));
        colEmpName.setCellValueFactory(new PropertyValueFactory<>("empName"));
        colEmpEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colContactNumber.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));

        ObservableList<EmployeeDto> list = FXCollections.observableArrayList(employee.findAll());

        tblEmployee.setItems(list);
    }

    public void loadEmployeeDetails(TableView<?> tblEmployee, JFXTextField txtEmployeeId, JFXTextField txtEmployeeName, JFXTextField txtEmployeeEmail, JFXTextField txtContactNumber) {
        if(!tblEmployee.getSelectionModel().isEmpty()){
            EmployeeEntity selectedRow = (EmployeeEntity) tblEmployee.getSelectionModel().getSelectedItem();

            txtEmployeeId.setText(String.valueOf(selectedRow.getEmpId()));
            txtEmployeeName.setText(selectedRow.getEmpName());
            txtEmployeeEmail.setText(selectedRow.getEmail());
            txtContactNumber.setText(selectedRow.getContactNumber());
        }
    }
}
