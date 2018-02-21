package net.mlgmag.Spring_Crud.dao;

import java.util.List;

public interface GenericDao<T, ID> {
    void save(T t);

    T getById(ID id);

    void update(T t);

    void delete(T t);

    List<T> getAll();
}
