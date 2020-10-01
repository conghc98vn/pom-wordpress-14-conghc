package pageObject.NopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.NopCommerce.ProductDetailsPageUI;

public class ProductDetailsPageObject extends AbstractPage {

	WebDriver driver;
	
	public ProductDetailsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToReviewTitleTextbox(String reviewTitle) {
		waitForElementsVissible(driver, ProductDetailsPageUI.REVIEW_TITLE_TEXTBOX);
		sendkeyToElement(driver, ProductDetailsPageUI.REVIEW_TITLE_TEXTBOX, reviewTitle);		
	}

	public void inputToReviewTextTextbox(String reviewText) {
		waitForElementsVissible(driver, ProductDetailsPageUI.REVIEW_TEXT_TEXTAREA);
		sendkeyToElement(driver, ProductDetailsPageUI.REVIEW_TEXT_TEXTAREA, reviewText);	
	}

	public void clickToSubmitReview() {
		waitForElementsVissible(driver, ProductDetailsPageUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver, ProductDetailsPageUI.SUBMIT_REVIEW_BUTTON);
	}

	public String getReviewTextText(String reviewText) {
		waitForElementsVissible(driver, ProductDetailsPageUI.REVIEW_TEXT_TEXT);
		return getElementText(driver, ProductDetailsPageUI.REVIEW_TEXT_TEXT, reviewText);
	}
}
