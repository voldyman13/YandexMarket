package com.company.qa.manager;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;


public class PageBase {
    protected WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }



    @Step
    public void openSite(String url) {
        driver.get(url);
    }

}
