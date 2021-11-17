package com.eugene.Alcoholic_Library.service;

import com.eugene.Alcoholic_Library.model.modulCountryRegionSubregion.Country;
import com.eugene.Alcoholic_Library.model.modulCountryRegionSubregion.Region;
import com.eugene.Alcoholic_Library.repository.RegionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {

    private final RegionRepo regionRepo;
    private final CountryService countryService;

    @Autowired
    public RegionServiceImpl(RegionRepo regionRepo, CountryService countryService) {
        this.regionRepo = regionRepo;
        this.countryService = countryService;
    }


    @Override
    @Transactional
    public void create(Region region, Long idCountry) {
        Country country = countryService.getById(idCountry);
        region.setCountry(country);
        country.getRegions().add(region);

        regionRepo.save(region);
    }

    @Override
    @Transactional
    public void update(Long id, Region newRegion, Long idCountry) {
        Country country = countryService.getById(idCountry);
        Region updateRegion = getById(id);
        updateRegion.setName(newRegion.getName());

        updateRegion.getCountry().getRegions().remove(getById(id));
        updateRegion.setCountry(country);
        country.getRegions().add(updateRegion);

        regionRepo.save(updateRegion);

    }

    @Override
    public Region getById(Long id) {
        return regionRepo.getById(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        regionRepo.delete(getById(id));
    }

    @Override
    public List<Region> getAllRegions() {
        return regionRepo.findAll();
    }
}
