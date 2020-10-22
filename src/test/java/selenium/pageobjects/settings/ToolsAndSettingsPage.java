package selenium.pageobjects.settings;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.Pages;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;
import static utils.TestUtils.sleep;

public class ToolsAndSettingsPage extends Pages {

    public ToolsAndSettingsPage(WebDriver driver) {
        super(driver);
    }

    /*************************
     * OBJECT LOCATORS       *
     *************************/

    @FindBy(xpath = "//h1[text()='My Settings & Tools']")
    WebElement settingsPageHeader;

    @FindBy(xpath = "//*[text()='TeamCity Tools']/../..")
    WebElement teamCityToolsSideBar;

    @FindBy(xpath = "//a[text()='VCS Usernames']")
    WebElement vcsUserNamesButton;

    @FindBy(xpath = "//a[text()='Groups']")
    WebElement groupsButton;

    @FindBy(xpath = "//a[text()='Notification Rules']")
    WebElement notificationRulesButton;

    @FindBy(xpath = "//a[text()='Access Tokens']")
    WebElement accessTokensButton;

    @FindBy(id = "text_teamcityUsername")
    WebElement teamCityUserName;

    @FindBy(css = ".tc-icon_edit_gray")
    WebElement editUserNameButton;

    @FindBy(xpath = "//input[@id='input_teamcityUsername']")
    WebElement userNameInputField;

    @FindBy(xpath = "//input[@id='name']")
    WebElement nameInputField;

    @FindBy(xpath = "//*[@id='modifiedMessageForm']//*[@value='Save']")
    WebElement saveChangesButton;

    @FindBy(css = ".successMessage[id='message_userChanged']")
    WebElement successMessage;


    /*************************
     * INTERACTION METHODS   *
     *************************/

    @Step("Quick check of Settings & tools page")
    public void checkThatSettingsAndToolsPageIsDisplayed() {
        assertTrue(isWebElementDisplayedIn(settingsPageHeader), "Settings page header is not shown");
        assertTrue(isWebElementDisplayedIn(teamCityToolsSideBar), "Team city tools sidebar is not shown");
        assertTrue(isWebElementDisplayedIn(vcsUserNamesButton), "VCS user names link is not shown");
        assertTrue(isWebElementDisplayedIn(groupsButton), "Groups link is not shown");
        assertTrue(isWebElementDisplayedIn(notificationRulesButton), "Notification rules link is not shown");
        assertTrue(isWebElementDisplayedIn(accessTokensButton), "Access tokens link is not shown");
    }

    public boolean checkTeamCityUserName(String currentUser) {
        return teamCityUserName.getText().equals(currentUser);
    }

    public void updateName(String name) {
        nameInputField.clear();
        nameInputField.sendKeys(name);
        if (isElementPresent(saveChangesButton)) {
            saveChangesButton.click();
        }
    }

    public void checkSuccessMessage() {
        if (isElementPresent(successMessage)) {
            assertThat(successMessage.getText().equals("\n" +
                    "Your changes have been saved."));
        }
    }
}