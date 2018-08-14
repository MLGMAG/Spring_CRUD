package net.mlgmag.Spring_Crud.service;

import lombok.extern.slf4j.Slf4j;
import net.mlgmag.Spring_Crud.definition.ProductService;
import net.mlgmag.Spring_Crud.model.Product;
import net.mlgmag.Spring_Crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @PreAuthorize("hasAuthority('ADMIN')")
    public void save(Product product) {
        log.info("IN ProductServiceImpl save {}", product);
        productRepository.save(product);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMIN')")
    public void delete(Product product) {
        log.info("IN ProductServiceImpl delete {}", product);
        productRepository.delete(product);
    }

    @Override
    public Product findById(UUID id) {
        log.info("IN ProductServiceImpl findById {} ", id);
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Product with id \"" + id + "\" not found"));
    }

    @Override
    public List<Product> findAll() {
        log.info("IN ProductServiceImpl findAll {}");
        return productRepository.findAll();
    }

    @Override
    public Product findByName(String name) {
        log.info("IN ProductServiceImpl findByName {} ", name);
        return productRepository.findByName(name)
                .orElseThrow(() -> new IllegalStateException("Product with name \"" + name + "\" not found"));
    }

    @Override
    public Boolean productNameValidation(String name, Model model) {
        try {
            findByName(name);
            String error = "Product name already exist";
            log.info("IN ProductServiceImpl productNameValidation {} ->", "Validation failed: " + error);
            model.addAttribute("DuplicateProductName", error);
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    @Override
    public Boolean saveValidation(Product product, Model model) {
        return productNameValidation(product.getName(), model);
    }

    @Override
    public Boolean updateValidation(Product product, Model model) {

        if (!product.getName().equals(findById(product.getId()).getName())) {
            return productNameValidation(product.getName(), model);
        }

        return false;
    }

}
