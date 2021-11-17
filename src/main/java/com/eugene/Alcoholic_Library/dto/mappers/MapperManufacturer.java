package com.eugene.Alcoholic_Library.dto.mappers;

import com.eugene.Alcoholic_Library.dto.ManufacturerDTO;
import com.eugene.Alcoholic_Library.model.modulManufacturerBrand.Manufacturer;

public class MapperManufacturer {

    public static ManufacturerDTO toDto (Manufacturer entity){
        ManufacturerDTO dto = new ManufacturerDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        entity.getBrands().forEach(brand -> dto.getBrandDTOS().add(MapperBrand.toDto(brand)));

        return dto;
    }

    public static Manufacturer toEntity(ManufacturerDTO dto){
        Manufacturer entity = new Manufacturer();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        dto.getBrandDTOS().forEach(brandDTO -> entity.getBrands().add(MapperBrand.toEntity(brandDTO)));

        return entity;
    }
}
