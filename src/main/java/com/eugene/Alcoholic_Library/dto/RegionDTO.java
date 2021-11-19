package com.eugene.Alcoholic_Library.dto;

import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

public class RegionDTO {

    private long id;

    @NotEmpty(message = "Name should not be empty")
    private String name;

    private Set<SubregionDTO> subregionDTOS = new HashSet<>();

    private Set<AppellationDTO> appellationDTOS = new HashSet<>();

    public RegionDTO() {
    }

    public RegionDTO(String name) {
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

    public Set<SubregionDTO> getSubregionDTOS() {
        return subregionDTOS;
    }

    public void setSubregionDTOS(Set<SubregionDTO> subregionDTOS) {
        this.subregionDTOS = subregionDTOS;
    }

    public Set<AppellationDTO> getAppellationDTOS() {
        return appellationDTOS;
    }

    public void setAppellationDTOS(Set<AppellationDTO> appellationDTOS) {
        this.appellationDTOS = appellationDTOS;
    }
}
