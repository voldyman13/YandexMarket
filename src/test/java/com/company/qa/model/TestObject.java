package com.company.qa.model;
public class TestObject {
    private String category;
    private String subCategory;
    private String priceFrom;
    private String priceTo;
    private String brand;
    private Integer itemNumber;

    public TestObject(String category, String subCategory, String priceFrom, String priceTo, String brand, Integer itemNumber) {
        this.category = category;
        this.subCategory = subCategory;
        this.priceFrom = priceFrom;
        this.priceTo = priceTo;
        this.brand = brand;
        this.itemNumber = itemNumber;
    }
    public TestObject() {}

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
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(String priceFrom) {
        this.priceFrom = priceFrom;
    }

    public String getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(String priceTo) {
        this.priceTo = priceTo;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getItem() {
        return itemNumber;
    }

    public void setItem(Integer itemNumber) {
        this.itemNumber = itemNumber;
    }
}
