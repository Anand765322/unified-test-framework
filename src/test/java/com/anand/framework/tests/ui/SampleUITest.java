package com.anand.framework.tests.ui;

import com.aventstack.extentreports.ExtentTest;
import com.anand.framework.pages.GoogleHomePage;
import com.anand.framework.utils.ExtentReportManager;
import com.anand.framework.utils.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SampleUITest {
    private WebDriver driver;
    private ExtentTest test;
    private GoogleHomePage googleHomePage;

    @BeforeSuite
    public void setupReport() {
        ExtentReportManager.setupReport();
    }

    @BeforeClass
    public void setUp() {
        driver = WebDriverManager.getDriver();
        googleHomePage = new GoogleHomePage(driver);  // Initialize Page
    }

    @Test
    public void searchGoogleTest() {
        test = ExtentReportManager.createTest("Google Search Test");

        googleHomePage.openGoogle();
        test.info("Opened Google homepage");

        googleHomePage.searchFor("Best Movies");
        test.info("Searched for 'Best Movies'");

        String title = googleHomePage.getPageTitle();
        test.info("Page title: " + title);

        Assert.assertTrue(title.contains("Best Movies"));
        test.pass("Title contains search query - Test Passed");
    }

    @AfterClass
    public void tearDown() {
        WebDriverManager.quitDriver();
    }

    @AfterSuite
    public void flushReport() {
        ExtentReportManager.flushReport();
    }
}
