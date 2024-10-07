package testframework.core;

import com.jira.pages.AtlassianHome;
import com.jira.pages.AtlassianLoginPage;
import com.jira.pages.CreateIssueWindow;
import com.jira.pages.JiraNavigationMenu;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import testframework.PropertiesManager;

public abstract class BaseWebPage extends BaseWebTest {
    protected AtlassianLoginPage loginPage;
    protected AtlassianHome homePage;
    protected CreateIssueWindow issueWindow;
    protected JiraNavigationMenu navigationMenu;

    public BaseWebPage(String pageSpecificUrl) {
        super();
    }

    @BeforeEach
    public void beforeTests() {
        // Initialize page objects
        homePage = new AtlassianHome();
        loginPage = new AtlassianLoginPage();
        issueWindow = new CreateIssueWindow();
        navigationMenu = new JiraNavigationMenu();

        // Navigate to base page
        driver().get(PropertiesManager.getConfigProperties().getProperty("jiraBaseUrl"));
    }

    @BeforeAll
    public static void beforeAll() {
        // Perform some setup code before all tests start
    }

    @AfterEach
    public void afterTest() {
        // Clean up after each test
        driver().close();
    }

    @AfterAll
    public static void afterAll() {
        // Clean up after all tests
        driver().quit();
    }

    public void authenticateWithUser(String username, String password) {
        loginPage.submitLoginForm(username, password);
        homePage.waitForPageTitle();
    }

    public abstract String getBasePageUrl();
}
