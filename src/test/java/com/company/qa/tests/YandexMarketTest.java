package com.company.qa.tests;

import com.company.qa.manager.MarketPage;
import com.company.qa.model.Market;
import io.qameta.allure.Description;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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
    private MarketPage marketPage;

    String url = "https://yandex.ru/";

    @BeforeMethod(alwaysRun = true)
    public void initPageObjects() {
        marketPage = PageFactory.initElements(driver, MarketPage.class);
        marketPage.openSite(url);
    }

    @DataProvider
    public Iterator<Object[]> marketPositive() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader =
                new BufferedReader(new FileReader(new File("src/test/resources/marketPositive.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = ( line.split(",") );
            list.add(new Object[]{new Market()
                    .setCategory(split[0])
                    .setSubCategory(split[1])
                    .setPriceFrom(split[2])
                    .setPriceTo(split[3])
                    .setBrand(split[4])
                    .setItemNumber(split[5])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test(dataProvider = "marketPositive")
    @Description(value = "Step-by-step verification of the search for a specific product")
    public void yandexMarketTest(Market market) {
        marketPage.goToMarket();
        marketPage.selectCategory(market.getCategory());
        marketPage.selectSubCategory(market.getSubCategory());
        marketPage.setPriceRange(market.getPriceFrom(), market.getPriceTo());
        marketPage.setBrandCheckboxOn(market.getBrand());
        String itemName = marketPage.getItemName(Integer.parseInt(market.getItemNumber()), market.getBrand());
        marketPage.findProductByName(itemName);
        marketPage.submit();
        String productName = marketPage.getProductName(1, market.getSubCategory());
        Assert.assertEquals(productName, itemName);
    }

    @AfterMethod
    public void goOut() {
        marketPage.exit();
    }

}