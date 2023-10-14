package dao.custom.impl;

import dao.custom.ProductDao;
import dto.ProductDto;

import java.util.List;

public class ProductImpl implements ProductDao {
    @Override
    public boolean save(ProductDto dto) {
        return false;
    }

    @Override
    public boolean update(ProductDto dto) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public List<ProductDto> findAll() {
        return null;
    }

    @Override
    public String findLastId() {
        return null;
    }

    @Override
    public ProductDto findById(String s) {
        return null;
    }
}
