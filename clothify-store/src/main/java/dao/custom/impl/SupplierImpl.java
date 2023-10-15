package dao.custom.impl;

import dao.custom.SupplierDao;
import dto.SupplierDto;
import entity.CustomerEntity;
import entity.SupplierEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class SupplierImpl implements SupplierDao {
    @Override
    public boolean save(SupplierDto dto) {
        SupplierEntity supplier = new SupplierEntity(
                dto.getSupId(),
                dto.getName(),
                dto.getEmail(),
                dto.getContactNumber()
        );
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(CustomerEntity.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.save(supplier);
        return true;
    }

    @Override
    public boolean update(SupplierDto dto) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public List<SupplierDto> findAll() {
        return null;
    }

    @Override
    public String findLastId() {
        return null;
    }

    @Override
    public SupplierDto findById(String s) {
        return null;
    }
}
