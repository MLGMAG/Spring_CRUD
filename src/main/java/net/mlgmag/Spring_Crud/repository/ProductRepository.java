package net.mlgmag.Spring_Crud.repository;

import net.mlgmag.Spring_Crud.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    Product findByName(String name);

}
