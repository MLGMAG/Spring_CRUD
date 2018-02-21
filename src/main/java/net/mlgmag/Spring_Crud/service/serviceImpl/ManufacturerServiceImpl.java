package net.mlgmag.Spring_Crud.service.serviceImpl;

import net.mlgmag.Spring_Crud.model.Manufacturer;
import net.mlgmag.Spring_Crud.repository.ManufacturerRepository;
import net.mlgmag.Spring_Crud.service.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    @Autowired
    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    @Transactional
    public void save(Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
    }

    @Override
    @Transactional
    public void update(Manufacturer manufacturer) {
        manufacturerRepository.saveAndFlush(manufacturer);
    }

    @Override
    @Transactional
    public void delete(Manufacturer manufacturer) {
        manufacturerRepository.delete(manufacturer);
    }

    @Override
    @Transactional
    public Manufacturer getById(UUID uuid) {
        System.out.println(manufacturerRepository.getOne(uuid));
        return manufacturerRepository.getOne(uuid);
    }

    @Override
    public List<Manufacturer> getAll() {
        return manufacturerRepository.findAll();
    }
}
