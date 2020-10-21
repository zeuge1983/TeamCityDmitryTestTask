package selenium.testcases;

import io.qameta.allure.*;
import listener.RetryRule;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import selenium.SeleniumTestWrapper;
import selenium.pageobjects.HomePage;
import selenium.pageobjects.StartPage;

import static selenium.configurations.User.ADMIN_USER;
import static utils.TestUtils.sleep;

@Epic("Login tests")
public class LoginTests extends SeleniumTestWrapper {

    private StartPage startPage = PageFactory.initElements(getDriver(), StartPage.class);
    private HomePage homePage = PageFactory.initElements(getDriver(), HomePage.class);

    @Before
    public void setup() {
        startPage.open();
    }

    //Set retry count argument
    @Rule
    public RetryRule retryRule = new RetryRule(2);

    @Test
    @Feature("Login happy path test")
    @Description("Testing of login with correct email and password")
    @TmsLink("123123")
    public void loginLogoutTest() {
        startPage.checkThatLoginPageIsDisplayed();
        startPage.logIn(ADMIN_USER.getUserName(), ADMIN_USER.getPassword());
        homePage.checkThatHomePageIsDisplayed();
        homePage.executeLogoutAction();
        startPage.checkThatLoginPageIsDisplayed();
    }
}