package net.mlgmag.Spring_Crud.service.genericService;

import net.mlgmag.Spring_Crud.model.Product;
import org.springframework.ui.Model;

import java.util.UUID;

public interface ProductService extends GenericService<Product, UUID> {

    Product findByName(String name);

    Boolean validate(Product product, Model model);

}
