package net.mlgmag.Spring_Crud.service.service;

import net.mlgmag.Spring_Crud.model.Manufacturer;
import net.mlgmag.Spring_Crud.model.Product;
import org.springframework.ui.Model;

import java.util.UUID;

public interface ManufacturerService extends GenericService<Manufacturer, UUID> {

    Manufacturer findByName(String name);

    Boolean validate(Manufacturer manufacturer, Model model);

}
