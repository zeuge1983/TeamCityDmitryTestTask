package selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.Pages;

public class UserSettingsPage extends Pages {

    public UserSettingsPage(WebDriver driver) {
        super(driver);
    }

    /*************************
     * OBJECT LOCATORS       *
     *************************/

    @FindBy(id = "header")
    WebElement pageHeader;


    /*************************
     * INTERACTION METHODS   *
     *************************/
}
