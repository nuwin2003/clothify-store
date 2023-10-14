package dao.custom.impl;

import dao.custom.SupplierDao;
import dto.SupplierDto;

import java.util.List;

public class SupplierImpl implements SupplierDao {
    @Override
    public boolean save(SupplierDto dto) {
        return false;
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
