package com.eugene.Alcoholic_Library.dto.mappers;

import com.eugene.Alcoholic_Library.dto.RegionAndCountryIdDTO;
import com.eugene.Alcoholic_Library.model.modulCountryRegionSubregion.Region;

public class MapperRegionAndCountryId {

    public static RegionAndCountryIdDTO toDto(Region entity) {
        RegionAndCountryIdDTO dto = new RegionAndCountryIdDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setIdCountry(entity.getCountry().getId());

        return dto;
    }

    public static Region toEntity(RegionAndCountryIdDTO dto) {
        Region entity = new Region();
        entity.setId(dto.getId());
        entity.setName(dto.getName());

        return entity;
    }


}
