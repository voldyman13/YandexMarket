package com.company.qa.manager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MarketPage extends PageBase{
    @FindBy (xpath = "//div[contains(text(),'Маркет')]")
    WebElement marketLink;
    @FindBy (id = "glpricefrom")
    WebElement priceFromField;
    @FindBy (id = "glpriceto")
    WebElement priceToField;
    @FindBy (id = "header-search")
    WebElement searchField;
    @FindBy (css = "button[type=\"submit\"]")
    WebElement submitButton;

    public MarketPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void submit() {
        submitButton.click();
    }

    @Step("Item for search: {itemName}")
    public void findProductByName(String itemName) {
        searchField.sendKeys(itemName);
    }

    @Step
    public void switchToNewTab(int index) {
        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
        if (!windows.isEmpty()) {
            driver.switchTo().window(windows.get(index));
        }
    }

    @Step("Item number: {number, headLine}")
    public String getItemName(int number, String headLine) {
        WebDriverWait wait = new WebDriverWait(driver, 60, 500);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[contains(text(),'"+headLine+"')]"))));
        List<WebElement> itemList = driver.findElements(By.xpath("//*[@data-autotest-id='product-snippet']//h3"));
        String name = itemList.get(number-1).getText();
        System.out.println("The name of the " + number + "th Item is: " + name);
        return name;
    }
    @Step("ProductName: {number, headLine}")
    public String getProductName(int number, String headLine) {
        WebDriverWait wait = new WebDriverWait(driver, 60, 500);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[contains(text(),'"+headLine+"')]"))));
        List<WebElement> itemList = driver.findElements(By.xpath("//*[@data-autotest-id='product-snippet']//h3"));
        String name = itemList.get(number-1).getText();
        System.out.println("The name of the " + number + "th Item is: " + name);
        return name;
    }

    @Step("Brand: {brand}")
    public void setBrandCheckboxOn(String brand) {
        WebElement brandCheckBox = driver.findElement(By.xpath("//span[(text()='" + brand + "')]"));
        if (!brandCheckBox.isSelected()) {
            brandCheckBox.click();
        }
    }

    @Step("Brand: {subCategory}")
    public void selectSubCategory(String subCategory) {
        driver.findElement(By.xpath("//a[contains(text(),'" + subCategory + "')]")).click();
    }

    @Step("Category: {category}")
    public void selectCategory(String category) {
        driver.findElement(By.xpath("//span[contains(text(),'" + category + "')]")).click();
    }

    @Step("Price range: {priceFrom, priceTo}")
    public void setPriceRange(String priceFrom, String priceTo) {
        priceFromField.sendKeys(priceFrom);
        priceToField.sendKeys(priceTo);
    }
    @Step
    public void goToMarket() {
        driver.findElement(By.xpath("//div[contains(text(),'Маркет')]")).click();
        switchToNewTab(1);
    }
    @Step
    public void exit() {
        driver.close();
        switchToNewTab(0);
    }

}
