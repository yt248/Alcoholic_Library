package com.eugene.Alcoholic_Library.model.categories;

import com.eugene.Alcoholic_Library.model.enums.ClassificationBrandy;
import com.eugene.Alcoholic_Library.model.enums.ProductCategory;
import com.eugene.Alcoholic_Library.model.modulCountryRegionSubregion.Country;
import com.eugene.Alcoholic_Library.model.modulCountryRegionSubregion.Region;
import com.eugene.Alcoholic_Library.model.modulManufacturerBrand.Brand;
import com.eugene.Alcoholic_Library.model.modulManufacturerBrand.Manufacturer;

import javax.persistence.*;

@Entity
@Table(name = "brandies")
public class Brandy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "product_category")
    @Enumerated(value = EnumType.STRING)
    private ProductCategory productCategory;     //Категория товара  enum перечисление

    @Column(name = "classification_brandy")
    @Enumerated(value = EnumType.STRING)
    private ClassificationBrandy classificationBrandy;           // Классификация  enum перечисление

    @Column(name = "years_old")
    private Integer yearsOld;                // Выдержка лет

    @Column(name = "bottle_volume")
    private Double bottleVolume;            //Обьем бутылки

    @Column(name = "alcohol_volume")
    private Double alcoholVolume;         //Крепость алкоголя

    @ManyToOne(fetch = FetchType.LAZY)
    private Manufacturer manufacturer;             // Производитель.   У производителя может быть нескоько брендов, две таблицы

    @ManyToOne(fetch = FetchType.LAZY)
    private Brand brand;                    // Бренд

    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;                  // Страна. У страны может быть несколько регионов, две таблицы

    @ManyToOne(fetch = FetchType.LAZY)
    private Region region;                   // Регион

    public Brandy() {
    }

    public Brandy(ProductCategory productCategory, ClassificationBrandy classificationBrandy, Integer yearsOld, Double bottleVolume, Double alcoholVolume) {
        this.productCategory = productCategory;
        this.classificationBrandy = classificationBrandy;
        this.yearsOld = yearsOld;
        this.bottleVolume = bottleVolume;
        this.alcoholVolume = alcoholVolume;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public ClassificationBrandy getClassificationBrandy() {
        return classificationBrandy;
    }

    public void setClassificationBrandy(ClassificationBrandy classificationBrandy) {
        this.classificationBrandy = classificationBrandy;
    }

    public Integer getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(Integer yearsOld) {
        this.yearsOld = yearsOld;
    }

    public Double getBottleVolume() {
        return bottleVolume;
    }

    public void setBottleVolume(Double bottleVolume) {
        this.bottleVolume = bottleVolume;
    }

    public Double getAlcoholVolume() {
        return alcoholVolume;
    }

    public void setAlcoholVolume(Double alcoholVolume) {
        this.alcoholVolume = alcoholVolume;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
