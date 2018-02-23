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
        return "Product/productAdd";
    }

    @PostMapping("/add")
    public String productAdd(@ModelAttribute("product") Product product,
                             @ModelAttribute("manufacturer") Manufacturer manufacturer) {

        product.setManufacturer(manufacturerService.getById(manufacturer.getId()));
        productService.save(product);
        return "redirect:/product/list";
    }

    @GetMapping("/update/")
    public String productUpdatePage(@RequestParam(value = "id") UUID uuid, Model model) {
        model.addAttribute("manufacturers", manufacturerService.getAll());
        model.addAttribute("product", productService.getById(uuid));
        return "Product/productUpdate";
    }

    @PostMapping("/update/")
    public String productUpdate(@ModelAttribute("product") Product product) {
        product.getManufacturer().setName(manufacturerService.getById(product.getManufacturer().getId()).getName());
        productService.update(product);
        return "redirect:/product/list";
    }

    @GetMapping("/delete/")
    public String productDelete(@RequestParam(value = "id") UUID uuid) {
        productService.delete(productService.getById(uuid));
        return "redirect:/product/list";
    }

    @GetMapping("/")
    public String productView(@RequestParam(value = "id") UUID uuid, Model model) {
        model.addAttribute("product", productService.getById(uuid));
        return "Product/productView";
    }

    @GetMapping("/list")
    public String productsList(Model model) {
        model.addAttribute("products", productService.getAll());
        return "Product/productsList";
    }
}
