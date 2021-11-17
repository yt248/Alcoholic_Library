package com.eugene.Alcoholic_Library.dto;

import javax.validation.constraints.NotEmpty;

public class RegionAndCountryIdDTO {

    private long id;

    @NotEmpty(message = "Name should not be empty")
    private String name;

    private Long idCountry;

    public RegionAndCountryIdDTO() {
    }

    public RegionAndCountryIdDTO(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Long idCountry) {
        this.idCountry = idCountry;
    }

    @Override
    public String toString() {
        return "RegionAddDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idCountry=" + idCountry +
                '}';
    }
}
