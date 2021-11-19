package com.eugene.Alcoholic_Library.dto.mappers;

import com.eugene.Alcoholic_Library.dto.RegionDTO;
import com.eugene.Alcoholic_Library.model.modulCountryRegionSubregion.Region;

public class MapperRegion {

    public static RegionDTO toDto(Region entity) {
        RegionDTO dto = new RegionDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());

        entity.getSubregions().forEach(subregion -> dto.getSubregionDTOS().add(MapperSubregion.toDto(subregion)));
        entity.getAppellations().forEach(appellation -> dto.getAppellationDTOS().add(MapperAppellation.toDto(appellation)));

        return dto;
    }


    public static Region toEntity(RegionDTO dto) {
        Region entity = new Region();
        entity.setId(dto.getId());
        entity.setName(dto.getName());

        dto.getSubregionDTOS().forEach(subregionDTO -> entity.getSubregions().add(MapperSubregion.toEntity(subregionDTO)));
        dto.getAppellationDTOS().forEach(appellationDTO -> entity.getAppellations().add(MapperAppellation.toEntity(appellationDTO)));

        return entity;
    }


}
