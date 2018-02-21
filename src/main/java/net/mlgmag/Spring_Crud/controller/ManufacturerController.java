package net.mlgmag.Spring_Crud.controller;

import net.mlgmag.Spring_Crud.model.Manufacturer;
import net.mlgmag.Spring_Crud.repository.ManufacturerRepository;
import net.mlgmag.Spring_Crud.service.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String manufacturerAddPage() {
        return "manufacturerAdd";
    }

    @PostMapping("/add")
    public String manufacturerAdd(@ModelAttribute("manufacturer") Manufacturer manufacturer) {
        manufacturerService.save(manufacturer);
        return "redirect:/manufacturer/list";
    }

    @GetMapping("/update/{id}")
    public String manufacturerUpdatePage(@PathVariable("id") UUID uuid, Model model) {
        model.addAttribute("manufacturer", manufacturerService.getById(uuid));
        return "manufacturerUpdate";
    }

    @PostMapping("/update/{id}")
    public String manufacturerUpdate(@PathVariable("id") UUID uuid,
                                     @ModelAttribute("manufacturer") Manufacturer manufacturer) {

        manufacturer.setId(uuid);
        manufacturerService.update(manufacturer);

        return "redirect:/manufacturer/list";
    }

    @GetMapping("/delete/{id}")
    public String manufacturerDelete(@PathVariable("id") UUID uuid) {
        manufacturerService.delete(manufacturerService.getById(uuid));
        return "redirect:/manufacturer/list";
    }

    @GetMapping("/{id}")
    public String manufacturerView(@PathVariable("id") UUID uuid, Model model) {
        model.addAttribute("manufacturer", manufacturerService.getById(uuid));
        model.addAttribute("products", manufacturerService.getById(uuid).getProducts());
        return "manufacturerView";
    }

    @GetMapping("/list")
    public String manufacturersList(Model model) {
        model.addAttribute("manufacturers", manufacturerService.getAll());
        model.addAttribute("products", manufacturerService);
        return "manufacturersList";
    }
}
