package selenium.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.Pages;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateProjectPage extends Pages {

    public CreateProjectPage(WebDriver driver) {
        super(driver);
    }

    /*************************
     * OBJECT LOCATORS       *
     *************************/

    @FindBy(xpath = "//a[text()='Create Project']")
    WebElement createProjectHeader;

    @FindBy(css = ".menuList a[href*='createFromUrl']")
    WebElement createFromURLButton;

    @FindBy(css = "a[href*='createManually']")
    WebElement createManuallyButton;

    @FindBy(id = "name")
    WebElement manualProjectName;

    @FindBy(id = "externalId")
    WebElement manualProjectId;

    @FindBy(id = "description")
    WebElement manualProjectDescription;

    @FindBy(id = "createProject")
    WebElement createManualProjectButton;

    @FindBy(name = "createProjectFromUrl")
    WebElement createProjectFromUrlButton;

    /*************************
     * INTERACTION METHODS   *
     *************************/

    @Step("Quick check of Home page")
    public void checkThatHomePageIsDisplayed() {
        assertTrue(isWebElementDisplayedIn(createProjectHeader), "Create project header is not shown");
        assertTrue(isWebElementDisplayedIn(createFromURLButton), "Projects button is not shown");
        assertTrue(isWebElementDisplayedIn(createManuallyButton), "Administration link is not shown");
        assertTrue(isWebElementDisplayedIn(createProjectFromUrlButton), "Create project from URL button is not shown");
        assertTrue(getAttributeFromCreateProjectButton(createFromURLButton), "From repository is not selected by default");
        assertTrue(driver.getTitle().contains("Create Project — TeamCity"), "Page title is not correct");
    }

    public boolean getAttributeFromCreateProjectButton(WebElement element) {
        return element.getAttribute("class").contains("expanded");
    }

    @Step("Choose manual project creation")
    public void clickManualProjectCreationButton() {
        if (isElementPresent(createManuallyButton) && !getAttributeFromCreateProjectButton(createManuallyButton)) {
            createManuallyButton.click();
        }
    }

    @Step("Quick check of Home page when manual project creation started")
    public void checkHomePageForManualProjectIsDisplayed() {
        assertTrue(isWebElementDisplayedIn(manualProjectName), "Project name is not shown");
        assertTrue(isWebElementDisplayedIn(manualProjectId), "Projects id is not shown");
        assertTrue(isWebElementDisplayedIn(manualProjectDescription), "Project description is not shown");
        assertTrue(isWebElementDisplayedIn(createManualProjectButton), "Create manual project button is not shown");
        assertTrue(getAttributeFromCreateProjectButton(createManuallyButton), "Manual is not selected");
    }

    @Step("Fill the form and create new project")
    public void createNewProjectAction(String name, String id, String description) {
        manualProjectName.sendKeys(name);
        manualProjectId.sendKeys(id);
        manualProjectDescription.sendKeys(description);
        createManualProjectButton.click();
    }
}