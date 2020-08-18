package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGenenratorManagerWordPress;
import pageUI.wordpress.admin.NewEditPostPageUI;

public class NewEditPostPageObject extends AbstractPage {
	WebDriver driver;

	public NewEditPostPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToPostContentTextbox(String value) {
		// Switch to iframe
		switchToFrameOrIframe(driver, NewEditPostPageUI.TINY_MCE_IFRAME);
		// Sendkey
		waitForElementsVissible(driver, NewEditPostPageUI.TINY_MCE_TEXTBOX);
		sendkeyToElement(driver, NewEditPostPageUI.TINY_MCE_TEXTBOX, value);
		// Switch to default content
		switchToDefaultContent(driver);
	}

	public void clickToPublishButton() {
		// wait to clickable

		// click to button

		// wait for icon loading invisible

	}

	public void clickToUpdateButton() {
		// wait to clickable

		// click to button

		// wait for icon loading invisible
	}

	public PostsPageObject clickToMoveToTrashButton() {
		// wait to clickable

		// click to button return null;
		return PageGenenratorManagerWordPress.getPostsAdminPage(driver);
	}

	public void inputToTitleTextbox(String titleValue) {
		waitForElementsVissible(driver, NewEditPostPageUI.ADD_TITLE_TEXTBOX);
		sendkeyToElement(driver, NewEditPostPageUI.ADD_TITLE_TEXTBOX, titleValue);
		
	}

	public void selectCategoryCheckbox(String checkboxLableText) {
		waitForElementsClickable(driver, NewEditPostPageUI.CATEGORY_CHECKBOX, checkboxLableText);
		scrollToElement(driver, NewEditPostPageUI.CATEGORY_CHECKBOX, checkboxLableText);
		clickToElement(driver, NewEditPostPageUI.CATEGORY_CHECKBOX, checkboxLableText);
	}

	public void inputToTagTextbox(String tagValue) {
		waitForElementsVissible(driver, NewEditPostPageUI.TAG_TEXTBOX);
		sendkeyToElement(driver, NewEditPostPageUI.TAG_TEXTBOX, tagValue);
	}

	public void clickToAddTagButton() {
		waitForElementsVissible(driver, NewEditPostPageUI.ADD_TAG_BUTTON);
		clickToElement(driver, NewEditPostPageUI.ADD_TAG_BUTTON);
	}

	public void clickToSetFeatureImage() {
		waitForElementsVissible(driver, NewEditPostPageUI.SET_FUTURE_IMAGE_LINK);
		clickToElement(driver, NewEditPostPageUI.SET_FUTURE_IMAGE_LINK);
		
	}

	public void clickToUploadFilesTab() {
		waitForElementsVissible(driver, NewEditPostPageUI.UPLOAD_FILE_TAB_BUTTON);
		clickToElement(driver, NewEditPostPageUI.UPLOAD_FILE_TAB_BUTTON);
	}
	
	public void clickToSetFeatureImageButton() {
		// TODO Auto-generated method stub
		
	}

	public void deSelectCategoryCheckbox(String string) {
		// TODO Auto-generated method stub
		
	}

	public void clickToDeleteTagIconWithTagName(String string) {
		// TODO Auto-generated method stub
		
	}
}
