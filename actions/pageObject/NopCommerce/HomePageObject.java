package pageObject.NopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class HomePageObject extends AbstractPage{
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public ProductDetailsPageObject clickToAddToCartButtonFirst() {
		waitForElementClickable(driver, pageUI.NopCommerce.HomePageUI.ADD_TO_CART_BUTTON_FIRST_BUTTON);
		clickToElement(driver, pageUI.NopCommerce.HomePageUI.ADD_TO_CART_BUTTON_FIRST_BUTTON);
		return PageGenenratorManager.getProductDetailsPage(driver);
	}
	
}
