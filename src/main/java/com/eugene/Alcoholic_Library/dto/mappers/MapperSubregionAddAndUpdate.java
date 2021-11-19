package com.eugene.Alcoholic_Library.dto.mappers;

import com.eugene.Alcoholic_Library.dto.SubregionAddAndUpdateDTO;
import com.eugene.Alcoholic_Library.model.modulCountryRegionSubregion.Subregion;

public class MapperSubregionAddAndUpdate {


    public static Subregion toEntity(SubregionAddAndUpdateDTO dto){
        Subregion entity = new Subregion();
        entity.setId(dto.getId());
        entity.setName(dto.getName());

        return entity;
    }

    public static SubregionAddAndUpdateDTO toDto(Subregion entity) {
        SubregionAddAndUpdateDTO dto = new SubregionAddAndUpdateDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setIdRegion(entity.getRegion().getId());
        return dto;
    }
}
