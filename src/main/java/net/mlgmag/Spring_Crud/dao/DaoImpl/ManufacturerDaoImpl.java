package net.mlgmag.Spring_Crud.dao.DaoImpl;

import net.mlgmag.Spring_Crud.dao.ManufacturerDao;
import net.mlgmag.Spring_Crud.model.Manufacturer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public class ManufacturerDaoImpl implements ManufacturerDao {

    private SessionFactory sessionFactory;
    private Transaction transaction;

    @Autowired
    public ManufacturerDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Manufacturer manufacturer) {
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        session.save(manufacturer);

        transaction.commit();
        session.close();
    }

    @Override
    public Manufacturer getById(UUID uuid) {
        Session session = sessionFactory.openSession();

        Manufacturer manufacturer = session.get(Manufacturer.class, uuid);

        session.close();
        return manufacturer;
    }

    @Override
    public void update(Manufacturer manufacturer) {
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        session.update(manufacturer);

        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Manufacturer manufacturer) {
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        session.delete(manufacturer);

        transaction.commit();
        session.close();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Manufacturer> getAll() {
        Session session = sessionFactory.openSession();

        List<Manufacturer> manufacturersList = session.createQuery("FROM Manufacturer ").list();

        session.close();
        return manufacturersList;
    }
}
