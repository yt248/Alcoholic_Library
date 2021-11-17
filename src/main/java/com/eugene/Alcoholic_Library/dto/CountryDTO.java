package com.eugene.Alcoholic_Library.dto;

import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

public class CountryDTO {

    private Long id;

    @NotEmpty(message = "Name should not be empty")
    private String name;

    private Set<RegionDTO> regionDTOS = new HashSet<>();

    public CountryDTO() {
    }

    public CountryDTO(String name) {
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

    public Set<RegionDTO> getRegionDTOS() {
        return regionDTOS;
    }

    public void setRegionDTOS(Set<RegionDTO> regionDTOS) {
        this.regionDTOS = regionDTOS;
    }

    @Override
    public String toString() {
        return "CountryDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
