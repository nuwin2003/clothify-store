package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import service.impl.PlaceOrderService;

public class PlaceOrderFormController {
    @FXML
    private JFXButton btnRemove;

    @FXML
    private JFXButton btnRegisterCustomer;

    @FXML
    private JFXTextField txtCustomerName;

    @FXML
    private JFXComboBox<?> cmbItemCode;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXComboBox<?> cmbCustomerId;

    @FXML
    private JFXTextField txtQty;

    @FXML
    private JFXButton btnAddToCart;

    @FXML
    private TableView<?> tblPlaceOrder;

    @FXML
    private TableColumn<?, ?> colItemId;

    @FXML
    private TableColumn<?, ?> colItemName;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private TableColumn<?, ?> colAmount;

    @FXML
    private Label lblTotal;

    @FXML
    private Label lblBalance;

    @FXML
    private JFXButton btnPlaceOrder;

    @FXML
    private Label lblOrderId;

    @FXML
    private Label lblItemName;

    PlaceOrderService placeOrderService = new PlaceOrderService();
    @FXML
    void btnAddToCartOnAction(ActionEvent event) {

    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {

    }

    @FXML
    void btnRegisterCustomerOnAction(ActionEvent event) {

    }

    @FXML
    void btnRemoveOnAction(ActionEvent event) {

    }
}
