package dao.custom.impl;

import dao.custom.CustomerDao;
import db.DBConnection;
import dto.CustomerDto;
import entity.CustomerEntity;
import entity.EmployeeEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.*;
import java.util.List;

public class CustomerImpl implements CustomerDao {
    @Override
    public boolean save(CustomerDto dto) {
        CustomerEntity customer = new CustomerEntity(
                dto.getCustomerId(),
                dto.getName(),
                dto.getEmail(),
                dto.getContactNumber()
        );
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(CustomerEntity.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();

        session.close();
        sessionFactory.close();
        return true;
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
