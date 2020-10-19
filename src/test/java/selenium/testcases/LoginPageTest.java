package selenium.testcases;

import io.qameta.allure.*;
import listener.RetryRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import selenium.SeleniumTestWrapper;
import selenium.pageobjects.StartPage;

import static utils.TestUtils.sleep;

@Epic("Test epic name")
@Feature("Feature description")
public class LoginPageTest extends SeleniumTestWrapper {

    private StartPage startPage = PageFactory.initElements(getDriver(), StartPage.class);
//    private LoginPage loginPage  = PageFactory.initElements(getDriver(), LoginPage.class);

    @Before
    public void setup() {
        startPage.open();
    }

    //Set retry count argument
    @Rule
    public RetryRule retryRule = new RetryRule(1);

    @Test
    @Story("Story description")
    @Description("Some detailed test description")
    @TmsLink("123123")
    public void checkSomeValueFromCertainCookie() {
        startPage.checkThatLoginPageIsDisplayed();
        startPage.logIn("DmitrySuperUser", "Shpinek1987");
        sleep(5000);
    }
}