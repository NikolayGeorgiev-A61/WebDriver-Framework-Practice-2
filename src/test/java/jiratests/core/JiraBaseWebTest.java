package jiratests.core;

import com.jira.pages.AtlassianHome;
import com.jira.pages.AtlassianLoginPage;
import com.jira.pages.CreateIssueWindow;
import com.jira.pages.JiraNavigationMenu;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import testframework.DriverManager;
import testframework.PropertiesManager;
import testframework.core.BaseWebTest;
import testframework.enums.DriverManager;

public class JiraBaseWebTest extends BaseWebTest {

    // Declare page objects
    protected AtlassianLoginPage loginPage;
    protected AtlassianHome homePage;
    protected CreateIssueWindow issueWindow;
    protected JiraNavigationMenu navigationMenu;
    protected CreateIssueWindow storyWindow;

    @BeforeEach
    public void beforeTests() {
        // Initialize page objects
        homePage = new AtlassianHome();
        loginPage = new AtlassianLoginPage();
        issueWindow = new CreateIssueWindow();
        storyWindow = new CreateIssueWindow();
        navigationMenu = new JiraNavigationMenu();

        // Navigate to base Jira URL
        testframework.enums.DriverManager DriverManager = new testframework.enums.DriverManager();
        DriverManager.getDriver().get(PropertiesManager.getConfigProperties().getProperty("jiraBaseUrl"));
    }

    @BeforeAll
    public static void beforeAll() {
        // Initialize WebDriver before all tests
        DriverManager.getDriver();
    }

    @AfterEach
    public void afterTest() {
        // Close browser after each test
        DriverManager.quitDriver();
    }

    @AfterAll
    public static void afterAll() {
        // Ensure WebDriver is fully quit after all tests
        DriverManager.quitDriver();
    }

    // Common method to authenticate a user
    public void authenticateWithUser(String username, String pass) {
        loginPage.submitLoginForm(username, pass);
        homePage.waitForPageTitle();
    }
}
