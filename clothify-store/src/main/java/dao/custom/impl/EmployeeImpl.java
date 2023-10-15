package dao.custom.impl;

import dao.custom.EmployeeDao;
import dto.EmployeeDto;
import entity.CustomerEntity;
import entity.EmployeeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
                .addAnnotatedClass(CustomerEntity.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.save(employee);
        return true;
    }

    @Override
    public boolean update(EmployeeDto dto) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public List<EmployeeDto> findAll() {
        return null;
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
