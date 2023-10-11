package dao;

import java.util.List;

public interface CrudDao <T, ID>{
    boolean save(T dto);
    boolean update(T dto);
    boolean delete(ID id);
    List<T> findAll();
    ID findLastId();
    T findById(ID id);
}
