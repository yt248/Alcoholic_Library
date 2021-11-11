package com.eugene.Alcoholic_Library.dto.mappers;

import com.eugene.Alcoholic_Library.dto.BrandDTO;
import com.eugene.Alcoholic_Library.model.modulManufacturerBrand.Brand;

public class MapperBrand {

    public static BrandDTO toDto(Brand entity) {
        BrandDTO dto = new BrandDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
//        dto.setManufacturerDTO(MapperManufacturer.toDto(entity.getManufacturer()));

        return dto;
    }

    public static Brand toEntity(BrandDTO dto) {
        Brand entity = new Brand();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
//        entity.setManufacturer(MapperManufacturer.toEntity(dto.getManufacturerDTO()));

        return entity;
    }
}
