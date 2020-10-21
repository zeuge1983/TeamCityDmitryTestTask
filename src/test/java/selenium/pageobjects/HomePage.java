package selenium.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.Pages;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage extends Pages {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    /*************************
     * OBJECT LOCATORS       *
     *************************/

    @FindBy(id = "headerSearchField")
    WebElement headerSearchField;

    @FindBy(xpath = "//a[text() = 'Projects']")
    WebElement projectsLink;

    @FindBy(xpath = "//a[text() = 'Administration']")
    WebElement administrationLink;

    @FindBy(xpath = "//span[contains(@class, 'toggle') and contains(@class, 'icon')]")
    WebElement toggle;

    @FindBy(xpath = "//a[text()='Log out']")
    WebElement logoutButton;

    @FindBy(xpath = "//*[text()='Create project']")
    WebElement createNewProjectButton;

    @FindBy(xpath = "//a[text()='Edit Project Settings']")
    WebElement projectSettings;


    /*************************
     * INTERACTION METHODS   *
     *************************/

    @Step("Quick check of Home page")
    public void checkThatHomePageIsDisplayed() {
        assertTrue(isWebElementDisplayedIn(headerSearchField), "Header search input is not shown");
        assertTrue(isWebElementDisplayedIn(projectsLink), "Projects button is not shown");
        assertTrue(isWebElementDisplayedIn(administrationLink), "Administration link is not shown");
        assertTrue(driver.getTitle().contains("Projects — TeamCity"), "Page title is not shown");
    }

    @Step("Check if showing username is correct '{userName}'")
    public void isUserNameCorrect(String currentUserName, String expectedUserName) {
        assertEquals(driver.findElement(By.xpath("//a[text()='" + currentUserName + "']")).getText(), expectedUserName);
    }

    @Step("Logout action")
    public void executeLogoutAction() {
        moveToElement(toggle);
        waitForElement(logoutButton, 3);
        logoutButton.click();
    }

    public void clickCreateNewProjectButton() {
        if (isElementPresent(createNewProjectButton)) {
            createNewProjectButton.click();
        }
    }

    @Step("Check if created project '{projectName}' shown on Home page")
    public boolean isProjectShown(String projectName) {
        return isWebElementDisplayedIn(driver.findElement(By.xpath("//a[text()='" + projectName + "']")));
    }

    @Step("Enter project page")
    public void clickOnChosenProject(String projectName) {
        driver.findElement(By.xpath("//a[text()='" + projectName + "']")).click();
    }

    public void checkProjectPage(String projectName) {
        assertTrue(isWebElementDisplayedIn(projectSettings), "Project settings link is not shown");
    }

    public void enterProjectSettings() {
        projectSettings.click();
    }
}