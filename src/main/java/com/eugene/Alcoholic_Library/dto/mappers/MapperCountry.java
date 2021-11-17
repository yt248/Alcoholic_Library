package com.eugene.Alcoholic_Library.dto.mappers;

import com.eugene.Alcoholic_Library.dto.CountryDTO;
import com.eugene.Alcoholic_Library.model.modulCountryRegionSubregion.Country;

public class MapperCountry {

    public static CountryDTO toDto(Country entity) {
        CountryDTO dto = new CountryDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        entity.getRegions().forEach(region -> dto.getRegionDTOS().add(MapperRegion.toDto(region)));

        return dto;
    }

    public static Country toEntity(CountryDTO dto) {
        Country entity = new Country();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        dto.getRegionDTOS().forEach(regionDTO -> entity.getRegions().add(MapperRegion.toEntity(regionDTO)));

        return entity;
    }

}
