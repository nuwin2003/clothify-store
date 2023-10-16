package service.impl;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dao.custom.impl.ProductImpl;
import dto.ProductDto;
import javafx.scene.control.Alert;


public class ProductService {

    ProductImpl product = new ProductImpl();

    public void registerProduct(JFXTextField txtProductId, JFXTextField txtProductName, JFXTextField txtQtyOnHand, JFXTextField txtUnitPrice, JFXComboBox<?> cmbType) {
        ProductDto productDto = new ProductDto(
                txtProductId.getText(),
                txtProductName.getText(),
                Double.parseDouble(txtUnitPrice.getText()),
                Integer.parseInt(txtQtyOnHand.getText()),
                cmbType.getTypeSelector()
        );
        if (product.save(productDto)) {
            new Alert(Alert.AlertType.INFORMATION, "Product Saved !").showAndWait();
        }
    }

    public void clear(JFXTextField txtProductId, JFXTextField txtProductName, JFXTextField txtQtyOnHand, JFXTextField txtUnitPrice, JFXComboBox<?> cmbType) {
        txtProductId.setText("");
        txtProductName.setText("");
        txtQtyOnHand.setText("");
        txtUnitPrice.setText("");
        cmbType.setSelectionModel(null);
    }
}
