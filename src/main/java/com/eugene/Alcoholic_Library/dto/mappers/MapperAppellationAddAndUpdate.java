package com.eugene.Alcoholic_Library.dto.mappers;

import com.eugene.Alcoholic_Library.dto.AppellationAddAndUpdateDTO;
import com.eugene.Alcoholic_Library.model.modulCountryRegionSubregion.Appellation;

public class MapperAppellationAddAndUpdate {

    public static Appellation toEntity(AppellationAddAndUpdateDTO dto) {
        Appellation entity = new Appellation();
        entity.setId(dto.getId());
        entity.setName(dto.getName());

        return entity;
    }


    public static AppellationAddAndUpdateDTO toDto(Appellation entity) {
        AppellationAddAndUpdateDTO dto = new AppellationAddAndUpdateDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setIdRegion(entity.getRegion().getId());

        return dto;
    }

}
