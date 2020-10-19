//package selenium.testcases;
//
//import io.qameta.allure.*;
//import listener.RetryRule;
//import org.junit.Before;
//import org.junit.Rule;
//import org.junit.Test;
//import org.openqa.selenium.support.PageFactory;
//import selenium.SeleniumTestWrapper;
//import selenium.pageobjects.StartPage;
//import selenium.utils.browser.Cookies;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assume.assumeFalse;
//
//@Epic("Test epic name")
//@Feature("Feature description")
//public class DoSomeThingWithCookiesTest extends SeleniumTestWrapper {
//
//    private StartPage startPage = PageFactory.initElements(getDriver(), StartPage.class);
//    private Cookies cookies = new Cookies(getDriver());
//
//    @Before
//    public void setup() {
//        startPage.open();
//    }
//
//    //Set retry count argument
//    @Rule
//    public RetryRule retryRule = new RetryRule(1);
//
//    @Test
//    @Story("Story description")
//    @Description("Some detailed test description")
//    @TmsLink("123123")
//    public void checkSomeValueFromCertainCookie() {
//        assertThat(cookies.getValueOfCookieNamed("logged_in")).isEqualTo("no");
//    }
//
//    @Test
//    @Story("Story description")
//    @Description("Some detailed test description")
//    @TmsLink("123123")
//    public void addCustomCookie() {
//        // skip if browser is phantomjs
////        assumeFalse(testConfig.getBrowser().equals("phantomjs"));
//
//        cookies.addCookie("myTestCookie", "added by selenium","github.com", "/", cookies.getValideExpireDate());
//        // check if custom cookie has been added successfully
//        assertThat(cookies.getValueOfCookieNamed("myTestCookie")).isEqualTo("added by selenium");
//    }
//
//    @Test
//    @Story("Story description")
//    @Description("Some detailed test description")
//    @TmsLink("123123")
//    public void deleteCertainCookie() {
//
//        // check if cookie exists initially
//        assertThat(cookies.isCookiePresent("logged_in")).isTrue();
//
//        // delete certain cookie
//        cookies.deleteCookieNamed("logged_in");
//
//        // check if cookie was deleted successfully
//        assertThat(cookies.isCookiePresent("logged_in")).isFalse();
//    }
//
//    @Test
//    @Story("Story description")
//    @Description("Some detailed test description")
//    @TmsLink("123123")
//    public void deleteAllCookies() {
//
//        // check if number of localStorage is greater than 0
//        assertThat(cookies.getAllCookies().size()).isGreaterThan(0);
//
//        // delete all localStorage
//        cookies.deleteAllCookies();
//
//        // check if number of localStorage is 0
//        assertThat(cookies.getAllCookies().size()).isZero();
//    }
//}