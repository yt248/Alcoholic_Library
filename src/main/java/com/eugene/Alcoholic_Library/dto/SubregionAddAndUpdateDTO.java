package com.eugene.Alcoholic_Library.dto;

public class SubregionAddAndUpdateDTO {

    private Long id;

    private String name;

    private Long idRegion;


    public SubregionAddAndUpdateDTO() {
    }


    public SubregionAddAndUpdateDTO(String name, Long idRegion) {
        this.name = name;
        this.idRegion = idRegion;
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

    public Long getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Long idRegion) {
        this.idRegion = idRegion;
    }
}
