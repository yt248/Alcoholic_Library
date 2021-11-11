package com.eugene.Alcoholic_Library.dto;

import com.eugene.Alcoholic_Library.model.modulManufacturerBrand.Brand;

import java.util.HashSet;
import java.util.Set;

public class ManufacturerDTO {

    private Long id;

    private String name;

    private Set<BrandDTO> brandDTOS = new HashSet<>();

    public ManufacturerDTO() {
    }

    public ManufacturerDTO(String name) {
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BrandDTO> getBrandDTOS() {
        return brandDTOS;
    }

    public void setBrandDTOS(Set<BrandDTO> brandDTOS) {
        this.brandDTOS = brandDTOS;
    }
}
