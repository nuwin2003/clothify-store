package service.impl;

import com.jfoenix.controls.JFXTextField;
import dao.custom.impl.CustomerImpl;
import dto.CustomerDto;
import entity.CustomerEntity;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CustomerService {

    CustomerImpl customer = new CustomerImpl();
    public void registerCustomer(JFXTextField txtCustomerId, JFXTextField txtCustomerName, JFXTextField txtCustomerEmail, JFXTextField txtContactNumber) {
        String customerId = txtCustomerId.getText();
        String name = txtCustomerName.getText();
        String email = txtCustomerEmail.getText();
        String contactNumber = txtContactNumber.getText();
        CustomerDto customerDto = new CustomerDto(customerId,name,email,contactNumber);

        if(customer.save(customerDto)){
            new Alert(Alert.AlertType.INFORMATION,"Customer Saved!").show();
            clear(txtCustomerId,txtCustomerName,txtCustomerEmail,txtContactNumber);
        }else{
            new Alert(Alert.AlertType.ERROR,"Customer saving Failed!!").show();
        }
    }

    public void clear(JFXTextField txtCustomerId, JFXTextField txtCustomerName, JFXTextField txtCustomerEmail, JFXTextField txtContactNumber) {
        txtCustomerId.setText("");
        txtCustomerName.setText("");
        txtCustomerEmail.setText("");
        txtContactNumber.setText("");
    }

    public void loadTable(TableView<?> tblCustomer, TableColumn<?,?> colCustomerId, TableColumn<?,?> colCustomerName, TableColumn<?,?> colCustomerEmail, TableColumn<?,?> colContactNumber) {
        customer.loadTable((TableView<CustomerEntity>) tblCustomer,colCustomerId,colCustomerName,colCustomerEmail,colContactNumber);
    }
}
