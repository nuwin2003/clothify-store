package dao.custom.impl;

import dao.custom.EmployeeDao;
import dto.EmployeeDto;

import java.util.List;

public class EmployeeImpl implements EmployeeDao {
    @Override
    public boolean save(EmployeeDto dto) {
        return false;
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
