package selenium.testcases;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import listener.RetryRule;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import selenium.SeleniumTestWrapper;
import selenium.pageobjects.CreateProjectPage;
import selenium.pageobjects.HomePage;
import selenium.pageobjects.ProjectSettingsPage;
import selenium.pageobjects.StartPage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static selenium.configurations.User.ADMIN_USER;
import static selenium.configurations.ManualProject.NEW_MANUAL_PROJECT_DATA;

@Epic("Projects management tests")
public class ProjectsManagementTests extends SeleniumTestWrapper {

    private StartPage startPage = PageFactory.initElements(getDriver(), StartPage.class);
    private HomePage homePage = PageFactory.initElements(getDriver(), HomePage.class);
    private CreateProjectPage createProjectPage = PageFactory.initElements(getDriver(), CreateProjectPage.class);
    private ProjectSettingsPage projectSettingsPage = PageFactory.initElements(getDriver(), ProjectSettingsPage.class);

    @Before
    public void setup() {
        startPage.open();
    }

    //Set retry count argument
    @Rule
    public RetryRule retryRule = new RetryRule(2);

    @Test
    @Feature("Creating and deleting a project - positive case")
    @Description("Testing of project management (from URL)")
    @TmsLink("123123")
    public void createDeleteNewProjectTest() {
        startPage.checkThatLoginPageIsDisplayed();
        startPage.logIn(ADMIN_USER.getUserName(), ADMIN_USER.getPassword());
        homePage.checkThatHomePageIsDisplayed();
        homePage.clickCreateNewProjectButton();
        createProjectPage.checkThatHomePageIsDisplayed();
        createProjectPage.clickManualProjectCreationButton();
        createProjectPage.checkHomePageForManualProjectIsDisplayed();
        createProjectPage.createNewProjectAction(NEW_MANUAL_PROJECT_DATA.getName(), NEW_MANUAL_PROJECT_DATA.getProjectId(), NEW_MANUAL_PROJECT_DATA.getDescription());
        projectSettingsPage.checkProjectSettingsPageForCreatedProject();
        assertTrue(projectSettingsPage.isSuccessMessageShown(), "Success message is not shown");
        projectSettingsPage.checkNewProjectArtifactsAreShown(NEW_MANUAL_PROJECT_DATA.getName(), NEW_MANUAL_PROJECT_DATA.getProjectId());
        projectSettingsPage.goToHomePage();
        assertTrue(homePage.isProjectShown(NEW_MANUAL_PROJECT_DATA.getName()), "New project is not shown on Home page");
        homePage.clickOnChosenProject(NEW_MANUAL_PROJECT_DATA.getName());
        homePage.checkProjectPage(NEW_MANUAL_PROJECT_DATA.getName());
        homePage.enterProjectSettings();
        projectSettingsPage.checkProjectSettingsPageForCreatedProject();
        projectSettingsPage.executeDeleteProjectAction(NEW_MANUAL_PROJECT_DATA.getName());
        projectSettingsPage.goToHomePage();
        homePage.checkThatHomePageIsDisplayed();
    }
}