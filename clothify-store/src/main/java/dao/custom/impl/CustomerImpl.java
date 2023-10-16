package dao.custom.impl;

import dao.custom.CustomerDao;
import dto.CustomerDto;
import entity.CustomerEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.math.BigInteger;
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
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(CustomerEntity.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Query query = session.createQuery("FROM CustomerEntity");
        List<CustomerDto> list = query.list();

        return list;
    }

    @Override
    public String findLastId() {
        return null;
    }

    @Override
    public CustomerDto findById(String s) {
        return null;
    }

}
