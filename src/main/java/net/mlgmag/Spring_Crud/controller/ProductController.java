package net.mlgmag.Spring_Crud.controller;

import net.mlgmag.Spring_Crud.model.Product;
import net.mlgmag.Spring_Crud.service.service.ManufacturerService;
import net.mlgmag.Spring_Crud.service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        model.addAttribute("product", new Product());
        return "Product/productAdd";
    }

    @PostMapping("/add")
    public String productAdd(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            productService.validate(product, model);
            model.addAttribute("manufacturers", manufacturerService.getAll());
            return "Product/productAdd";
        }

        if (!bindingResult.hasErrors()) {
            if (productService.validate(product, model)) {
                model.addAttribute("manufacturers", manufacturerService.getAll());
                return "Product/productAdd";
            }
        }

        product.getManufacturer().setName(manufacturerService.getById(product.getManufacturer().getId()).getName());
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
    public String productUpdate(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("manufacturers", manufacturerService.getAll());
            return "Product/productUpdate";
        }

        if (!bindingResult.hasErrors()) {
            if (!product.getName().equals(productService.getById(product.getId()).getName())) {
                if (productService.findByName(product.getName()) != null) {
                    model.addAttribute("manufacturers", manufacturerService.getAll());
                    model.addAttribute("DuplicateProductName", "Product name already exist");
                    return "Product/productUpdate";
                }
            }
        }

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
