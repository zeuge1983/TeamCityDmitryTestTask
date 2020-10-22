package selenium.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.Pages;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProjectSettingsPage extends Pages {

    public ProjectSettingsPage(WebDriver driver) {
        super(driver);
    }

    /*************************
     * OBJECT LOCATORS       *
     *************************/

    @FindBy(xpath = "//*[@class='editProjectPage']//*[@id='message_projectCreated']")
    WebElement successMessage;

    @FindBy(css = "input[name='submitButton']")
    WebElement submitButton;

    @FindBy(css = ".btn-group button[type='button']")
    WebElement actionsButton;

    @FindBy(xpath = "//a[@title='Delete project']")
    WebElement deleteProjectButton;

    @FindBy(xpath = "//*[text()='Create build configuration']")
    WebElement createBuildConfigurationButton;

    @FindBy(xpath = "//*[text()='Create template']")
    WebElement createTemplateButton;

    @FindBy(xpath = "//*[text()='Create subproject']")
    WebElement createSubProjectButton;


    /*************************
     * INTERACTION METHODS   *
     *************************/

    @Step("Check of Project settings page")
    public void checkProjectSettingsPageForCreatedProject() {
        assertTrue(isWebElementDisplayedIn(submitButton), "Submit button is not shown");
        assertTrue(isWebElementDisplayedIn(createBuildConfigurationButton), "Create build configuration button  is not shown");
        assertTrue(isWebElementDisplayedIn(createTemplateButton), "Create template button is not shown");
        assertTrue(isWebElementDisplayedIn(createSubProjectButton), "Create sub project button is not shown");
        assertThat(driver.getTitle().contains("General Settings — TeamCity"));
    }

    public void checkNewProjectArtifactsAreShown(String projectName, String projectId) {
        assertTrue(checkIfUrlContainsString(projectId));
        assertThat(successMessage.getText()).contains(projectName);
    }

    public boolean isSuccessMessageShown() {
        return isWebElementDisplayedIn(successMessage);
    }

    public void submitNewProject() {
        submitButton.click();
    }

    @Step("Project delete action")
    public void executeDeleteProjectAction(String projectName) {
        assertTrue(isWebElementDisplayedIn(actionsButton), "Actions button is not shown");
        actionsButton.click();
        waitForElement(deleteProjectButton, 3);
        deleteProjectButton.click();
        assertTrue(isAlertPresent(), "Alert for removing project is not shown");
        acceptAlert();
    }
}