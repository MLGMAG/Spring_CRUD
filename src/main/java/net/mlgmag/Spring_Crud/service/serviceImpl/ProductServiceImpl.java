package net.mlgmag.Spring_Crud.service.serviceImpl;

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
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void update(Product product) {
        productRepository.saveAndFlush(product);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    @Transactional
    public Product getById(UUID uuid) {
        System.out.println(productRepository.getOne(uuid));
        return productRepository.getOne(uuid);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findByName(String name) {
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
