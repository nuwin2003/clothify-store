package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import service.impl.SupplierService;

public class SupplierController {
    @FXML
    private JFXTextField txtSupplierId;

    @FXML
    private JFXTextField txtSupplierName;

    @FXML
    private JFXTextField txtSupplierEmail;

    @FXML
    private JFXTextField txtContactNumber;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXButton btnRegisterSupplier;

    @FXML
    private TableView<?> tblSupplier;

    @FXML
    private TableColumn<?, ?> colSupplierId;

    @FXML
    private TableColumn<?, ?> colSupplierName;

    @FXML
    private TableColumn<?, ?> colSupplierEmail;

    @FXML
    private TableColumn<?, ?> colContactNumber;

    SupplierService supplierService = new SupplierService();
    @FXML
    void btnClearOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnRegisterSupplierOnAction(ActionEvent event) {
        supplierService.registerSupplier(txtSupplierId,txtSupplierName,txtSupplierEmail,txtContactNumber);
        supplierService.clear(txtSupplierId,txtSupplierName,txtSupplierEmail,txtContactNumber);
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }
}
