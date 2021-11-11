package com.eugene.Alcoholic_Library.service;

import com.eugene.Alcoholic_Library.model.modulManufacturerBrand.Manufacturer;
import com.eugene.Alcoholic_Library.repository.ManufacturerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepo manufacturerRepo;


    @Autowired
    public ManufacturerServiceImpl(ManufacturerRepo manufacturerRepo) {
        this.manufacturerRepo = manufacturerRepo;
    }


    @Override
    public void create(Manufacturer manufacturer) {
        manufacturerRepo.save(manufacturer);
    }

    @Override
    @Transactional
    public void update(Long id, Manufacturer newManufacturer) {
        Manufacturer updateManufacturer = getById(id);
        updateManufacturer.setName(newManufacturer.getName());
        manufacturerRepo.save(updateManufacturer);
    }

    @Override
    public Manufacturer getById(Long id) {
        return manufacturerRepo.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        manufacturerRepo.delete(getById(id));
    }

    @Override
    public List<Manufacturer> getAllManufacturers() {
        return manufacturerRepo.findAll();
    }
}
