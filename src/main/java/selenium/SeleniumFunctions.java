package selenium;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.configurations.TypedProperties;
import utils.TestUtils;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public abstract class SeleniumFunctions {

	protected WebDriver driver;

	public SeleniumFunctions(final WebDriver driver) {
		this.driver = driver;
	}

	private static final int ELEMENT_WAIT_TIMEOUT_IN_SECONDS = 5;
	private static final int SHORT_WAITING_TIME_FOR_ELEMENTS_DISPLAY_MILLIS = 200;
	private static final int WEB_WAIT_TIMEOUT = 6;

	protected boolean isWebElementDisplayedIn(final WebElement element) {
		boolean isElementDisplayed;
		try {
			WebDriverWait wait = new WebDriverWait(
					driver, WEB_WAIT_TIMEOUT, SHORT_WAITING_TIME_FOR_ELEMENTS_DISPLAY_MILLIS
			);
			wait.until(ExpectedConditions.visibilityOf(element));
			isElementDisplayed = true;
		} catch (Exception e) {
			isElementDisplayed = false;
		}
		return isElementDisplayed;
	}

	public void waitForLoad() {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(pageLoadCondition);
	}

	protected boolean isElementPresent(final WebElement element) {
		try {
			element.getTagName();
		} catch (final NoSuchElementException ignored) {
			return false;
		} catch (final StaleElementReferenceException ignored) {
			return false;
		}
		return true;
	}

	protected boolean isElementVisible(final WebElement element) {
		return element.isDisplayed();
	}

	protected boolean isAnyTextPresent(final WebElement element) {
		final String text = element.getText();
		return StringUtils.isNotBlank(text);
	}

	protected void waitForElement(final WebElement element) {
		this.waitForElement(element, ELEMENT_WAIT_TIMEOUT_IN_SECONDS);
	}

	protected void waitForElement(final WebElement element, final int timeoutInSeconds) {
		final WebDriverWait wait = new WebDriverWait(this.driver, timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	protected void waitForElement(final By by, final int timeoutInSeconds) {
		final WebDriverWait wait = new WebDriverWait(this.driver, timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void waitForPageLoad(final int timeoutInSeconds) {
		waitForElement(By.tagName("html"), timeoutInSeconds);
	}

	protected void mouseover(final WebElement element) {
		final Actions builder = new Actions(this.driver);
		final Action mouseover = builder.moveToElement(element).build();
		mouseover.perform();
	}

	protected void moveToElement(final WebElement element) {
		mouseover(element);
	}

	protected boolean checkIfUrlContainsString(String string) {
		return driver.getCurrentUrl().contains(string);
	}

	public boolean isAlertPresent() {
		try {
            final Alert alert = this.driver.switchTo().alert();
            alert.getText();
		} catch (final NoAlertPresentException nape) {
			return false;
		}
		return true;
	}

	public String getAlertText() {
        final Alert alert = this.driver.switchTo().alert();
        return alert.getText();
	}

	public void acceptAlert() {
		String mainWindow = driver.getWindowHandle();
        final Alert alert = this.driver.switchTo().alert();
        alert.accept();
		//switch to main window
		driver.switchTo().window(mainWindow);
	}

	public void dismissAlert() {
        final Alert alert = this.driver.switchTo().alert();
        alert.dismiss();
	}
}