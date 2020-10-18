package com.company.qa.tests;

import com.company.qa.manager.MarketPage;
import com.company.qa.manager.PageBase;
import com.company.qa.model.Market;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


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
    @DataProvider
    public Iterator<Object[]> marketPositive() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader =
                new BufferedReader(new FileReader(new File("src/test/resources/marketPositive.csv")));
        String line = reader.readLine();
        while (line !=null){
            String[] split = line.split(",");
            list.add(new Object[]{new Market()
                    .setCategory(split[0])
                    .setSubCategory(split[1])
                    .setPriceFrom(split[2])
                    .setPriceTo(split[3])
                    .setBrand(split[4])
                    .setItemNumber(split[5])});
            line= reader.readLine();
        }
        return list.iterator();
    }



    @Test(dataProvider = "marketPositive")
    public void yandexMarketTest(Market mObj) {
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