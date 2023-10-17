package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.ProductDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import service.impl.ProductService;

import java.util.Optional;

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
    private TableView<ProductDto> tblProduct;

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
    private JFXComboBox<String> cmbType;

    ProductService productService = new ProductService();

    public void initialize(){
        productService.setItems(cmbType);
        productService.loadTable(tblProduct,colProductId,colProductName,colUnitPrice,colQtyOnHand,colType);
    }
    @FXML
    void btnClearOnAction(ActionEvent event) {
        productService.clear(txtProductId,txtProductName,txtQtyOnHand,txtUnitPrice,cmbType);
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        Optional<ButtonType> buttonType = new Alert(Alert.AlertType.CONFIRMATION,"Do you want to Delete this Product ?",ButtonType.YES,ButtonType.NO).showAndWait();
        if(buttonType.get() == ButtonType.YES) {
            productService.delete(txtProductId);
            productService.loadTable(tblProduct, colProductId, colProductName, colUnitPrice, colQtyOnHand, colType);
            productService.clear(txtProductId, txtProductName, txtQtyOnHand, txtUnitPrice, cmbType);
        }
    }

    @FXML
    void btnRegisterOnAction(ActionEvent event) {
        Optional<ButtonType> buttonType = new Alert(Alert.AlertType.CONFIRMATION,"Do you want to Register this Product ?",ButtonType.YES,ButtonType.NO).showAndWait();
        if(buttonType.get() == ButtonType.YES) {
            productService.registerProduct(txtProductId, txtProductName, txtQtyOnHand, txtUnitPrice, cmbType);
            productService.loadTable(tblProduct, colProductId, colProductName, colUnitPrice, colQtyOnHand, colType);
            productService.clear(txtProductId, txtProductName, txtQtyOnHand, txtUnitPrice, cmbType);
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        Optional<ButtonType> buttonType = new Alert(Alert.AlertType.CONFIRMATION,"Do you want to Update this Product ?",ButtonType.YES,ButtonType.NO).showAndWait();
        if(buttonType.get() == ButtonType.YES){
            productService.update(txtProductId,txtProductName,txtUnitPrice,txtQtyOnHand,cmbType);
            productService.loadTable(tblProduct, colProductId, colProductName, colUnitPrice, colQtyOnHand, colType);
            productService.clear(txtProductId, txtProductName, txtQtyOnHand, txtUnitPrice, cmbType);
        }
    }

    @FXML
    void tblProductOnClick(MouseEvent event) {
        productService.loadProductDetails(tblProduct,txtProductId,txtProductName,txtUnitPrice,txtQtyOnHand,cmbType);
    }
}
