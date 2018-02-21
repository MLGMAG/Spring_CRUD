package net.mlgmag.Spring_Crud.service.ServiceImpl;

import net.mlgmag.Spring_Crud.dao.ManufacturerDao;
import net.mlgmag.Spring_Crud.model.Manufacturer;
import net.mlgmag.Spring_Crud.service.ManufacturerService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private ManufacturerDao manufacturerDao;

    private SessionFactory sessionFactory;

    @Autowired
    public ManufacturerServiceImpl(ManufacturerDao manufacturerDao, SessionFactory sessionFactory) {
        this.manufacturerDao = manufacturerDao;
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Manufacturer manufacturer) {
        manufacturerDao.save(manufacturer);
    }

    @Override
    public Manufacturer getById(UUID uuid) {
        return manufacturerDao.getById(uuid);
    }

    @Override
    public void update(Manufacturer manufacturer) {
        manufacturerDao.update(manufacturer);
    }

    @Override
    public void delete(Manufacturer manufacturer) {
        manufacturerDao.delete(manufacturer);
    }

    @Override
    public List<Manufacturer> getAll() {
        return manufacturerDao.getAll();
    }
}
