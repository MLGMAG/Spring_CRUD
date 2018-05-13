package net.mlgmag.Spring_Crud.controller;

import net.mlgmag.Spring_Crud.model.Product;
import net.mlgmag.Spring_Crud.service.genericService.ManufacturerService;
import net.mlgmag.Spring_Crud.service.genericService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('ADMIN')")
    public String productAddPage(Model model) {
        model.addAttribute("manufacturers", manufacturerService.findAll());
        model.addAttribute("product", new Product());
        model.addAttribute("title", "Add Product");
        return "Product/productAdd";
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String productAdd(@ModelAttribute("product") Product product, Model model) {

        if (productService.validate(product, model)) {
            model.addAttribute("manufacturers", manufacturerService.findAll());
            model.addAttribute("title", "Add Product");
            return "Product/productAdd";
        }
        productService.save(product);
        return "redirect:/product/list";
    }

    @GetMapping("/update/")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String productUpdatePage(@RequestParam(value = "id") UUID id, Model model) {
        model.addAttribute("manufacturers", manufacturerService.findAll());
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("title", "Edit Product");
        return "Product/productUpdate";
    }

    @PostMapping("/update/")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String productUpdate(@ModelAttribute("product") Product product, Model model) {

        if (!product.getName().equals(productService.findById(product.getId()).getName())) {
            if (productService.findByName(product.getName()) != null) {
                model.addAttribute("manufacturers", manufacturerService.findAll());
                model.addAttribute("DuplicateProductName", "Product name already exist");
                model.addAttribute("title", "Edit Product");
                return "Product/productUpdate";
            }
        }

        product.getManufacturer().setName(manufacturerService.findById(product.getManufacturer().getId()).getName());
        productService.update(product);
        return "redirect:/product/list";
    }

    @GetMapping("/delete/")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String productDelete(@RequestParam(value = "id") UUID id) {
        productService.delete(productService.findById(id));
        return "redirect:/product/list";
    }

    @GetMapping("/")
    public String productView(@RequestParam(value = "id") UUID id, Model model) {
        model.addAttribute("product", productService.findById(id));
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
