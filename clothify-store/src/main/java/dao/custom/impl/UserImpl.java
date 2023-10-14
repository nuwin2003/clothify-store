package dao.custom.impl;

import dao.custom.UserDao;
import dto.UserDto;

import java.util.List;

public class UserImpl implements UserDao {
    @Override
    public boolean save(UserDto dto) {
        return false;
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
