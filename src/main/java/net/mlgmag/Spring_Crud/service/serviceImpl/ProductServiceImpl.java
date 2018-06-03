package net.mlgmag.Spring_Crud.service.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import net.mlgmag.Spring_Crud.model.Product;
import net.mlgmag.Spring_Crud.repository.ProductRepository;
import net.mlgmag.Spring_Crud.service.genericService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    public void save(Product product) {
        log.info("IN ProductServiceImpl save {}", product);
        productRepository.save(product);
    }

    @Override
    public void update(Product product) {
        log.info("IN ProductServiceImpl update {}", product);
        productRepository.saveAndFlush(product);
    }

    @Override
    public void delete(Product product) {
        log.info("IN ProductServiceImpl delete {}", product);
        productRepository.delete(product);
    }

    @Override
    @Transactional
    public Product findById(UUID uuid) {
        System.out.println(productRepository.getOne(uuid));
        log.info("IN ProductServiceImpl findById {} ", uuid);
        return productRepository.getOne(uuid);
    }

    @Override
    public List<Product> findAll() {
        log.info("IN ProductServiceImpl findAll {}");
        return productRepository.findAll();
    }

    @Override
    public Product findByName(String name) {
        log.info("IN ProductServiceImpl findByName {} ", name);
        return productRepository.findByName(name);
    }

    @Override
    public Boolean validate(Product product, Model model) {
        boolean Error = false;
        if (findByName(product.getName()) != null) {
            Error = true;
            model.addAttribute("DuplicateProductName", "Product name already exist");
        }
        return Error;
    }

}
