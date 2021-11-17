package com.eugene.Alcoholic_Library.dto;

import com.eugene.Alcoholic_Library.model.modulCountryRegionSubregion.Appellation;
import com.eugene.Alcoholic_Library.model.modulCountryRegionSubregion.Subregion;

import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

public class RegionDTO {

    private long id;

    @NotEmpty(message = "Name should not be empty")
    private String name;

//    private CountryDTO countryDTO;

//    private Set<Subregion> subregions = new HashSet<>();

//    private Set<Appellation> appellations = new HashSet<>();

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

//    public CountryDTO getCountryDTO() {
//        return countryDTO;
//    }
//
//    public void setCountryDTO(CountryDTO countryDTO) {
//        this.countryDTO = countryDTO;
//    }
//
//    @Override
//    public String toString() {
//        return "RegionDTO{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", countryDTO=" + countryDTO +
//                '}';
//    }
}
