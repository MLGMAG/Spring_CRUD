package net.mlgmag.Spring_Crud.service.genericService;

import net.mlgmag.Spring_Crud.model.Manufacturer;
import org.springframework.ui.Model;

import java.util.UUID;

public interface ManufacturerService extends GenericService<Manufacturer, UUID> {

    Manufacturer findByName(String name);

    Boolean validate(Manufacturer manufacturer, Model model);

}
