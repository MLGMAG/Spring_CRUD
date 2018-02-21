package net.mlgmag.Spring_Crud.service.ServiceImpl;

import net.mlgmag.Spring_Crud.dao.ProductDao;
import net.mlgmag.Spring_Crud.model.Product;
import net.mlgmag.Spring_Crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public Product getById(UUID uuid) {
        return productDao.getById(uuid);
    }

    @Override
    public void update(Product product) {
        productDao.update(product);
    }

    @Override
    public void delete(Product product) {
        productDao.delete(product);
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }
}
