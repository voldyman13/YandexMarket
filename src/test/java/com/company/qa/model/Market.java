package com.company.qa.model;
public class Market {
    private String category;
    private String subCategory;
    private String priceFrom;
    private String priceTo;
    private String brand;
    private Integer itemNumber;


//    public Market(String category, String subCategory, String priceFrom, String priceTo, String brand, Integer itemNumber) {
//        this.category = category;
//        this.subCategory = subCategory;
//        this.priceFrom = priceFrom;
//        this.priceTo = priceTo;
//        this.brand = brand;
//        this.itemNumber = itemNumber;
//    }

    public Market() {}

        @Override
    public String toString() {
        return "Product{" +
                "category='" + category + '\'' +
                ", subCategory='" + subCategory + '\'' +
                ", priceFrom='" + priceFrom + '\'' +
                ", priceTo='" + priceTo + '\'' +
                ", brand='" + brand + '\'' +
                ", item=" + itemNumber +
                '}';
    }

    public String getCategory() {
        return this.category;
    }

    public String getSubCategory() {
        return this.subCategory;
    }

    public String getPriceFrom() {
        return this.priceFrom;
    }

    public String getPriceTo() {
        return this.priceTo;
    }

    public String getBrand() {
        return this.brand;
    }

    public Integer getItemNumber() {
        return this.itemNumber;
    }

    public Market setCategory(String category) {
        this.category = category;
        return this;
    }

    public Market setSubCategory(String subCategory) {
        this.subCategory = subCategory;
        return this;

    }

    public Market setPriceFrom(String priceFrom) {
        this.priceFrom = priceFrom;
        return this;

    }

    public Market setPriceTo(String priceTo) {
        this.priceTo = priceTo;
        return this;
    }

    public Market setBrand(String brand) {
        this.brand = brand;
        return this;
    }


    public Market setItemNumber(Integer itemNumber) {
        this.itemNumber = itemNumber;
        return this;
    }
}
