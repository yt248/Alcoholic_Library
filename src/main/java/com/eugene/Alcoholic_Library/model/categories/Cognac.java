package com.eugene.Alcoholic_Library.model.categories;

import com.eugene.Alcoholic_Library.model.enums.ClassificationCognac;
import com.eugene.Alcoholic_Library.model.enums.ProductCategory;
import com.eugene.Alcoholic_Library.model.modulCountryRegionSubregion.Appellation;
import com.eugene.Alcoholic_Library.model.modulCountryRegionSubregion.Country;
import com.eugene.Alcoholic_Library.model.modulCountryRegionSubregion.Region;
import com.eugene.Alcoholic_Library.model.modulManufacturerBrand.Brand;
import com.eugene.Alcoholic_Library.model.modulManufacturerBrand.Manufacturer;

import javax.persistence.*;

@Entity
@Table(name = "cognacs")
public class Cognac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "product_category")
    @Enumerated(value = EnumType.STRING)
    private ProductCategory productCategory;     //Категория товара  enum перечисление

    @Column(name = "classification_cognac")
    @Enumerated(value = EnumType.STRING)
    private ClassificationCognac classificationCognac;           // Классификация коньяк  enum перечисление

    @Column(name = "years_old")
    private Integer yearsOld;                // Выдержка лет

    @Column(name = "bottle_volume")
    private Double bottleVolume;            //Обьем бутылки

    @Column(name = "alcohol_volume")
    private Double alcoholVolume;         //Крепость алкоголя

    @ManyToOne(fetch = FetchType.LAZY)
    private Appellation appellation;   //Аппелласьеон

    @ManyToOne(fetch = FetchType.LAZY)
    private Manufacturer manufacturer;             // Производитель.   У производителя может быть нескоько брендов, две таблицы

    @ManyToOne(fetch = FetchType.LAZY)
    private Brand brand;                    // Бренд

    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;                  // Страна. У страны может быть несколько регионов, две таблицы

    @ManyToOne(fetch = FetchType.LAZY)
    private Region region;                   // Регион


    public Cognac() {
    }

    public Cognac(ProductCategory productCategory, ClassificationCognac classificationCognac, Integer yearsOld, Double bottleVolume, Double alcoholVolume) {
        this.productCategory = productCategory;
        this.classificationCognac = classificationCognac;
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

    public ClassificationCognac getClassificationCognac() {
        return classificationCognac;
    }

    public void setClassificationCognac(ClassificationCognac classificationCognac) {
        this.classificationCognac = classificationCognac;
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

    public Appellation getAppellation() {
        return appellation;
    }

    public void setAppellation(Appellation appellation) {
        this.appellation = appellation;
    }
}
