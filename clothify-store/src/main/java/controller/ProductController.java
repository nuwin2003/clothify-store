package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.ProductDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnRegisterOnAction(ActionEvent event) {
        productService.registerProduct(txtProductId,txtProductName,txtQtyOnHand,txtUnitPrice,cmbType);
        productService.loadTable(tblProduct,colProductId,colProductName,colUnitPrice,colQtyOnHand,colType);
        productService.clear(txtProductId,txtProductName,txtQtyOnHand,txtUnitPrice,cmbType);
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }
}
