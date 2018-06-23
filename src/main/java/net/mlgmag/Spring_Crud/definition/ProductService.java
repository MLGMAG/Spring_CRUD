package net.mlgmag.Spring_Crud.definition;

import net.mlgmag.Spring_Crud.model.Product;
import org.springframework.ui.Model;

import java.util.Optional;
import java.util.UUID;

public interface ProductService extends GenericService<Product, UUID> {

    Optional<Product> findByName(String name);

    Boolean productNameValidation(String name, Model model);

}
