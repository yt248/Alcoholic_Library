package com.eugene.Alcoholic_Library.model.modulCountryRegionSubregion;

import com.eugene.Alcoholic_Library.model.categories.Brandy;
import com.eugene.Alcoholic_Library.model.categories.Cognac;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "regions")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    private Set<Subregion> subregions = new HashSet<>();

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    private Set<Brandy> brandies = new HashSet<>();

    @OneToMany(mappedBy = "region",cascade = CascadeType.ALL)
    private Set<Cognac> cognacs = new HashSet<>();


    public Region() {
    }

    public Region(String name) {
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Set<Subregion> getSubregions() {
        return subregions;
    }

    public void setSubregions(Set<Subregion> subregions) {
        this.subregions = subregions;
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
