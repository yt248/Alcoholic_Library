package com.eugene.Alcoholic_Library.service;

import com.eugene.Alcoholic_Library.model.modulManufacturerBrand.Manufacturer;

import java.util.List;

public interface ManufacturerService {

    void create (Manufacturer manufacturer);

    void update(Long id, Manufacturer newManufacturer);

    Manufacturer getById(Long id);

    void delete (Long id);

    List<Manufacturer> getAllManufacturers();
}
