package com.anand.framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();

            // If running in CI, set headless mode
            if (System.getProperty("browser") != null &&
                    System.getProperty("browser").equalsIgnoreCase("headless")) {
                options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");
            }

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}