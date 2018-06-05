package net.mlgmag.Spring_Crud.service.genericService;

import java.util.List;
import java.util.Optional;

public interface GenericService<T, ID> {

    void save(T t);

    void update(T t);

    void delete(T t);

    Optional<T> findById(ID uuid);

    List<T> findAll();

}
