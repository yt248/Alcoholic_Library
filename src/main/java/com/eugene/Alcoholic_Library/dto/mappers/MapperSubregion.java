package com.eugene.Alcoholic_Library.dto.mappers;

import com.eugene.Alcoholic_Library.dto.SubregionDTO;
import com.eugene.Alcoholic_Library.model.modulCountryRegionSubregion.Subregion;

public class MapperSubregion {

    public static Subregion toEntity(SubregionDTO dto) {
        Subregion entity = new Subregion();
        entity.setId(dto.getId());
        entity.setName(dto.getName());

        return entity;
    }

    public static SubregionDTO toDto(Subregion entity) {
        SubregionDTO dto = new SubregionDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());

        return dto;
    }

}
