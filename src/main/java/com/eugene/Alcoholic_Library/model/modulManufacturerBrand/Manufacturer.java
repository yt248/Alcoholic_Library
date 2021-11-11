package com.eugene.Alcoholic_Library.model.modulManufacturerBrand;

import com.eugene.Alcoholic_Library.model.categories.Brandy;
import com.eugene.Alcoholic_Library.model.categories.Cognac;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "manufacturers")
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL)
    private Set<Brand> brands = new HashSet<>();

    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL)
    private Set<Brandy> brandies = new HashSet<>();

    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL)
    private Set<Cognac> cognacs = new HashSet<>();

    public Manufacturer() {
    }

    public Manufacturer(String name) {
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

    public Set<Brand> getBrands() {
        return brands;
    }

    public void setBrands(Set<Brand> brands) {
        this.brands = brands;
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
