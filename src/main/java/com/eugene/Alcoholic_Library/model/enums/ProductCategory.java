package com.eugene.Alcoholic_Library.model.enums;

public enum ProductCategory {
    COGNAC("Коньяк"), BRANDY("Бренди");

    String title;

    ProductCategory(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
