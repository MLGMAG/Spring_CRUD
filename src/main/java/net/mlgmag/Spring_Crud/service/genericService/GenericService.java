package net.mlgmag.Spring_Crud.service.genericService;

import java.util.List;

public interface GenericService<T, ID> {

    void save(T t);

    void update(T t);

    void delete(T t);

    T getById(ID uuid);

    List<T> getAll();

}
