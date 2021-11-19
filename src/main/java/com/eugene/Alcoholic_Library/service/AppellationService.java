package com.eugene.Alcoholic_Library.service;

import com.eugene.Alcoholic_Library.model.modulCountryRegionSubregion.Appellation;

import java.util.List;

public interface AppellationService {

    void create(Appellation appellation, Long idRegion);

    void update(Long id, Appellation newAppellation, Long idRegion);

    Appellation getById(Long id);

    void delete(Long id);

    List<Appellation> getAllAppellations();

}
