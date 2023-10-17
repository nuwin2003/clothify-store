package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.CustomerDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import service.impl.CustomerService;

import java.util.Optional;

public class CustomerController {
    @FXML
    private JFXTextField txtCustomerId;

    @FXML
    private JFXTextField txtCustomerName;

    @FXML
    private JFXTextField txtCustomerEmail;

    @FXML
    private JFXTextField txtContactNumber;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXButton btnRegisterCustomer;

    @FXML
    private TableView<CustomerDto> tblCustomer;

    @FXML
    private TableColumn<?, ?> colCustomerId;

    @FXML
    private TableColumn<?, ?> colCustomerName;

    @FXML
    private TableColumn<?, ?> colCustomerEmail;

    @FXML
    private TableColumn<?, ?> colContactNumber;

    CustomerService customerService = new CustomerService();

    public void initialize(){
        customerService.loadTable(tblCustomer,colCustomerId,colCustomerName,colCustomerEmail,colContactNumber);
        customerService.setId(txtCustomerId);
    }
    @FXML
    void btnClearOnAction(ActionEvent event) {
        customerService.clear(txtCustomerId,txtCustomerName,txtCustomerEmail,txtContactNumber);
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        Optional<ButtonType> buttonType = new Alert(Alert.AlertType.CONFIRMATION,"Do you want to Delete this Customer ?",ButtonType.YES,ButtonType.NO).showAndWait();
        if(buttonType.get() == ButtonType.YES){
            customerService.delete(txtCustomerId);
            customerService.loadTable(tblCustomer,colCustomerId,colCustomerName,colCustomerEmail,colContactNumber);
            customerService.clear(txtCustomerId,txtCustomerName,txtCustomerEmail,txtContactNumber);
        }
    }

    @FXML
    void btnRegisterOnAction(ActionEvent event) {
        Optional<ButtonType> buttonType = new Alert(Alert.AlertType.CONFIRMATION,"Do you want to Register this Customer ?",ButtonType.YES,ButtonType.NO).showAndWait();
        if(buttonType.get() == ButtonType.YES){
            customerService.registerCustomer(txtCustomerId,txtCustomerName,txtCustomerEmail,txtContactNumber);
            customerService.loadTable(tblCustomer,colCustomerId,colCustomerName,colCustomerEmail,colContactNumber);
            customerService.clear(txtCustomerId,txtCustomerName,txtCustomerEmail,txtContactNumber);
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        Optional<ButtonType> buttonType = new Alert(Alert.AlertType.CONFIRMATION,"Do you want to Update this Customer ?",ButtonType.YES,ButtonType.NO).showAndWait();
        if(buttonType.get() == ButtonType.YES){
            customerService.update(txtCustomerId,txtCustomerName,txtCustomerEmail,txtContactNumber);
            customerService.loadTable(tblCustomer,colCustomerId,colCustomerName,colCustomerEmail,colContactNumber);
            customerService.clear(txtCustomerId,txtCustomerName,txtCustomerEmail,txtContactNumber);
        }
    }

    @FXML
    void tblCustomerOnClick(MouseEvent event) {
        customerService.loadCustomerDetails(tblCustomer,txtCustomerId,txtCustomerName,txtCustomerEmail,txtContactNumber);
    }
}
