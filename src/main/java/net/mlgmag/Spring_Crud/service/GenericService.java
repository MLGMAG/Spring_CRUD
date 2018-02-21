package net.mlgmag.Spring_Crud.service;

import java.util.List;

public interface GenericService<T, ID> {

    void save(T t);

    T getById(ID id);

    void update(T t);

    void delete(T t);

    List<T> getAll();
}
