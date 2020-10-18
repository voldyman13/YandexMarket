package com.company.qa.tests;

import com.company.qa.market.MarketPage;
import com.company.qa.market.PageBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class YandexMarketTest extends TestBase {
    private MarketPage market;
    private PageBase pageBase;

    String url = "https://yandex.ru/";
    String category = "Компьютеры";
    String subCategory = "Планшеты";
    String brand = "Apple";
    String priceFrom = "20000";
    String priceTo = "35000";
    Integer itemNumber = 2;


    @BeforeMethod(alwaysRun = true)
    public void initPageObjects() {
        market = PageFactory.initElements(driver, MarketPage.class);
    }


//    Product product = new Product(category, subCategory, priceFrom, priceTo, brand, itemNumber);

    @Test
    public void yandexMarketTest() {
        market.openSite(url);
        market.goToMarket();
        market.switchToNewTab();
        market.selectCategory(category);
        market.selectSubCategory(subCategory);
        market.setPriceRange(priceFrom, priceTo);
        market.setBrandCheckboxOn(brand);
        String itemName = market.getItemName(itemNumber, brand);
        market.findProductByName(itemName);
        market.submit();
        String productName = market.getProductName(1, subCategory);
        Assert.assertEquals(productName, itemName);
    }
}