package dao.custom.impl;

import dao.custom.EmployeeDao;
import dto.EmployeeDto;
import entity.EmployeeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeImpl implements EmployeeDao {
    @Override
    public boolean save(EmployeeDto dto) {
        EmployeeEntity employee = new EmployeeEntity(
                dto.getEmpId(),
                dto.getEmpName(),
                dto.getEmail(),
                dto.getContactNumber()
        );
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(EmployeeEntity.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();

        session.close();
        sessionFactory.close();
        return true;
    }

    @Override
    public boolean update(EmployeeDto dto) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(EmployeeEntity.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.find(EmployeeEntity.class,Integer.parseInt(s)));
        transaction.commit();

        session.close();
        sessionFactory.close();
        return true;
    }

    @Override
    public List<EmployeeDto> findAll() {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(EmployeeEntity.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Query query = session.createQuery("FROM EmployeeEntity");
        List<EmployeeDto> list = query.list();

        return list;
    }

    @Override
    public String findLastId() {
        return null;
    }

    @Override
    public EmployeeDto findById(String s) {
        return null;
    }
}
