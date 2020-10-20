package selenium;

import org.junit.After;
import org.junit.Before;

import org.openqa.selenium.WebDriver;
import selenium.configurations.TestConfig;
import selenium.driver.WebDriverConfig;
import selenium.utils.WebDriverProvider;
import selenium.utils.annotations.DisableCookies;
import selenium.utils.annotations.UserAgent;
import selenium.utils.annotations.browser.Browser;
import selenium.utils.annotations.browser.Browsers;

import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;

public abstract class SeleniumTestWrapper {

	// Config
//	protected static final TestConfig testConfig = new TestConfig();
	private final WebDriverConfig webDriverConfig = new WebDriverConfig();
	protected final WebDriverProvider webDriverProvider = new WebDriverProvider(this.webDriverConfig);

	protected WebDriver getDriver() {
		return this.webDriverProvider.getDriver();
	}

	/**
	 * test class annotations
	 */
//	@Before
//	public void setUserAgent(){
//		UserAgent userAgent = this.getClass().getAnnotation(UserAgent.class);
//		if (userAgent != null) {
//			webDriverProvider.useUserAgent(userAgent.value());
//		}
//	}

	@Before
	public void disableCookies(){
		DisableCookies cookies = this.getClass().getAnnotation(DisableCookies.class);
		if (cookies != null) {
			webDriverProvider.disableCookies(true);
		}
	}

	@Before
	public void browserDimension(){
		getDriver().manage().window().maximize();
	}

	@After
	public void closeBrowser(){
		getDriver().quit();
	}
}