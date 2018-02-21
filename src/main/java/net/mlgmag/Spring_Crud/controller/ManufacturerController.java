package net.mlgmag.Spring_Crud.controller;

import net.mlgmag.Spring_Crud.model.Manufacturer;
import net.mlgmag.Spring_Crud.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/manufacturer")
public class ManufacturerController {

    private final ManufacturerRepository manufacturerRepository;

    @Autowired
    public ManufacturerController(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @GetMapping("/list")
    public String manufacturersList(Model model) {
        model.addAttribute("manufacturers", manufacturerRepository.findAll());
        model.addAttribute("products", manufacturerRepository);
        return "manufacturersList";
    }

    @GetMapping("/add")
    public String manufacturerAddPage() {
        return "manufacturerAdd";
    }

    @PostMapping("/add")
    public String manufacturerAdd(@ModelAttribute("manufacturer") Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
        return "redirect:/manufacturer/list";
    }

    @GetMapping("/delete/{id}")
    public String manufacturerDelete(@PathVariable("id") UUID uuid) {
        manufacturerRepository.delete(manufacturerRepository.getOne(uuid));
        return "redirect:/manufacturer/list";
    }

    @GetMapping("/update/{id}")
    @Transactional
    public String manufacturerUpdatePage(@PathVariable("id") UUID uuid, Model model) {
        model.addAttribute("manufacturer", manufacturerRepository.getOne(uuid));
        System.out.println(manufacturerRepository.getOne(uuid));
        return "manufacturerUpdate";
    }

    @PostMapping("/update/{id}")
    public String manufacturerUpdate(@PathVariable("id") UUID uuid,
                                     @ModelAttribute("manufacturer") Manufacturer manufacturer) {

        manufacturer.setId(uuid);
        manufacturerRepository.saveAndFlush(manufacturer);

        return "redirect:/manufacturer/list";
    }

    @GetMapping("/{id}")
    @Transactional
    public String manufacturerView(@PathVariable("id") UUID uuid, Model model) {
        model.addAttribute("manufacturer", manufacturerRepository.getOne(uuid));
        model.addAttribute("products", manufacturerRepository.getOne(uuid).getProducts());
        System.out.println(manufacturerRepository.getOne(uuid));
        return "manufacturerView";
    }
}
