package com.eugene.Alcoholic_Library.dto;

import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

public class ManufacturerDTO {

    private Long id;

    @NotEmpty(message = "Name should not be empty")
    private String name;

    @NotEmpty(message = "Description should not be empty")
    private String description;

    private Set<BrandDTO> brandDTOS = new HashSet<>();

    public ManufacturerDTO() {
    }

    public ManufacturerDTO(String name, String description) {
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
