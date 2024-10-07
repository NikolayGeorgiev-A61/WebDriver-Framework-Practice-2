package com.jira.pages;

import testframework.PropertiesManager;
import testframework.enums.Driver;
import testframework.enums.DriverManager;

public class BaseJiraPage {
    protected Driver driver;

    public BaseJiraPage(String pageSpecificUrl) {
        this.driver = DriverManager.getDriver();
    }

    public String getBasePageUrl() {
        return PropertiesManager.getConfigProperties().getProperty("jiraBaseUrl");
    }
}
