package com.eugene.Alcoholic_Library.service;

import com.eugene.Alcoholic_Library.model.modulCountryRegionSubregion.Subregion;

import java.util.List;

public interface SubregionService {

    void create(Subregion subregion, Long idRegion);

    Subregion getById(Long id);

    void update(Long id, Subregion newSubregion, Long idRegion);

    void delete(Long id);

    List<Subregion> getAllSubregions();
}
