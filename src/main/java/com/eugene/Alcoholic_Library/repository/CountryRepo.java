package com.eugene.Alcoholic_Library.repository;

import com.eugene.Alcoholic_Library.model.modulCountryRegionSubregion.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepo extends JpaRepository<Country, Long> {
}
