package com.example.costcoautomation.pages;

import com.microsoft.playwright.Page;

public class HomePage {
    private final Page page;

    public HomePage(Page page) {
        this.page = page;
    }

    public void navigateToHomePage() {
        page.navigate("https://www.costco.com");
    }

    public String getPageTitle() {
        return page.title();
    }
}
