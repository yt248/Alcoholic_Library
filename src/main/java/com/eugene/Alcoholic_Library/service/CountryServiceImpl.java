package com.eugene.Alcoholic_Library.service;

import com.eugene.Alcoholic_Library.model.modulCountryRegionSubregion.Country;
import com.eugene.Alcoholic_Library.repository.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService{

    private final CountryRepo countryRepo;

    @Autowired
    public CountryServiceImpl(CountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }


    @Override
    public List<Country> getAllCountries() {
        return countryRepo.findAll();
    }

    @Override
    public void create(Country country) {
        countryRepo.save(country);
    }

    @Override
    @Transactional
    public void update(Long id, Country newCountry) {
        Country updateCountry = getById(id);
        updateCountry.setName(newCountry.getName());

        countryRepo.save(updateCountry);
    }

    @Override
    public Country getById(Long id) {
        return countryRepo.getById(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        countryRepo.delete(getById(id));
    }
}
