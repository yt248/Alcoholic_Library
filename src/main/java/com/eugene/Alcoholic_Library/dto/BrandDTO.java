package com.eugene.Alcoholic_Library.dto;

public class BrandDTO {

    private Long id;

    private String name;

    private ManufacturerDTO manufacturerDTO;

    public BrandDTO() {
    }

    public BrandDTO(String name, ManufacturerDTO manufacturerDTO) {
        this.name = name;
        this.manufacturerDTO = manufacturerDTO;
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

    public ManufacturerDTO getManufacturerDTO() {
        return manufacturerDTO;
    }

    public void setManufacturerDTO(ManufacturerDTO manufacturerDTO) {
        this.manufacturerDTO = manufacturerDTO;
    }
}
