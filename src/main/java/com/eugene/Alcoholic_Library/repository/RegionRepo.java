package com.eugene.Alcoholic_Library.repository;

import com.eugene.Alcoholic_Library.model.modulCountryRegionSubregion.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepo extends JpaRepository<Region, Long> {
}
