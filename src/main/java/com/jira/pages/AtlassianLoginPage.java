package com.jira.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static testframework.core.BaseWebTest.driver;

public class AtlassianLoginPage extends BaseJiraPage {
    public AtlassianLoginPage() {
        super("/login");
    }

    // Locators
    private final By usernameLocator = By.xpath("//input[@data-test='username']");
    private final By passwordLocator = By.xpath("//input[@data-test='password']");
    private final By loginButtonLocator = By.xpath("//input[@id='login-button']");

    // Actions
    public void navigate() {
        driver().get(getBasePageUrl() + "/login");
    }

    public void submitLoginForm(String username, String password) {
        WebElement usernameInput = driver().findElement(usernameLocator);
        usernameInput.sendKeys(username);

        WebElement passwordInput = driver().findElement(passwordLocator);
        passwordInput.sendKeys(password);

        WebElement loginButton = driver().findElement(loginButtonLocator);
        loginButton.click();
    }
}
