package com.eugene.Alcoholic_Library.service;

import com.eugene.Alcoholic_Library.model.modulManufacturerBrand.Brand;

import java.util.List;

public interface BrandService {

    void create (Brand brand, Long idManufacturer);

    void update(Long id, Brand newBrand);

    Brand getById(Long id);

    void delete (Long id);

    List<Brand> getAllBrands();

}
