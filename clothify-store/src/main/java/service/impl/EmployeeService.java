package service.impl;

import com.jfoenix.controls.JFXTextField;
import dao.custom.impl.EmployeeImpl;
import dto.EmployeeDto;
import javafx.scene.control.Alert;

public class EmployeeService {
    EmployeeImpl employee = new EmployeeImpl();
    public void save(JFXTextField txtEmployeeId, JFXTextField txtEmployeeName, JFXTextField txtEmployeeEmail, JFXTextField txtContactNumber) {
        EmployeeDto employeeDto = new EmployeeDto(
                txtEmployeeId.getText(),
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
}
