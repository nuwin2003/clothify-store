package service.impl;

import com.jfoenix.controls.JFXTextField;
import dao.custom.impl.SupplierImpl;
import dto.SupplierDto;
import javafx.scene.control.Alert;

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
}
