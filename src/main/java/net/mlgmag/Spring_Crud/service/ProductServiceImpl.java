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
import java.util.Optional;
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
    public void update(Product product) {
        log.info("IN ProductServiceImpl update {}", product);
        productRepository.saveAndFlush(product);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMIN')")
    public void delete(Product product) {
        log.info("IN ProductServiceImpl delete {}", product);
        productRepository.delete(product);
    }

    @Override
    public Optional<Product> findById(UUID uuid) {
        log.info("IN ProductServiceImpl findById {} ", uuid);
        return productRepository.findById(uuid);
    }

    @Override
    public List<Product> findAll() {
        log.info("IN ProductServiceImpl findAll {}");
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findByName(String name) {
        log.info("IN ProductServiceImpl findByName {} ", name);
        return productRepository.findByName(name);
    }

    @Override
    public Boolean productNameValidation(String name, Model model) {

        if (findByName(name).isPresent()) {
            String error = "Product name already exist";
            log.info("IN ProductServiceImpl productNameValidation {} ->", "Validation failed: " + error);
            model.addAttribute("DuplicateProductName", error);
            return true;
        }

        return false;
    }

    @Override
    public Boolean saveValidation(Product product, Model model) {
        return productNameValidation(product.getName(), model);
    }

    @Override
    public Boolean updateValidation(Product product, Model model) {

        if (!product.getName().equals(findById(product.getId()).map(Product::getName).orElse(null))) {
            return productNameValidation(product.getName(), model);
        }

        return false;
    }

}
