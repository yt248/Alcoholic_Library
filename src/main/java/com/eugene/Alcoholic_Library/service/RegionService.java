package com.eugene.Alcoholic_Library.service;

import com.eugene.Alcoholic_Library.model.modulCountryRegionSubregion.Region;

import java.util.List;

public interface RegionService {

    void create(Region region, Long idCountry);

    void update(Long id, Region newRegion, Long idCountry);

    Region getById(Long id);

    void delete(Long id);

    List<Region> getAllRegions();
}
