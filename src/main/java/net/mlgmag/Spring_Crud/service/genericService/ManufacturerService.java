package net.mlgmag.Spring_Crud.service.genericService;

import net.mlgmag.Spring_Crud.model.Manufacturer;
import org.springframework.ui.Model;

public interface ManufacturerService extends GenericService<Manufacturer, String> {

    Manufacturer findByName(String name);

    Boolean validate(Manufacturer manufacturer, Model model);

}
