package net.mlgmag.Spring_Crud.definition;

import org.springframework.ui.Model;

import java.util.List;

public interface GenericService<T, ID> {

    void save(T t);

    void delete(T t);

    T findById(ID id);

    List<T> findAll();

    Boolean saveValidation(T t, Model model);

    Boolean updateValidation(T t, Model model);

}
