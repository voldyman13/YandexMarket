package com.company.qa.market;

import com.company.qa.test.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MarketPage {
    public WebElement header;

    @FindBy(xpath = "//span[contains(text(), category)]")
    WebElement categoryLink;
    @FindBy (xpath = "//a[contains(text(), subCategory)]")
    WebElement subCategoryLink;
    @FindBy (id = "glpricefrom")
    WebElement priceFromField; ;
    @FindBy (id = "glpriceto")
    WebElement priceToField;
    @FindBy (css = "input[name$='Apple']")
    WebElement manufacturerCheckBox;
    @FindBy (id = "header-search")
    WebElement searchField;
    @FindBy (css = "button[type=\"submit\"]")
    WebElement submitButton;

}
