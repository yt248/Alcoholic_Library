package com.eugene.Alcoholic_Library.model.modulManufacturerBrand;

import com.eugene.Alcoholic_Library.model.categories.Brandy;
import com.eugene.Alcoholic_Library.model.categories.Cognac;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "brands")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Manufacturer manufacturer;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private Set<Brandy> brandies = new HashSet<>();

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private Set<Cognac> cognacs = new HashSet<>();

    public Brand() {
    }

    public Brand(String name, String description) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Set<Brandy> getBrandies() {
        return brandies;
    }

    public void setBrandies(Set<Brandy> brandies) {
        this.brandies = brandies;
    }

    public Set<Cognac> getCognacs() {
        return cognacs;
    }

    public void setCognacs(Set<Cognac> cognacs) {
        this.cognacs = cognacs;
    }
}
