package com.eugene.Alcoholic_Library.dto.mappers;

import com.eugene.Alcoholic_Library.dto.RegionAddAndUpdateDTO;
import com.eugene.Alcoholic_Library.model.modulCountryRegionSubregion.Region;

public class MapperRegionAddAndUpdate {

    public static RegionAddAndUpdateDTO toDto(Region entity) {
        RegionAddAndUpdateDTO dto = new RegionAddAndUpdateDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());

        return dto;
    }

    public static Region toEntity(RegionAddAndUpdateDTO dto) {
        Region entity = new Region();
        entity.setId(dto.getId());
        entity.setName(dto.getName());

        return entity;
    }


}
