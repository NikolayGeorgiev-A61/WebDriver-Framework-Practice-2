package jiratests.web;

import jiratests.core.BaseWebPage;  // Ensure this imports your base class
import org.junit.jupiter.api.Test;

public class LoginWeb extends BaseWebPage {

    @Test
    public void userAuthenticated_when_validCredentialsProvided() {
        // Navigate to Login Page
        loginPage.navigate();

        // Submit login form with valid credentials
        loginPage.submitLoginForm("your_username", "your_password");

        // Wait for the home page title to be present
        homePage.waitForPageTitle();

        // Assert that the user has navigated to the home page
        homePage.assertNavigated();
    }
}
