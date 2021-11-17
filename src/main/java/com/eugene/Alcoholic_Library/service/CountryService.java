package com.eugene.Alcoholic_Library.service;

import com.eugene.Alcoholic_Library.model.modulCountryRegionSubregion.Country;

import java.util.List;

public interface CountryService {

    List<Country> getAllCountries();

    void create (Country country);

    void update (Long id, Country newCountry);

    Country getById(Long id);

    void delete (Long id);
}
