package net.mlgmag.Spring_Crud.controller;

import net.mlgmag.Spring_Crud.model.Manufacturer;
import net.mlgmag.Spring_Crud.model.Product;
import net.mlgmag.Spring_Crud.repository.ManufacturerRepository;
import net.mlgmag.Spring_Crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository productRepository;

    private final ManufacturerRepository manufacturerRepository;

    @Autowired
    public ProductController(ManufacturerRepository manufacturerRepository, ProductRepository productRepository) {
        this.manufacturerRepository = manufacturerRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/list")
    public String productsList(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "productsList";
    }

    @GetMapping("/add")
    public String productAddPage(Model model) {
        model.addAttribute("manufacturers", manufacturerRepository.findAll());
        return "productAdd";
    }

    @PostMapping("/add")
    public String productAdd(@ModelAttribute("product") Product product,
                             @ModelAttribute("manufacturer") Manufacturer manufacturer) {

        product.setManufacturer(manufacturerRepository.getOne(manufacturer.getId()));
        productRepository.save(product);
        return "redirect:/product/list";
    }

    @GetMapping("/delete/{id}")
    public String productDelete(@PathVariable("id") UUID uuid) {
        productRepository.delete(productRepository.getOne(uuid));
        return "redirect:/product/list";
    }

    @GetMapping("/{id}")
    @Transactional
    public String productView(@PathVariable("id") UUID uuid, Model model) {
        model.addAttribute("product", productRepository.getOne(uuid));
        System.out.println(productRepository.getOne(uuid));
        return "productView";
    }

    @GetMapping("/update/{id}")
    @Transactional
    public String productUpdatePage(@PathVariable("id") UUID uuid, Model model) {
        model.addAttribute("manufacturers", manufacturerRepository.findAll());
        model.addAttribute("product", productRepository.getOne(uuid));
        System.out.println(productRepository.getOne(uuid));
        return "productUpdate";
    }


    @PostMapping("/update/{id}")
    public String productUpdate(@PathVariable("id") UUID uuid,
                                @ModelAttribute("product") Product product,
                                @ModelAttribute("manufacturer") Manufacturer manufacturer) {

        product.setId(uuid);
        product.setManufacturer(manufacturerRepository.getOne(manufacturer.getId()));
        productRepository.saveAndFlush(product);
        return "redirect:/product/list";
    }
}
