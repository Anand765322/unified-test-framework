package com.anand.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage {
    private WebDriver driver;

    // Constructor
    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By searchBox = By.name("q");

    // Page Actions
    public void openGoogle() {
        driver.get("https://www.google.com");
    }

    public void searchFor(String query) {
        driver.findElement(searchBox).sendKeys(query + Keys.ENTER);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
