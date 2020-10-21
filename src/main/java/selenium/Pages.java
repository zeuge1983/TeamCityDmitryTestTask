package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.configurations.TypedProperties;

public abstract class Pages extends SeleniumFunctions {

	public Pages(final WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[text()='Projects']")
	WebElement openHomePage;

	private String baseUrl = new TypedProperties("/test_config.properties").getValue("base_url");

	public void goToHomePage() {
		openHomePage.click();
	}

	protected void open(String path){
		driver.get(baseUrl + path);
	}

	protected void open(){
		driver.get(baseUrl);
	}
}