package net.mlgmag.Spring_Crud.controller;

import net.mlgmag.Spring_Crud.definition.ManufacturerService;
import net.mlgmag.Spring_Crud.definition.ProductService;
import net.mlgmag.Spring_Crud.model.Manufacturer;
import net.mlgmag.Spring_Crud.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        model.addAttribute("manufacturers", manufacturerService.findAll());
        model.addAttribute(new Product());
        model.addAttribute("title", "Add Product");
        return "Product/productAdd";
    }

    @PostMapping("/add")
    public String productAdd(@ModelAttribute("product") Product product, Model model) {

        if (productService.validate(product, model)) {
            model.addAttribute("manufacturers", manufacturerService.findAll());
            model.addAttribute("title", "Add Product");
            return "Product/productAdd";
        }
        productService.save(product);
        return "redirect:/product/list";
    }

    @GetMapping("/update")
    public String productUpdatePage(@RequestParam(value = "id") UUID id, Model model) {
        model.addAttribute("manufacturers", manufacturerService.findAll());
        model.addAttribute("product", productService.findById(id).orElse(null));
        model.addAttribute("title", "Edit Product");
        return "Product/productUpdate";
    }

    @PostMapping("/update")
    public String productUpdate(@ModelAttribute("product") Product product, Model model) {

        if (!product.getName().equals(productService.findById(product.getId()).map(Product::getName).orElse(null))) {
            if (productService.findByName(product.getName()) != null) {
                model.addAttribute("manufacturers", manufacturerService.findAll());
                model.addAttribute("DuplicateProductName", "Product name already exist");
                model.addAttribute("title", "Edit Product");
                return "Product/productUpdate";
            }
        }

        product.getManufacturer().setName(manufacturerService
                .findById(product.getManufacturer().getId()).map(Manufacturer::getName).orElse(null));
        productService.update(product);
        return "redirect:/product/list";
    }

    @GetMapping("/delete")
    public String productDelete(@RequestParam(value = "id") UUID id) {
        productService.findById(id).ifPresent(productService::delete);
        return "redirect:/product/list";
    }

    @GetMapping("/")
    public String productView(@RequestParam(value = "id") UUID id, Model model) {
        model.addAttribute("product", productService.findById(id).orElse(null));
        model.addAttribute("title", "Product");
        return "Product/productView";
    }

    @GetMapping("/list")
    public String productsList(Model model) {
        model.addAttribute("products", productService.findAll());
        model.addAttribute("title", "Products");
        return "Product/productsList";
    }

}
