package com.eugene.Alcoholic_Library.dto.mappers;

import com.eugene.Alcoholic_Library.dto.AppellationDTO;
import com.eugene.Alcoholic_Library.model.modulCountryRegionSubregion.Appellation;

public class MapperAppellation {

    public static Appellation toEntity(AppellationDTO dto) {
        Appellation entity = new Appellation();
        entity.setId(dto.getId());
        entity.setName(dto.getName());

        return entity;
    }


    public static AppellationDTO toDto(Appellation entity) {
        AppellationDTO dto = new AppellationDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());

        return dto;
    }

}
