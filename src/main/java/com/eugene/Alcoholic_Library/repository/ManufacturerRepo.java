package com.eugene.Alcoholic_Library.repository;

import com.eugene.Alcoholic_Library.model.modulManufacturerBrand.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepo extends JpaRepository<Manufacturer, Long> {
}
