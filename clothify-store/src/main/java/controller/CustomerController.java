package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.CustomerDto;
import entity.CustomerEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import service.impl.CustomerService;

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

    }

    @FXML
    void btnRegisterOnAction(ActionEvent event) {
        customerService.registerCustomer(txtCustomerId,txtCustomerName,txtCustomerEmail,txtContactNumber);
        customerService.loadTable(tblCustomer,colCustomerId,colCustomerName,colCustomerEmail,colContactNumber);
        customerService.clear(txtCustomerId,txtCustomerName,txtCustomerEmail,txtContactNumber);
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void tblCustomerOnClick(MouseEvent event) {
        customerService.loadCustomerDetails(tblCustomer,txtCustomerId,txtCustomerName,txtCustomerEmail,txtContactNumber);
    }
}
