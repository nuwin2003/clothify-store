package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AdminCustomerController {
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
    private TableView<?> tblCustomer;

    @FXML
    private TableColumn<?, ?> colCustomerId;

    @FXML
    private TableColumn<?, ?> colCustomerName;

    @FXML
    private TableColumn<?, ?> colCustomerEmail;

    @FXML
    private TableColumn<?, ?> colContactNumber;
}
