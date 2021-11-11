package com.eugene.Alcoholic_Library.service;

import com.eugene.Alcoholic_Library.model.modulManufacturerBrand.Brand;
import com.eugene.Alcoholic_Library.model.modulManufacturerBrand.Manufacturer;
import com.eugene.Alcoholic_Library.repository.BrandRepo;
import com.eugene.Alcoholic_Library.repository.ManufacturerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepo brandRepo;
    private final ManufacturerService manufacturerService;


    @Autowired
    public BrandServiceImpl(BrandRepo brandRepo, ManufacturerService manufacturerService) {
        this.brandRepo = brandRepo;
        this.manufacturerService = manufacturerService;
    }


    @Override
    @Transactional
    public void create(Brand brand, Long idManufacturer) {
        Manufacturer manufacturer = manufacturerService.getById(idManufacturer);
        brand.setManufacturer(manufacturer);
        manufacturer.getBrands().add(brand);

        brandRepo.save(brand);
    }

    @Override
    @Transactional
    public void update(Long id, Brand newBrand) {
        Brand updateBrand = getById(id);
        updateBrand.setName(newBrand.getName());
//        updateBrand.setManufacturer(newBrand.getManufacturer());

        brandRepo.save(updateBrand);

    }

    @Override
    public Brand getById(Long id) {
        return brandRepo.getById(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Brand brand = getById(id);
        brand.getManufacturer().getBrands().remove(brand);
        brand.setManufacturer(null);

        brandRepo.delete(brand);
    }

    @Override
    public List<Brand> getAllBrands() {
        return brandRepo.findAll();
    }
}
