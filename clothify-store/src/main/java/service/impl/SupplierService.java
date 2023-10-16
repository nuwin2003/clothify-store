package service.impl;

import com.jfoenix.controls.JFXTextField;
import dao.custom.impl.SupplierImpl;
import dto.SupplierDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SupplierService {

    SupplierImpl supplier = new SupplierImpl();
    public void registerSupplier(JFXTextField txtSupplierId, JFXTextField txtSupplierName, JFXTextField txtSupplierEmail, JFXTextField txtContactNumber) {
        SupplierDto supplierDto = new SupplierDto(
                Integer.parseInt(txtSupplierId.getText()),
                txtSupplierName.getText(),
                txtSupplierEmail.getText(),
                txtContactNumber.getText()
        );
        if(supplier.save(supplierDto)){
            new Alert(Alert.AlertType.INFORMATION,"Supplier Saved!").show();
        }
    }

    public void clear(JFXTextField txtSupplierId, JFXTextField txtSupplierName, JFXTextField txtSupplierEmail, JFXTextField txtContactNumber) {
        txtSupplierId.setText("");
        txtSupplierName.setText("");
        txtSupplierEmail.setText("");
        txtContactNumber.setText("");
    }

    public void loadTable(TableView<SupplierDto> tblSupplier, TableColumn<?,?> colSupplierId, TableColumn<?,?> colSupplierName, TableColumn<?,?> colSupplierEmail, TableColumn<?,?> colContactNumber) {

        colSupplierId.setCellValueFactory(new PropertyValueFactory<>("supId"));
        colSupplierName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colSupplierEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colContactNumber.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));

        ObservableList<SupplierDto> list = FXCollections.observableArrayList(supplier.findAll());

        tblSupplier.setItems(list);

    }
}
