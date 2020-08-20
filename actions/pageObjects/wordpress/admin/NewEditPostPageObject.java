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
		waitForElementClickable(driver, NewEditPostPageUI.PUBLISH_BUTTON);
//		clickToElement(driver, NewEditPostPageUI.PUBLISH_BUTTON);
		clickToElementByJS(driver, NewEditPostPageUI.PUBLISH_BUTTON);
	}

	public void inputToTitleTextbox(String titleValue) {
		waitForElementVissible(driver, NewEditPostPageUI.ADD_TITLE_TEXTBOX);
		sendkeyToElement(driver, NewEditPostPageUI.ADD_TITLE_TEXTBOX, titleValue);

	}

	public void selectCategoryCheckbox(String checkboxLableText) {
		waitForElementClickable(driver, NewEditPostPageUI.CATEGORY_CHECKBOX, checkboxLableText);
		scrollToElement(driver, NewEditPostPageUI.CATEGORY_CHECKBOX, checkboxLableText);
		clickToElement(driver, NewEditPostPageUI.CATEGORY_CHECKBOX, checkboxLableText);
	}

	public void inputToTagTextbox(String tagValue) {
		waitForElementVissible(driver, NewEditPostPageUI.TAG_TEXTBOX);
		sendkeyToElement(driver, NewEditPostPageUI.TAG_TEXTBOX, tagValue);
	}

	public void clickToAddTagButton() {
		waitForElementVissible(driver, NewEditPostPageUI.ADD_TAG_BUTTON);
		clickToElement(driver, NewEditPostPageUI.ADD_TAG_BUTTON);
	}

	public void clickToSetFeatureImageLink() {
		waitForElementVissible(driver, NewEditPostPageUI.SET_FUTURE_IMAGE_LINK);
		clickToElement(driver, NewEditPostPageUI.SET_FUTURE_IMAGE_LINK);

	}

	public void clickToUploadFilesTab() {
		waitForElementVissible(driver, NewEditPostPageUI.UPLOAD_FILE_TAB_BUTTON);
		clickToElement(driver, NewEditPostPageUI.UPLOAD_FILE_TAB_BUTTON);
	}

	public void clickToSetFeatureImageButton() {
		waitForElementClickable(driver, NewEditPostPageUI.SET_FUTURE_IMAGE_BUTTON);
		clickToElement(driver, NewEditPostPageUI.SET_FUTURE_IMAGE_BUTTON);
	}

	public boolean isFeaureImageImageDisplayed(String imageName) {
		String[] files = imageName.split("\\.");
		waitForElementVissible(driver, NewEditPostPageUI.FEATURE_IMAGE_THUMBNAIL, files);
		return isElementDisplay(driver, NewEditPostPageUI.FEATURE_IMAGE_THUMBNAIL, files);
	}

	public void deSelectCategoryCheckbox(String string) {
		// TODO Auto-generated method stub

	}

	public void clickToDeleteTagIconWithTagName(String string) {
		// TODO Auto-generated method stub

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

}
