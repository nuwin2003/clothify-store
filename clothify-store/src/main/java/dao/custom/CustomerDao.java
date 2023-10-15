package dao.custom;

import dao.CrudDao;
import dto.CustomerDto;
import entity.CustomerEntity;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public interface CustomerDao extends CrudDao<CustomerDto,String> {
    public void loadTable(TableView<CustomerEntity> tblCustomer, TableColumn<?,?> colCustomerId, TableColumn<?,?> colCustomerName, TableColumn<?,?> colCustomerEmail, TableColumn<?,?> colContactNumber);
}
