package com.jira.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AtlassianHome extends BaseJiraPage {

    // Locators for elements that indicate the user is on the home page
    private final By dashboardTitleLocator = By.xpath("//h1[contains(text(), 'Dashboard')]"); // Example locator

    public AtlassianHome() {
        super("/home"); // Adjust based on your application's URL for the home page
    }

    // Method to assert that the navigation to the home page was successful
    public void assertNavigated() {
        // Check if the dashboard title is displayed to confirm navigation
        if (!driver.findElement(dashboardTitleLocator).isDisplayed()) {
            throw new AssertionError("User is not navigated to the home page.");
        }
    }

    // Optionally, you might want to add a method to wait for the title to load
    public void waitForPageTitle() {
        // Implement waiting logic if necessary
        // For example, wait until the dashboard title is visible
        driver.getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(dashboardTitleLocator));
    }
}
