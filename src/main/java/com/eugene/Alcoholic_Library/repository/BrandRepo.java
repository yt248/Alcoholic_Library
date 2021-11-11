package com.eugene.Alcoholic_Library.repository;

import com.eugene.Alcoholic_Library.model.modulManufacturerBrand.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepo extends JpaRepository<Brand,Long> {
}
