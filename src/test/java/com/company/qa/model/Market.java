package com.company.qa.model;
public class Market {
    private String category;
    private String subCategory;
    private String priceFrom;
    private String priceTo;
    private String brand;
    private String itemNumber;

    public Market() {}

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

    public String getItemNumber() {
        return this.itemNumber;
    }

    public Market setCategory(String category) {
        if(category.equals(null) | category.isEmpty()) {
            System.out.println("Error: wrong category");
            return null;
        }
        this.category = category;
        return this;
    }

    public Market setSubCategory(String subCategory) {
        if(subCategory.equals(null) | subCategory.isEmpty()) {
            System.out.println("Error: wrong subCategory");
            return null;
        }
        this.subCategory = subCategory;
        return this;
    }

    public Market setPriceFrom(String priceFrom) {
        try {
            Integer.parseInt(priceFrom);
        }catch (Exception e){
            System.out.println("Error: wrong priceFrom. " + e);
            return null;
        }
        if(priceFrom.equals(null) | priceFrom.isEmpty()) {
            System.out.println("Error: priceFrom is null or empty");
            return null;
        }
        this.priceFrom = priceFrom;
        return this;
    }

    public Market setPriceTo(String priceTo) {
        try {
            Integer.parseInt(priceTo);
        }catch (Exception e){
            System.out.println("Error: wrong priceTo. " + e);
            return null;
        }
        if(priceTo.equals(null) | priceTo.isEmpty()) {
            System.out.println("Error: priceTo is null or empty");
            return null;
        }
        this.priceTo = priceTo;
        return this;
    }

    public Market setBrand(String brand) {
        if(brand.equals(null) | brand.isEmpty()) {
            System.out.println("Error: wrong brand");
            return null;
        }
        this.brand = brand;
        return this;
    }

    public Market setItemNumber(String itemNumber) {
        try {
            Integer.parseInt(itemNumber);
        }catch (Exception e){
            System.out.println("Error: wrong itemNumber. " + e);
            return null;
        }
        if(itemNumber.equals(null) | itemNumber.isEmpty()) {
            System.out.println("Error: itemNumber is null or empty");
            return null;
        }
        this.itemNumber = itemNumber;
        return this;
    }

    @Override
    public String toString() {
        return "Product[" +
                "category='" + category + '\'' +
                ", subCategory='" + subCategory + '\'' +
                ", priceFrom='" + priceFrom + '\'' +
                ", priceTo='" + priceTo + '\'' +
                ", brand='" + brand + '\'' +
                ", item=" + itemNumber +
                ']';
    }
}
