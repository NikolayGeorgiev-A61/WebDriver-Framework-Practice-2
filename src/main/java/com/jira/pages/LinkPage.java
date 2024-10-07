package com.jira.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinkPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By moreOptionsButton = By.id("opsbar-operations_more");
    private By linkButton = By.id("link-issue");
    private By issueKeyField = By.id("jira-issue-keys-textarea");
    private By linkTypeDropdown = By.id("link-type-field");
    private By linkSubmitButton = By.id("link-issue-submit");

    public LinkPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    // Link the bug to a story with the relation 'is blocked by'
    public void linkBugToStory(String storyKey, String bugKey) {
        // Navigate to the bug issue page
        driver.get("https://your-jira-url/browse/" + bugKey);

        // Click on 'More Options' and select 'Link'
        wait.until(ExpectedConditions.visibilityOfElementLocated(moreOptionsButton)).click();
        driver.findElement(linkButton).click();

        // Set issue key and link type
        driver.findElement(issueKeyField).sendKeys(storyKey);
        driver.findElement(linkTypeDropdown).sendKeys("is blocked by");

        // Submit the link form
        driver.findElement(linkSubmitButton).click();
    }

    // Validate if the bug is linked to the story
    public boolean isBugLinkedToStory(String storyKey) {
        return driver.getPageSource().contains(storyKey);  // Adjust validation as per the page source
    }
}
