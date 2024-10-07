package com.jira.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StoryPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By createButton = By.id("create_link");  // Locator for the create button in Jira
    private By issueTypeDropdown = By.id("issuetype-field"); // Issue type dropdown
    private By summaryField = By.id("summary");
    private By descriptionField = By.id("description");
    private By priorityDropdown = By.id("priority-field");
    private By submitButton = By.id("create-issue-submit");  // Submit button

    public StoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    // Navigate to story creation
    public void navigateToCreateStory() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(createButton)).click();
    }

    // Set story details
    public void setStoryDetails(String summary, String description, String priority) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(issueTypeDropdown)).click();
        driver.findElement(issueTypeDropdown).sendKeys("Story");  // Set issue type to 'Story'
        driver.findElement(summaryField).sendKeys(summary);
        driver.findElement(descriptionField).sendKeys(description);
        driver.findElement(priorityDropdown).sendKeys(priority);  // Set priority based on severity
    }

    // Submit the story creation form
    public void submitStory() {
        driver.findElement(submitButton).click();
    }

    // Validate if story is created
    public boolean isStoryCreated(String storyTitle) {
        return driver.getPageSource().contains(storyTitle);  // Adjust this based on validation needs
    }
}
