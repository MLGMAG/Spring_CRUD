package net.mlgmag.Spring_Crud.controller;

import net.mlgmag.Spring_Crud.model.Product;
import net.mlgmag.Spring_Crud.service.genericService.ManufacturerService;
import net.mlgmag.Spring_Crud.service.genericService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("product", new Product());
        model.addAttribute("title", "Add Product");
        return "Product/productAdd";
    }

    @PostMapping("/add")
    public String productAdd(@ModelAttribute("product") Product product, Model model) {

        if (productService.validate(product, model)) {
            model.addAttribute("manufacturers", manufacturerService.getAll());
            model.addAttribute("title", "Add Product");
            return "Product/productAdd";
        }

        product.getManufacturer().setName(manufacturerService.getById(product.getManufacturer().getId()).getName());
        productService.save(product);
        return "redirect:/product/list";
    }

    @GetMapping("/update/")
    public String productUpdatePage(@RequestParam(value = "id") String id, Model model) {
        model.addAttribute("manufacturers", manufacturerService.getAll());
        model.addAttribute("product", productService.getById(id));
        model.addAttribute("title", "Edit Product");
        return "Product/productUpdate";
    }

    @PostMapping("/update/")
    public String productUpdate(@ModelAttribute("product") Product product, Model model) {

        if (!product.getName().equals(productService.getById(product.getId()).getName())) {
            if (productService.findByName(product.getName()) != null) {
                model.addAttribute("manufacturers", manufacturerService.getAll());
                model.addAttribute("DuplicateProductName", "Product name already exist");
                model.addAttribute("title", "Edit Product");
                return "Product/productUpdate";
            }
        }

        product.getManufacturer().setName(manufacturerService.getById(product.getManufacturer().getId()).getName());
        productService.update(product);
        return "redirect:/product/list";
    }

    @GetMapping("/delete/")
    public String productDelete(@RequestParam(value = "id") String id) {
        productService.delete(productService.getById(id));
        return "redirect:/product/list";
    }

    @GetMapping("/")
    public String productView(@RequestParam(value = "id") String id, Model model) {
        model.addAttribute("product", productService.getById(id));
        model.addAttribute("title", "Product");
        return "Product/productView";
    }

    @GetMapping("/list")
    public String productsList(Model model) {
        model.addAttribute("products", productService.getAll());
        model.addAttribute("title", "Products");
        return "Product/productsList";
    }

}
