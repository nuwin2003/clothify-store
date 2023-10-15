package dao.custom.impl;

import dao.custom.CustomerDao;
import db.DBConnection;
import dto.CustomerDto;
import entity.CustomerEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;
import java.util.List;

public class CustomerImpl implements CustomerDao {
    @Override
    public boolean save(CustomerDto dto) {
        boolean isSaved = false;
        CustomerEntity customer = new CustomerEntity(
                dto.getCustomerId(),
                dto.getName(),
                dto.getEmail(),
                dto.getContactNumber()
        );
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Insert into customer Values(?,?,?,?)");
            preparedStatement.setObject(1,customer.getCustomerId());
            preparedStatement.setObject(2,customer.getName());
            preparedStatement.setObject(3,customer.getEmail());
            preparedStatement.setObject(4,customer.getContactNumber());

            if(preparedStatement.executeUpdate() > 0){
                isSaved =  true;
            }
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
        return isSaved;
    }

    @Override
    public boolean update(CustomerDto dto) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public List<CustomerDto> findAll() {
        return null;
    }

    @Override
    public String findLastId() {
        return null;
    }

    @Override
    public CustomerDto findById(String s) {
        return null;
    }

    @Override
    public void loadTable(TableView<CustomerEntity> tblCustomer, TableColumn<?,?> colCustomerId, TableColumn<?,?> colCustomerName, TableColumn<?,?> colCustomerEmail, TableColumn<?,?> colContactNumber) {
        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCustomerEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colContactNumber.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));

        ObservableList<CustomerEntity> list = FXCollections.observableArrayList();

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from customer");
            while (resultSet.next()){
                list.add(new CustomerEntity(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                ));
            }
            tblCustomer.setItems(list);
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }
}
