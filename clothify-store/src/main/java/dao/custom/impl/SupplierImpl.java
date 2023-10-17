package dao.custom.impl;

import dao.custom.SupplierDao;
import dto.CustomerDto;
import dto.SupplierDto;
import entity.CustomerEntity;
import entity.ProductEntity;
import entity.SupplierEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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
                .addAnnotatedClass(SupplierEntity.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(supplier);
        transaction.commit();

        session.close();
        sessionFactory.close();
        return true;
    }

    @Override
    public boolean update(SupplierDto dto) {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(SupplierEntity.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        SupplierEntity supplier = session.find(SupplierEntity.class, dto.getSupId());

        supplier.setName(dto.getName());
        supplier.setEmail(dto.getEmail());
        supplier.setContactNumber(dto.getContactNumber());

        Transaction transaction = session.beginTransaction();
        session.save(supplier);

        transaction.commit();

        session.close();
        sessionFactory.close();

        return true;
    }

    @Override
    public boolean delete(String s) {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(SupplierEntity.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.find(SupplierEntity.class,Integer.parseInt(s)));
        transaction.commit();

        session.close();
        sessionFactory.close();

        return true;
    }

    @Override
    public List<SupplierDto> findAll() {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(SupplierEntity.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Query query = session.createQuery("FROM SupplierEntity");
        List<SupplierDto> list = query.list();

        return list;
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
