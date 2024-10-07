package jiratests.web;

import com.jira.pages.BugPage;
import com.jira.pages.LinkPage;
import org.junit.Test;
import testframework.core.BaseWebPage;
import com.jira.pages.StoryPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static testframework.enums.DriverManager.driver;

public class CreateIssueTestsWeb extends BaseWebPage {



    @Test
    public void userCanCreateStory_withValidDetails() {
        StoryPage storyPage = new StoryPage(driver);

        // Step 1: Navigate to story creation
        storyPage.navigateToCreateStory();

        // Step 2: Set story details (summary, description, priority)
        String summary = "Automated Test Story";
        String description = "This is an automated test for creating a story.";
        String priority = "High";
        storyPage.setStoryDetails(summary, description, priority);

        // Step 3: Submit the form
        storyPage.submitStory();

        // Step 4: Validate story creation
        assertTrue(storyPage.isStoryCreated(summary), "Story creation failed!");
    }

    @Test
    public void userCanCreateBug_withValidDetails() {
        BugPage bugPage = new BugPage(driver);

        // Step 1: Navigate to bug creation
        bugPage.navigateToCreateBug();

        // Step 2: Set bug details (summary, description, priority)
        String summary = "Automated Test Bug";
        String description = "This is an automated test for creating a bug.";
        String priority = "Critical";
        bugPage.setBugDetails(summary, description, priority);

        // Step 3: Submit the form
        bugPage.submitBug();

        // Step 4: Validate bug creation
        assertTrue(bugPage.isBugCreated(summary), "Bug creation failed!");
    }

    @Test
    public void userCanLinkBugToStory_withBlockedByRelation() {
        LinkPage linkPage = new LinkPage(driver);

        // Bug and story keys (you should fetch these dynamically in a real scenario)
        String bugKey = "BUG-123";
        String storyKey = "STORY-456";

        // Step 1: Link the bug to the story
        linkPage.linkBugToStory(storyKey, bugKey);

        // Step 2: Validate the link
        assertTrue(linkPage.isBugLinkedToStory(storyKey), "Failed to link the bug to the story!");
    }

}