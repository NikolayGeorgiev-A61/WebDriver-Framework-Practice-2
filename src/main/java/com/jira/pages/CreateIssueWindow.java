package com.jira.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CreateIssueWindow extends BaseJiraPage {

    // Constructor to initialize the page URL
    public CreateIssueWindow() {
        super("/secure/CreateIssue!default.jspa"); // Replace with the correct URL for creating an issue
    }

    // Locators for the issue creation form
    private final By projectDropdownLocator = By.id("project-field"); // Adjust the locator as per the actual page
    private final By issueTypeDropdownLocator = By.id("issuetype-field"); // Adjust the locator as per the actual page
    private final By summaryInputLocator = By.id("summary"); // Adjust the locator as per the actual page
    private final By descriptionInputLocator = By.id("description"); // Adjust the locator as per the actual page
    private final By createButtonLocator = By.id("create-issue-submit"); // Adjust the locator as per the actual page
    private final By errorMessageLocator = By.className("error"); // Adjust this to your page's error message class

    // Actions to create an issue
    public void createIssue(String projectName, String issueType, String summary, String description) {
        selectProject(projectName);
        selectIssueType(issueType);
        enterSummary(summary);
        enterDescription(description);
        submitIssue();
    }

    // Method to select a project from the dropdown
    private void selectProject(String projectName) {
        WebElement projectDropdown = driver().findElement(projectDropdownLocator);
        projectDropdown.click();
        WebElement projectOption = driver().findElement(By.xpath("//li[contains(text(), '" + projectName + "')]")); // Adjust this XPath as necessary
        projectOption.click();
    }

    // Method to select an issue type from the dropdown
    private void selectIssueType(String issueType) {
        WebElement issueTypeDropdown = driver().findElement(issueTypeDropdownLocator);
        issueTypeDropdown.click();
        WebElement issueTypeOption = driver().findElement(By.xpath("//li[contains(text(), '" + issueType + "')]")); // Adjust this XPath as necessary
        issueTypeOption.click();
    }

    // Method to enter the summary of the issue
    private void enterSummary(String summary) {
        WebElement summaryInput = driver().findElement(summaryInputLocator);
        summaryInput.sendKeys(summary);
    }

    // Method to enter the description of the issue
    private void enterDescription(String description) {
        WebElement descriptionInput = driver().findElement(descriptionInputLocator);
        descriptionInput.sendKeys(description);
    }

    // Method to submit the issue creation form
    private void submitIssue() {
        WebElement createButton = driver().findElement(createButtonLocator);
        createButton.click();
    }

    // Optional: Validate error messages if the issue creation fails
    public String getErrorMessage() {
        WebElement errorMessage = driver().findElement(errorMessageLocator);
        return errorMessage.getText();
    }
}
