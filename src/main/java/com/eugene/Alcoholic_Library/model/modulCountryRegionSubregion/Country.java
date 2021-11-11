package com.eugene.Alcoholic_Library.model.modulCountryRegionSubregion;

import com.eugene.Alcoholic_Library.model.categories.Brandy;
import com.eugene.Alcoholic_Library.model.categories.Cognac;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private Set<Region> regions = new HashSet<>();

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private Set<Brandy> brandies = new HashSet<>();

    @OneToMany(mappedBy = "country",cascade = CascadeType.ALL)
    private Set<Cognac> cognacs = new HashSet<>();

    public Country() {
    }

    public Country(String name) {
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

    public Set<Region> getRegions() {
        return regions;
    }

    public void setRegions(Set<Region> regions) {
        this.regions = regions;
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
