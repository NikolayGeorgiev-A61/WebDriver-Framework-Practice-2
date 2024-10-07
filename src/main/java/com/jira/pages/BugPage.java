package com.jira.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BugPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By createButton = By.id("create_link");
    private By issueTypeDropdown = By.id("issuetype-field");
    private By summaryField = By.id("summary");
    private By descriptionField = By.id("description");
    private By priorityDropdown = By.id("priority-field");
    private By submitButton = By.id("create-issue-submit");

    public BugPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    // Navigate to bug creation
    public void navigateToCreateBug() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(createButton)).click();
    }

    // Set bug details
    public void setBugDetails(String summary, String description, String priority) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(issueTypeDropdown)).click();
        driver.findElement(issueTypeDropdown).sendKeys("Bug");  // Set issue type to 'Bug'
        driver.findElement(summaryField).sendKeys(summary);
        driver.findElement(descriptionField).sendKeys(description);
        driver.findElement(priorityDropdown).sendKeys(priority);  // Set priority
    }

    // Submit the bug creation form
    public void submitBug() {
        driver.findElement(submitButton).click();
    }

    // Validate if bug is created
    public boolean isBugCreated(String bugTitle) {
        return driver.getPageSource().contains(bugTitle);  // Adjust this based on validation needs
    }
}
