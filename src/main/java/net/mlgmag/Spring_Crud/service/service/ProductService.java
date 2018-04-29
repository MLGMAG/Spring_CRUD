package net.mlgmag.Spring_Crud.service.service;

import net.mlgmag.Spring_Crud.model.Product;
import org.springframework.ui.Model;

public interface ProductService extends GenericService<Product, String> {

    Product findByName(String name);

    Boolean validate(Product product, Model model);

}
