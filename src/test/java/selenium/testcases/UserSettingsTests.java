package selenium.testcases;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import listener.RetryRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import selenium.SeleniumTestWrapper;
import selenium.pageobjects.HomePage;
import selenium.pageobjects.StartPage;
import selenium.pageobjects.settings.ToolsAndSettingsPage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static selenium.configurations.User.ADMIN_USER;
import static utils.TestUtils.randomString;

@Epic("My settings and tools tests")
public class UserSettingsTests extends SeleniumTestWrapper {

    private StartPage startPage = PageFactory.initElements(getDriver(), StartPage.class);
    private HomePage homePage = PageFactory.initElements(getDriver(), HomePage.class);
    private ToolsAndSettingsPage toolsAndSettingsPage = PageFactory.initElements(getDriver(), ToolsAndSettingsPage.class);

    @Before
    public void setup() {
        startPage.open();
    }

    //Set retry count argument
    @Rule
    public RetryRule retryRule = new RetryRule(2);

    @Test
    @Feature("User settings management")
    @Description("Testing of users Settings & Tools page")
    @TmsLink("123123")
    public void createDeleteNewProjectTest() {
        startPage.checkThatLoginPageIsDisplayed();
        startPage.logIn(ADMIN_USER.getUserName(), ADMIN_USER.getPassword());
        homePage.checkThatHomePageIsDisplayed();
        homePage.enterUserSettingsPage();
        toolsAndSettingsPage.checkThatSettingsAndToolsPageIsDisplayed();
        assertTrue(toolsAndSettingsPage.checkTeamCityUserName(ADMIN_USER.getUserName()), "User name is different then was used to login");
        String newName = randomString();
        toolsAndSettingsPage.updateName(newName);
        toolsAndSettingsPage.checkSuccessMessage();
        toolsAndSettingsPage.goToHomePage();
        homePage.checkThatHomePageIsDisplayed();
        homePage.verifyUserAccountName(newName);
    }
}