package net.mlgmag.Spring_Crud.controller;

import net.mlgmag.Spring_Crud.model.Manufacturer;
import net.mlgmag.Spring_Crud.service.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        model.addAttribute("manufacturer", new Manufacturer());
        return "Manufacturer/manufacturerAdd";
    }

    @PostMapping("/add")
    public String manufacturerAdd(@ModelAttribute("manufacturer") @Valid Manufacturer manufacturer, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            manufacturerService.validate(manufacturer, model);
            return "Manufacturer/manufacturerAdd";
        }

        if (!bindingResult.hasErrors()) {
            if (manufacturerService.validate(manufacturer, model)) {
                return "Manufacturer/manufacturerAdd";
            }
        }

        manufacturerService.save(manufacturer);
        return "redirect:/manufacturer/list";
    }

    @GetMapping("/update/")
    public String manufacturerUpdatePage(@RequestParam(value = "id") UUID uuid, Model model) {
        model.addAttribute("manufacturer", manufacturerService.getById(uuid));
        return "Manufacturer/manufacturerUpdate";
    }

    @PostMapping("/update/")
    public String manufacturerUpdate(@ModelAttribute("manufacturer") @Valid Manufacturer manufacturer, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "Manufacturer/manufacturerUpdate";
        }

        if (!bindingResult.hasErrors()) {
            if (!manufacturer.getName().equals(manufacturerService.getById(manufacturer.getId()).getName())) {
                if (manufacturerService.findByName(manufacturer.getName()) != null){
                    model.addAttribute("DuplicateManufacturer", "Manufacturer name already exist");
                    return "Manufacturer/manufacturerUpdate";
                }
            }
        }

        manufacturerService.update(manufacturer);
        return "redirect:/manufacturer/list";
    }

    @GetMapping("/delete/")
    public String manufacturerDelete(@RequestParam(value = "id") UUID uuid) {
        manufacturerService.delete(manufacturerService.getById(uuid));
        return "redirect:/manufacturer/list";
    }

    @GetMapping("/")
    public String manufacturerView(@RequestParam(value = "id") UUID uuid, Model model) {
        model.addAttribute("manufacturer", manufacturerService.getById(uuid));
        model.addAttribute("products", manufacturerService.getById(uuid).getProducts());
        return "Manufacturer/manufacturerView";
    }

    @GetMapping("/list")
    public String manufacturersList(Model model) {
        model.addAttribute("manufacturers", manufacturerService.getAll());
        model.addAttribute("products", manufacturerService);
        return "Manufacturer/manufacturersList";
    }

}
