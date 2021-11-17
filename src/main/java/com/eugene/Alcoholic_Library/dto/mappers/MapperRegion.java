package com.eugene.Alcoholic_Library.dto.mappers;

import com.eugene.Alcoholic_Library.dto.RegionDTO;
import com.eugene.Alcoholic_Library.model.modulCountryRegionSubregion.Region;

public class MapperRegion {

    public static RegionDTO toDto(Region entity) {
        RegionDTO dto = new RegionDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());

//        dto.setCountryDTO(MapperCountry.toDto(entity.getCountry()));

        return dto;
    }


    public static Region toEntity(RegionDTO dto) {
        Region entity = new Region();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
//        entity.setCountry(MapperCountry.toEntity(dto.getCountryDTO()));

        return entity;
    }


}
