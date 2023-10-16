package service.impl;

import com.jfoenix.controls.JFXTextField;
import dao.custom.impl.CustomerImpl;
import dto.CustomerDto;
import entity.CustomerEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CustomerService {

    CustomerImpl customer = new CustomerImpl();
    public void registerCustomer(JFXTextField txtCustomerId, JFXTextField txtCustomerName, JFXTextField txtCustomerEmail, JFXTextField txtContactNumber) {

        CustomerDto customerDto = new CustomerDto(
                Integer.parseInt(txtCustomerId.getText()),
                txtCustomerName.getText(),
                txtCustomerEmail.getText(),
                txtContactNumber.getText()
        );

        if(customer.save(customerDto)){
            new Alert(Alert.AlertType.INFORMATION,"Customer Saved!").show();
        }
    }

    public void clear(JFXTextField txtCustomerId, JFXTextField txtCustomerName, JFXTextField txtCustomerEmail, JFXTextField txtContactNumber) {
        txtCustomerId.setText("");
        txtCustomerName.setText("");
        txtCustomerEmail.setText("");
        txtContactNumber.setText("");
    }

    public void loadTable(TableView<CustomerDto> tblCustomer, TableColumn<?,?> colCustomerId, TableColumn<?,?> colCustomerName, TableColumn<?,?> colCustomerEmail, TableColumn<?,?> colContactNumber) {

        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCustomerEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colContactNumber.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));


        ObservableList<CustomerDto> list = FXCollections.observableArrayList(customer.findAll());
        tblCustomer.setItems(list);
    }

    public void setId(JFXTextField txtCustomerId) {
        txtCustomerId.setText(customer.findLastId());
    }

    public void loadCustomerDetails(TableView<?> tblCustomer, JFXTextField txtCustomerId, JFXTextField txtCustomerName, JFXTextField txtCustomerEmail, JFXTextField txtContactNumber) {
        if(!tblCustomer.getSelectionModel().isEmpty()){
            CustomerEntity selectedRow = (CustomerEntity) tblCustomer.getSelectionModel().getSelectedItem();

            txtCustomerId.setText(String.valueOf(selectedRow.getCustomerId()));
            txtCustomerName.setText(selectedRow.getName());
            txtCustomerEmail.setText(selectedRow.getEmail());
            txtContactNumber.setText(selectedRow.getContactNumber());
        }
    }
}
