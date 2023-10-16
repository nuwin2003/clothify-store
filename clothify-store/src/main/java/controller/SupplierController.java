package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.SupplierDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import service.impl.SupplierService;

import java.util.Optional;

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
    private TableView<SupplierDto> tblSupplier;

    @FXML
    private TableColumn<?, ?> colSupplierId;

    @FXML
    private TableColumn<?, ?> colSupplierName;

    @FXML
    private TableColumn<?, ?> colSupplierEmail;

    @FXML
    private TableColumn<?, ?> colContactNumber;

    SupplierService supplierService = new SupplierService();

    public void initialize(){
        supplierService.loadTable(tblSupplier,colSupplierId,colSupplierName,colSupplierEmail,colContactNumber);
    }
    @FXML
    void btnClearOnAction(ActionEvent event) {
        supplierService.clear(txtSupplierId,txtSupplierName,txtSupplierEmail,txtContactNumber);
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        Optional<ButtonType> buttonType = new Alert(Alert.AlertType.CONFIRMATION,"Do you want to Delete this Supplier ?", ButtonType.YES,ButtonType.NO).showAndWait();
        if(buttonType.get() == ButtonType.YES){
            supplierService.delete(txtSupplierId);
            supplierService.loadTable(tblSupplier,colSupplierId,colSupplierName,colSupplierEmail,colContactNumber);
            supplierService.clear(txtSupplierId,txtSupplierName,txtSupplierEmail,txtContactNumber);
        }
    }

    @FXML
    void btnRegisterSupplierOnAction(ActionEvent event) {
        Optional<ButtonType> buttonType = new Alert(Alert.AlertType.CONFIRMATION,"Do you want to Register this Supplier ?",ButtonType.YES,ButtonType.NO).showAndWait();
        if(buttonType.get() == ButtonType.YES){
            supplierService.registerSupplier(txtSupplierId,txtSupplierName,txtSupplierEmail,txtContactNumber);
            supplierService.loadTable(tblSupplier,colSupplierId,colSupplierName,colSupplierEmail,colContactNumber);
            supplierService.clear(txtSupplierId,txtSupplierName,txtSupplierEmail,txtContactNumber);
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void tblSupplierOnClick(MouseEvent event) {
        supplierService.loadSupplierDetails(tblSupplier,txtSupplierId,txtSupplierName,txtSupplierEmail,txtContactNumber);
    }
}
