package pageObject.NopCommerce;
import org.openqa.selenium.WebDriver;

public class PageGenenratorManager {
	public static FooterMyAccountPageObject getFooterMyAccountPage(WebDriver driver) {
		return new FooterMyAccountPageObject(driver);
	}

	public static HeaderWishlistPageObject getHeaderWishlistPage(WebDriver driver) {
		return new HeaderWishlistPageObject(driver);
	}
	
	public static HomePageObject getHomePage(WebDriver driver)  {
		return new HomePageObject(driver);
	}
	
	public static SearchPageObject getSearchPage(WebDriver driver) {
		return new SearchPageObject(driver);
	}
	
	public static ShippingAndReturnPageObject getShippingAndReturnPage(WebDriver driver) {
		return new ShippingAndReturnPageObject(driver);
	}
	
	public static SitemapPageObject getSitemapPage(WebDriver driver) {
		return new SitemapPageObject(driver);
	}
}