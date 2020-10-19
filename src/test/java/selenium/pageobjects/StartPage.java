package selenium.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.Pages;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StartPage extends Pages {

	public StartPage(final WebDriver driver) {
		super(driver);
	}

	/*************************
	 * OBJECT LOCATORS       *
	 *************************/

	@FindBy(id = "header")
	WebElement pageHeader;

	@FindBy(id = "remember")
	WebElement rememberMeCheckBox;

	@FindBy(xpath = "//a[text()='Reset password']")
	WebElement resetPasswordLink;

	@FindBy(id = "username")
	WebElement userNameInput;

	@FindBy(id = "password")
	WebElement passwordInput;

	@FindBy(xpath = "//*[@name='submitLogin']")
	WebElement LogInButton;


	/*************************
	 * INTERACTION METHODS   *
	 *************************/

	@Step("Login action")
	public void logIn(String username, String password){
		userNameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		LogInButton.click();
	}

	@Step("Quick check of Login page")
	public void checkThatLoginPageIsDisplayed() {
		assertTrue(isWebElementDisplayedInQuickCheck(pageHeader), "Login page header is not shown");
		assertTrue(isWebElementDisplayedInQuickCheck(rememberMeCheckBox), "Remember me check box is not shown");
		assertTrue(isWebElementDisplayedInQuickCheck(resetPasswordLink), "Reset password is not shown");
	}

	public void open(){
		super.open();
	}
}
