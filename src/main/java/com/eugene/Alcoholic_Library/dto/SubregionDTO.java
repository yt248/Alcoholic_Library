package com.eugene.Alcoholic_Library.dto;

public class SubregionDTO {

    private Long id;

    private String name;


    public SubregionDTO() {
    }

    public SubregionDTO(String name) {
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
}
