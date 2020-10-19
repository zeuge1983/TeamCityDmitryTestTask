//package selenium.testcases;
//
//import io.qameta.allure.*;
//import listener.RetryRule;
//import org.junit.Before;
//import org.junit.Rule;
//import org.junit.Test;
//import org.openqa.selenium.support.PageFactory;
//import selenium.SeleniumTestWrapper;
//import selenium.pageobjects.HeaderSearch;
//import selenium.pageobjects.SearchResultPage;
//import selenium.pageobjects.StartPage;
//import static org.assertj.core.api.Assertions.assertThat;
//
//@Epic("Test epic name")
//@Feature("Feature description")
//public class SearchTest extends SeleniumTestWrapper {
//
//	private StartPage startPage = PageFactory.initElements(getDriver(), StartPage.class);
//	private HeaderSearch search = PageFactory.initElements(getDriver(), HeaderSearch.class);
//	private SearchResultPage searchResultPage = PageFactory.initElements(getDriver(), SearchResultPage.class);
//
//	@Before
//	public void setup() {
//		startPage.open();
//	}
//
//	//Set retry count argument
//	@Rule
//	public RetryRule retryRule = new RetryRule(2);
//
//	@Test
//	@Story("Story description")
//	@Description("Some detailed test description")
//	@TmsLink("123123")
//	public void exampleTestForUserSearch() {
//
//		search.searchFor(search.getSearchString());
//
//		// check for correct search value
//		assertThat(search.getSearchString()).isEqualTo(searchResultPage.getInputValue());
//
//		searchResultPage.clickNaviElement("Users");
//
//		// check account name is in hit list
//		assertThat(searchResultPage.getAccountNames()).contains(search.getSearchString());
//	}
//}
