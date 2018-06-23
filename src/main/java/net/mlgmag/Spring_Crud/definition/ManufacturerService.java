package net.mlgmag.Spring_Crud.definition;

import net.mlgmag.Spring_Crud.model.Manufacturer;
import org.springframework.ui.Model;

import java.util.Optional;
import java.util.UUID;

public interface ManufacturerService extends GenericService<Manufacturer, UUID> {

    Optional<Manufacturer> findByName(String name);

    Boolean validate(Manufacturer manufacturer, Model model);

}
