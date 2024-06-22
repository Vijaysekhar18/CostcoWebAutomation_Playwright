package com.example.costcoautomation;

import com.example.costcoautomation.pages.HomePage;
import com.example.costcoautomation.utils.CostcoUtils;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class CostcoTests {
    private Browser browser;
    private Page page;
    private HomePage homePage;
    private CostcoUtils costcoUtils;

    @BeforeMethod
    public void setUp() {
        Playwright playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        homePage = new HomePage(page);
        costcoUtils = new CostcoUtils(page);
    }

    @AfterMethod
    public void tearDown() {
        if (page != null) {
            page.close();
        }
        if (browser != null) {
            browser.close();
        }
    }

    @Test
    @Description("Verify the title of the Costco home page")
    public void testHomePageTitle() {
        homePage.navigateToHomePage();
        String title = homePage.getPageTitle();
        System.out.println("Page title: " + title);
        if (!"Welcome to Costco Wholesale".equals(title)) {
            throw new AssertionError("Expected page title does not match actual title.");
        }
    }

    // Add other test methods for different functionalities
}
