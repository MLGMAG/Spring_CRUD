package net.mlgmag.Spring_Crud.dao.DaoImpl;

import net.mlgmag.Spring_Crud.dao.ProductDao;
import net.mlgmag.Spring_Crud.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public class ProductDaoImpl implements ProductDao {

    private SessionFactory sessionFactory;
    private Transaction transaction;

    @Autowired
    public ProductDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Product product) {
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        session.save(product);

        transaction.commit();
         session.close();
    }

    @Override
    public Product getById(UUID uuid) {
        Session session = sessionFactory.openSession();

        Product product = session.get(Product.class, uuid);

        session.close();
        return product;
    }

    @Override
    public void update(Product product) {
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        session.update(product);

        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Product product) {
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        session.delete(product);

        transaction.commit();
        session.close();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Product> getAll() {
        Session session = sessionFactory.openSession();

        List<Product> productsList = session.createQuery("FROM Product").list();

        session.close();
        return productsList;
    }
}
