package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import service.impl.ProductService;

public class ProductController {
    @FXML
    private JFXTextField txtProductName;

    @FXML
    private JFXTextField txtUnitPrice;

    @FXML
    private JFXTextField txtQtyOnHand;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXButton btnRegisterProduct;

    @FXML
    private TableView<?> tblProduct;

    @FXML
    private TableColumn<?, ?> colProductId;

    @FXML
    private TableColumn<?, ?> colProductName;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private TableColumn<?, ?> colQtyOnHand;

    @FXML
    private TableColumn<?, ?> colType;

    @FXML
    private JFXTextField txtProductId;

    @FXML
    private JFXComboBox<?> cmbType;

    ProductService productService = new ProductService();
    @FXML
    void btnClearOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnRegisterOnAction(ActionEvent event) {
        productService.registerProduct(txtProductId,txtProductName,txtQtyOnHand,txtUnitPrice,cmbType);
        productService.clear(txtProductId,txtProductName,txtQtyOnHand,txtUnitPrice,cmbType);
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }
}
