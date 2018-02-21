package net.mlgmag.Spring_Crud.controller;

import net.mlgmag.Spring_Crud.model.Manufacturer;
import net.mlgmag.Spring_Crud.model.Product;
import net.mlgmag.Spring_Crud.repository.ManufacturerRepository;
import net.mlgmag.Spring_Crud.repository.ProductRepository;
import net.mlgmag.Spring_Crud.service.service.ManufacturerService;
import net.mlgmag.Spring_Crud.service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    private final ManufacturerService manufacturerService;

    @Autowired
    public ProductController(ManufacturerService manufacturerService, ProductService productService) {
        this.manufacturerService = manufacturerService;
        this.productService = productService;
    }

    @GetMapping("/add")
    public String productAddPage(Model model) {
        model.addAttribute("manufacturers", manufacturerService.getAll());
        return "productAdd";
    }

    @PostMapping("/add")
    public String productAdd(@ModelAttribute("product") Product product,
                             @ModelAttribute("manufacturer") Manufacturer manufacturer) {

        product.setManufacturer(manufacturerService.getById(manufacturer.getId()));
        productService.save(product);
        return "redirect:/product/list";
    }

    @GetMapping("/update/{id}")
    public String productUpdatePage(@PathVariable("id") UUID uuid, Model model) {
        model.addAttribute("manufacturers", manufacturerService.getAll());
        model.addAttribute("product", productService.getById(uuid));
        return "productUpdate";
    }

    @PostMapping("/update/{id}")
    public String productUpdate(@PathVariable("id") UUID uuid,
                                @ModelAttribute("product") Product product,
                                @ModelAttribute("manufacturer") Manufacturer manufacturer) {

        product.setId(uuid);
        product.setManufacturer(manufacturerService.getById(manufacturer.getId()));
        return "redirect:/product/list";
    }

    @GetMapping("/delete/{id}")
    public String productDelete(@PathVariable("id") UUID uuid) {
        productService.delete(productService.getById(uuid));
        return "redirect:/product/list";
    }

    @GetMapping("/{id}")
    public String productView(@PathVariable("id") UUID uuid, Model model) {
        model.addAttribute("product", productService.getById(uuid));
        return "productView";
    }

    @GetMapping("/list")
    public String productsList(Model model) {
        model.addAttribute("products", productService.getAll());
        return "productsList";
    }
}
