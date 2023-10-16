package service.impl;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dao.custom.impl.ProductImpl;
import dto.ProductDto;
import entity.ProductEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class ProductService {

    ProductImpl product = new ProductImpl();

    public void registerProduct(JFXTextField txtProductId, JFXTextField txtProductName, JFXTextField txtQtyOnHand, JFXTextField txtUnitPrice, JFXComboBox<?> cmbType) {
        ProductDto productDto = new ProductDto(
                Integer.parseInt(txtProductId.getText()),
                txtProductName.getText(),
                Double.parseDouble(txtUnitPrice.getText()),
                Integer.parseInt(txtQtyOnHand.getText()),
                (String) cmbType.getValue()
        );
        if (product.save(productDto)) {
            new Alert(Alert.AlertType.INFORMATION, "Product Registered!").showAndWait();
        }
    }

    public void clear(JFXTextField txtProductId, JFXTextField txtProductName, JFXTextField txtQtyOnHand, JFXTextField txtUnitPrice, JFXComboBox<?> cmbType) {
        txtProductId.setText("");
        txtProductName.setText("");
        txtQtyOnHand.setText("");
        txtUnitPrice.setText("");
        cmbType.setValue(null);
    }

    public void loadTable(TableView<ProductDto> tblProduct, TableColumn<?,?> colProductId, TableColumn<?,?> colProductName, TableColumn<?,?> colUnitPrice, TableColumn<?,?> colQtyOnHand, TableColumn<?,?> colType) {
        colProductId.setCellValueFactory(new PropertyValueFactory<>("prodId"));
        colProductName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colQtyOnHand.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));

        ObservableList<ProductDto> list = FXCollections.observableArrayList(product.findAll());

        tblProduct.setItems(list);
    }

    public void setItems(JFXComboBox<String> cmbType) {
        ObservableList<String> observableList = FXCollections.observableArrayList("Gents","Ladies","Kids");
        cmbType.setItems(observableList);
    }

    public void loadProductDetails(TableView<?> tblProduct, JFXTextField txtProductId, JFXTextField txtProductName, JFXTextField txtUnitPrice, JFXTextField txtQtyOnHand, JFXComboBox<String> cmbType) {
        if(!tblProduct.getSelectionModel().isEmpty()){
            ProductEntity selectedRow = (ProductEntity) tblProduct.getSelectionModel().getSelectedItem();

            txtProductId.setText(String.valueOf(selectedRow.getProdId()));
            txtProductName.setText(selectedRow.getName());
            txtUnitPrice.setText(String.valueOf(selectedRow.getUnitPrice()));
            txtQtyOnHand.setText(String.valueOf(selectedRow.getQtyOnHand()));
            cmbType.setValue(selectedRow.getType());
        }
    }

    public void delete(JFXTextField txtProductId) {
        String id = txtProductId.getText();
        if(product.delete(id)){
            new Alert(Alert.AlertType.INFORMATION,"Product Deleted!").show();
        }
    }
}
