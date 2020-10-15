package com.company.qa.test;

import com.company.qa.market.MarketPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class YandexMarketTest {
    public WebDriver driver;
    private MarketPage marketPage;

    String url = "https://yandex.ru/";
    String category = "Компьютеры";
    String subCategory = "Планшеты";
    String manufacturer = "Apple";
    String priceFrom = "20000";
    String priceTo = "35000";
    Integer item = 2;


    @BeforeClass
    public void start() {
//    driver = new InternetExplorerDriver();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }



    @Test
    public void yandexMarketTest() throws InterruptedException {
        driver.get("https://yandex.ru/");
        Thread.sleep(5000);

        goToMarket();
        Thread.sleep(5000);
// здесь вылетает за пределы массива
        ArrayList<String> wl = new ArrayList<String>(driver.getWindowHandles());
        if (!wl.isEmpty()) {
            driver.switchTo().window(wl.get(1));
        }

        chooseCategory(category);
        selectSubCategory(subCategory);
        setPriceFrom(priceFrom);
        Thread.sleep(5000);
        setPriceTo(priceTo);
        Thread.sleep(5000);
        setManufactorerCheckboxOn(manufacturer);
        Thread.sleep(5000);
        String productTitle = getTitleOfProduct(item);
        findProduct(productTitle);
        submit();
        String resultTitle = getTitleOfProduct(1);
        System.out.println(resultTitle);
        Thread.sleep(5000);
//        String resultTitle = getTitle();
//        System.out.println(resultTitle);
        Assert.assertEquals(resultTitle, productTitle);
    }

    private String getTitle() {
        String resultTitle = driver.findElements(By.cssSelector("[data-zone-name=\"title\"]")).get(0).getText();
        return resultTitle;
    }

    private void submit() {
        WebElement submitButton = driver.findElement(By.cssSelector("button[type=\"submit\"]"));
        submitButton.click();
    }

    private void findProduct(String productTitle) {
        WebElement searchField = driver.findElement(By.id("header-search"));
        searchField.sendKeys(productTitle);
    }

    private String getTitleOfProduct(int number){
        List<WebElement> productList = driver.findElements(By.cssSelector("[data-tid=\"ce80a508\"]"));
        return productList.get(number-1).getText();
    }

    private void setManufactorerCheckboxOn(String manufacturer) {
        WebElement manufacturerCheckBox = driver.findElement(By.cssSelector("input[name$=" + manufacturer + "]"));
        if (!manufacturerCheckBox.isSelected()) {
            manufacturerCheckBox.click();
        }
    }

    private void selectSubCategory(String subCategory) {
        WebElement subCategoryLink = driver.findElement(By.xpath("//a[contains(text(), subCategory)]"));
        subCategoryLink.click();
    }

    private void chooseCategory(String category) {
        WebElement categoryLink = driver.findElement(By.xpath("//span[contains(text(), category)]"));
        categoryLink.click();
    }

    private void setPriceTo(String priceTo) {
        WebElement priceToField = driver.findElement(By.id("glpriceto"));
        priceToField.sendKeys(priceTo);
    }

    private void setPriceFrom(String priceFrom) {
        WebElement priceFromField = driver.findElement(By.id("glpricefrom"));
        priceFromField.sendKeys(priceFrom);
    }

    private void goToMarket() {
        driver.findElement(By.cssSelector("[data-id = 'market']"));
    }

    private void openSite(String url) {
        driver.get(url);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}