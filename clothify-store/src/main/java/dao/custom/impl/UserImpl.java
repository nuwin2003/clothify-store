package dao.custom.impl;

import dao.custom.UserDao;
import dto.UserDto;
import entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UserImpl implements UserDao {
    @Override
    public boolean save(UserDto dto) {
        UserEntity user = new UserEntity(
                dto.getUserId(),
                dto.getUserName(),
                dto.getPassword(),
                dto.getType()
        );
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(UserEntity.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();

        session.close();
        sessionFactory.close();
        return true;
    }

    @Override
    public boolean update(UserDto dto) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public List<UserDto> findAll() {
        return null;
    }

    @Override
    public String findLastId() {
        return null;
    }

    @Override
    public UserDto findById(String s) {
        return null;
    }
}
