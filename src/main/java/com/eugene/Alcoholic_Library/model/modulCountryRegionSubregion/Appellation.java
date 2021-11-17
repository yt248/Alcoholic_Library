package com.eugene.Alcoholic_Library.model.modulCountryRegionSubregion;

import com.eugene.Alcoholic_Library.model.categories.Cognac;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "appellations")
public class Appellation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Region region;

    @OneToMany(mappedBy = "appellation", cascade = CascadeType.ALL)
    private Set<Cognac> cognacs = new HashSet<>();

    public Appellation() {
    }

    public Appellation(String name) {
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

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Set<Cognac> getCognacs() {
        return cognacs;
    }

    public void setCognacs(Set<Cognac> cognacs) {
        this.cognacs = cognacs;
    }
}
