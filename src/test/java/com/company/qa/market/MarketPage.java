package com.company.qa.market;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class MarketPage extends PageBase{

    @FindBy (id = "glpricefrom")
    WebElement priceFromField; ;
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
    public void switchToNewTab() {
        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
        if (!windows.isEmpty()) {
            driver.switchTo().window(windows.get(1));
        }
    }

    @Step("Item number: {number}")
    public String getItemName(int number, String headLine) {
        WebDriverWait wait = new WebDriverWait(driver, 60, 500);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[contains(text(),'"+headLine+"')]"))));
        List<WebElement> itemList = driver.findElements(By.xpath("//*[@data-autotest-id='product-snippet']//h3"));
        String name = itemList.get(number-1).getText();
        System.out.println("The name of the " + number + "th Item is: " + name);
        return name;
    }
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

    @Step("Brand: {brand}")
    public void selectSubCategory(String subCategory) {
        driver.findElement(By.xpath("//a[contains(text(), '" + subCategory + "')]")).click();
    }

    @Step("Category: {category}")
    public void selectCategory(String category) {
        driver.findElement(By.xpath("//span[contains(text(), '" + category + "')]")).click();
    }

    @Step("Price range: {priceFrom, priceTo}")
    public void setPriceRange(String priceFrom, String priceTo) {
        priceFromField.sendKeys(priceFrom);
        priceToField.sendKeys(priceTo);
    }

}
