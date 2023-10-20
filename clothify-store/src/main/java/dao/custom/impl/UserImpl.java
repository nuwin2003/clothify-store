package dao.custom.impl;

import dao.custom.UserDao;
import dto.UserDto;
import entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class UserImpl implements UserDao {
    @Override
    public boolean save(UserDto dto) {
        UserEntity user = new UserEntity(
                dto.getUserId(),
                dto.getUserName(),
                dto.getPassword(),
                dto.getEmail(),
                dto.getContactNumber(),
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

    @Override
    public UserEntity findUser(String userName,String password) {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(UserEntity.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query<UserEntity> query = session.createQuery("From UserEntity WHERE userName = :userName ", UserEntity.class);
        query.setParameter("userName", userName);
        UserEntity user = query.uniqueResult();

        if(user != null && user.getPassword().equals(password)){
            transaction.commit();
            return user;
        }else{
            transaction.rollback();
            return null;
        }
    }
}
