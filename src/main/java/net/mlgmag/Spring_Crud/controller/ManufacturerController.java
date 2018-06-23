package net.mlgmag.Spring_Crud.controller;

import net.mlgmag.Spring_Crud.definition.ManufacturerService;
import net.mlgmag.Spring_Crud.model.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/manufacturer")
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    @Autowired
    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @GetMapping("/add")
    public String manufacturerAddPage(Model model) {
        model.addAttribute(new Manufacturer());
        model.addAttribute("title", "Add Manufacturer");
        return "Manufacturer/manufacturerAdd";
    }

    @PostMapping("/add")
    public String manufacturerAdd(@ModelAttribute("manufacturer") Manufacturer manufacturer, Model model) {

        if (manufacturerService.validate(manufacturer, model)) {
            model.addAttribute("title", "Add Manufacturer");
            return "Manufacturer/manufacturerAdd";
        }

        manufacturerService.save(manufacturer);
        return "redirect:/manufacturer/list";
    }

    @GetMapping("/update")
    public String manufacturerUpdatePage(@RequestParam(value = "id") UUID id, Model model) {
        model.addAttribute("manufacturer", manufacturerService.findById(id).orElse(null));
        model.addAttribute("title", "Edit Manufacturer");
        return "Manufacturer/manufacturerUpdate";
    }

    @PostMapping("/update")
    public String manufacturerUpdate(@ModelAttribute("manufacturer") Manufacturer manufacturer, Model model) {

        if (!manufacturer.getName().equals(manufacturerService
                .findById(manufacturer.getId()).map(Manufacturer::getName).orElse(null))) {
            if (manufacturerService.findByName(manufacturer.getName()) != null) {
                model.addAttribute("DuplicateManufacturer", "Manufacturer name already exist");
                model.addAttribute("title", "Edit Manufacturer");
                return "Manufacturer/manufacturerUpdate";
            }
        }

        manufacturerService.update(manufacturer);
        return "redirect:/manufacturer/list";
    }

    @GetMapping("/delete")
    public String manufacturerDelete(@RequestParam(value = "id") UUID id) {
        manufacturerService.findById(id).ifPresent(manufacturerService::delete);
        return "redirect:/manufacturer/list";
    }

    @GetMapping("/")
    public String manufacturerView(@RequestParam(value = "id") UUID id, Model model) {

        Optional<Manufacturer> manufacturerOptional = manufacturerService.findById(id);

        model.addAttribute("manufacturer", manufacturerOptional.orElse(null));
        model.addAttribute("products", manufacturerOptional.map(Manufacturer::getProducts).orElse(null));
        model.addAttribute("title", "Manufacturer");
        return "Manufacturer/manufacturerView";
    }

    @GetMapping("/list")
    public String manufacturersList(Model model) {
        model.addAttribute("manufacturers", manufacturerService.findAll());
        model.addAttribute("title", "Manufacturers");
        return "Manufacturer/manufacturersList";
    }

}
