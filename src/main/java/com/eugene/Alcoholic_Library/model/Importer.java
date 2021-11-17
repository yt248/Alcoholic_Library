package com.eugene.Alcoholic_Library.model;

public class Importer {

    private Long id;

    private String name;




    public Importer() {
    }

    public Importer(String name) {
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
