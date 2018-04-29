package net.mlgmag.Spring_Crud.repository;

import net.mlgmag.Spring_Crud.model.Manufacturer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends MongoRepository<Manufacturer, String> {

    Manufacturer findByName(String name);

}
