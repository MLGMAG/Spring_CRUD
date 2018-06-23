package net.mlgmag.Spring_Crud.definition;

import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

public interface GenericService<T, ID> {

    void save(T t);

    void update(T t);

    void delete(T t);

    Optional<T> findById(ID uuid);

    List<T> findAll();

    Boolean saveValidation(T t, Model model);

    Boolean updateValidation(T t, Model model);

}
