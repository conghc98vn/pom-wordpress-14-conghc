package com.wordpress.posts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.GlobalConstans;
import commons.PageGenenratorManagerWordPress;
import pageObjects.wordpress.admin.DashboardPageObject;
import pageObjects.wordpress.admin.LoginPageObject;
import pageObjects.wordpress.admin.NewEditPostPageObject;
import pageObjects.wordpress.admin.PostsPageObject;
import pageObjects.wordpress.user.HomePageObject;
import pageObjects.wordpress.user.PostDetailPageObject;
import pageObjects.wordpress.user.SearchResultPageObject;

public class Admin_01_Create_View_Edit_Delete extends AbstractTest {

	String featureImageName = "android.jpg";
	String today = getWordpressToday();
	int fakeNumber = randomNumber();
	String authorName = "Automation FC";
	String newPostTitle = "CC NEW POST TITLE " + fakeNumber;
	String newPostContent = "CC NEW POST CONTENT " + fakeNumber;
	String newPostTag = "cc_new_post_" + fakeNumber;
	String newPostCheckbox = "NEW LIVE CODING";
	
	@Parameters("browser")
	@BeforeTest
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		log.info("Pre-condition - STEP 01: Open Login page");
		loginAdminPage = PageGenenratorManagerWordPress.getLoginAdminPage(driver);

		log.info("Pre-condition - STEP 02: Input to 'Email' textbox");
		loginAdminPage.inputToEmailTextbox(GlobalConstans.USER_NAME);

		log.info("Pro-condition - STEP 03: Click to 'Continue' button");
		loginAdminPage.clickToContinueOrLoginButton();

		log.info("Pre-condition - STEP 04: Input to 'Password' textbox");
		loginAdminPage.inputToPasswordTextbox(GlobalConstans.PASSWORD);

		log.info("Pre-condition - STEP 05: Click to 'Login' button");
		dashboardAdminPage = loginAdminPage.clickToContinueOrLoginButton();

		log.info("Pre-condition - STEP 06: Verify header text is displayed");
		Assert.assertTrue(dashboardAdminPage.isHeaderTextDisplayed());
	}

	@Test
	public void Post_01_Create_New_Post_At_Admin_Page() {
		// New Post
		dashboardAdminPage.openMenuPageByName(driver, "Posts");
		postsAdminPage = PageGenenratorManagerWordPress.getPostsAdminPage(driver);

		newEditPostAdminPage = postsAdminPage.clickToAddNewButton();

		newEditPostAdminPage.inputToTitleTextbox(newPostTitle);

		newEditPostAdminPage.inputToPostContentTextbox(newPostContent);
 
		newEditPostAdminPage.selectCategoryCheckbox(newPostCheckbox);

		newEditPostAdminPage.inputToTagTextbox(newPostTag);

		newEditPostAdminPage.clickToAddTagButton();

		newEditPostAdminPage.clickToSetFeatureImageLink();
		
		newEditPostAdminPage.clickToUploadFilesTab();

		newEditPostAdminPage.uploadMultipleFiles(driver, featureImageName);

//		verifyTrue(newEditPostAdminPage.areFileUploadedDisplay(driver, "featureImageName"));

		newEditPostAdminPage.clickToSetFeatureImageButton();
		
//		verifyTrue(newEditPostAdminPage.isFeaureImageImageDisplayed("featureImageName"));

		newEditPostAdminPage.clickToPublishButton();

		verifyTrue(newEditPostAdminPage.isSuccessMessageDisplayWithTextValue(driver, "Post published. "));

		// Search_Post_At_Admin_Page
		newEditPostAdminPage.openMenuPageByName(driver, "Posts");
		postsAdminPage = PageGenenratorManagerWordPress.getPostsAdminPage(driver);

		postsAdminPage.inputToSearchTextbox(newPostTitle);

		postsAdminPage.clickToSearchPostButton();
//
		verifyTrue(postsAdminPage.isOnlyOnceRowDisplayed(driver, "Title", newPostTitle));
		verifyTrue(postsAdminPage.isOnlyOnceRowDisplayed(driver, "Author", authorName));
		verifyTrue(postsAdminPage.isOnlyOnceRowDisplayed(driver, "Categories", newPostCheckbox));
		verifyTrue(postsAdminPage.isOnlyOnceRowDisplayed(driver, "Tags", newPostTag));


		// Navigate to EndUserPage
		homeUserPage = postsAdminPage.openEndUserPage(driver);

		// Design in AsbtractPage(Reuse at SearchResultPage)
		verifyTrue(homeUserPage.isNewPostDisplayedLatestPost(driver, newPostCheckbox, newPostTitle, today));
//		verifyTrue(homeUserPage.isPostImageDisplayedAtPostTitleName(driver, "title", "android.jpg"));

//		// Go_Post_Detail_At_User_Page
//		postDetailUserPage = homeUserPage.clickToPostDetailWithTitleName("title");
//
//		verifyTrue(postDetailUserPage.isCategoryNameDisplayed("category"));
//		verifyTrue(postDetailUserPage.isTitleNameDisplayed("title"));
//		verifyTrue(postDetailUserPage.isImageNameDisplayed("android.jpg"));
//		verifyTrue(postDetailUserPage.isContentNameDisplayed("content"));
//		verifyTrue(postDetailUserPage.isDateCreateDisplayed("date create"));
//		verifyTrue(postDetailUserPage.isAuthorDisplayed("author"));
//
//		// Search_Post_At_User_Page
//		searchResultUserPage = postDetailUserPage.inputToSearchTextboxAtEndUserPage(driver, "");
//
//		verifyTrue(searchResultUserPage.isNewPostDisplayedLatestPost("category", "title", "date create"));
//		verifyTrue(searchResultUserPage.isPostImageDisplayedAtPostTitleName("title", "android.jpg"));

	}

//	@Test
//	public void Post_02_Edit_Post_At_Admin_Page() {
//		// Navigate to Admin site
//		dashboardAdminPage = searchResultUserPage.openAdminLoggedPage(driver);
//
//		dashboardAdminPage.openMenuPageByName(driver, "Posts");
//		postsAdminPage = PageGenenratorManagerWordPress.getPostsAdminPage(driver);
//
//		// Search_Post_At_Admin_Page
//		postsAdminPage.inputToSearchTextbox("");
//
//		postsAdminPage.clickToSearchPostButton();
//
//		verifyTrue(postsAdminPage.isOnlyOnceRowDisplayed("title", "author", "category", "tag"));
//
//		// Click to Post
//		newEditPostAdminPage = postsAdminPage.clickToPostDetailByTitleName("title");
//
//		// Edit Post
//		newEditPostAdminPage.inputToTitleTextbox("");
//
//		newEditPostAdminPage.inputToPostContentTextbox("");
//
//		newEditPostAdminPage.deSelectCategoryCheckbox("NEW LIVE CODING");
//
//		newEditPostAdminPage.selectCategoryCheckbox("EDIT LIVE CODING");
//
//		newEditPostAdminPage.inputToTagTextbox("tag_edit_name");
//
//		newEditPostAdminPage.clickToAddTagButton();
//
//		newEditPostAdminPage.clickToDeleteTagIconWithTagName("tag_new_name");
//
//		newEditPostAdminPage.clickToUpdateButton();
//
//		verifyTrue(newEditPostAdminPage.isSuccessMessageDisplayWithTextValue(driver, "Post updated. "));
//
//		// Search_Post_At_Admin_Page
//		newEditPostAdminPage.openMenuPageByName(driver, "Posts");
//		postsAdminPage = PageGenenratorManagerWordPress.getPostsAdminPage(driver);
//
//		postsAdminPage.inputToSearchTextbox("");
//
//		postsAdminPage.clickToSearchPostButton();
//
//		verifyTrue(postsAdminPage.isOnlyOnceRowDisplayed("edit_title", "author", "category", "tag_edit_name"));
//
//		// Navigate to EndUserPage
//		homeUserPage = postsAdminPage.openEndUserPage(driver);
//
//		// Design in AsbtractPage(Reuse at SearchResultPage)
//		verifyTrue(homeUserPage.isNewPostDisplayedLatestPost("edit_category", "edit_title", "date create"));
//		verifyTrue(homeUserPage.isPostImageDisplayedAtPostTitleName("edit_title", "android.jpg"));
//
//		// Go_Post_Detail_At_User_Page
//		postDetailUserPage = homeUserPage.clickToPostDetailWithTitleName("edit_title");
//
//		verifyTrue(postDetailUserPage.isCategoryNameDisplayed("edit_category"));
//		verifyTrue(postDetailUserPage.isTitleNameDisplayed("edit_title"));
//		verifyTrue(postDetailUserPage.isImageNameDisplayed("android.jpg"));
//		verifyTrue(postDetailUserPage.isContentNameDisplayed("edit_content"));
//		verifyTrue(postDetailUserPage.isDateCreateDisplayed("date create"));
//		verifyTrue(postDetailUserPage.isAuthorDisplayed("author"));
//
//		// Search_Post_At_User_Page
//		searchResultUserPage = postDetailUserPage.inputToSearchTextboxAtEndUserPage(driver, "");
//
//		verifyTrue(searchResultUserPage.isNewPostDisplayedLatestPost("edit_category", "edit_title", "date create"));
//		verifyTrue(searchResultUserPage.isPostImageDisplayedAtPostTitleName("edit_title", "android.jpg"));
//
//	}

//	@Test
//	public void Post_03_Delete_Post_At_Admin_Page() {
//		// Navigate to Admin site
//		dashboardAdminPage = searchResultUserPage.openAdminLoggedPage(driver);
//
//		dashboardAdminPage.openMenuPageByName(driver, "Posts");
//		postsAdminPage = PageGenenratorManagerWordPress.getPostsAdminPage(driver);
//
//		// Search_Post_At_Admin_Page
//		postsAdminPage.inputToSearchTextbox("edit_title");
//
//		postsAdminPage.clickToSearchPostButton();
//
//		verifyTrue(postsAdminPage.isOnlyOnceRowDisplayed("edit_title", "author", "edit_category", "tag_edit_name"));
//
//		// Click to Post detail
//		newEditPostAdminPage = postsAdminPage.clickToPostDetailByTitleName("edit_title");
//
//		postsAdminPage = newEditPostAdminPage.clickToMoveToTrashButton();
//
//		verifyTrue(newEditPostAdminPage.isSuccessMessageDisplayWithTextValue(driver, "1 post moved to the Trash. "));
//
//		// Search_Post_At_Admin_Page
//		postsAdminPage.inputToSearchTextbox("edit_title");
//
//		postsAdminPage.clickToSearchPostButton();
//		// check undisplay
//		verifyFalse(postsAdminPage.isOnlyOnceRowDisplayed("edit_title", "author", "edit_category", "tag_edit_name"));
//		// displayed
//		verifyTrue(postsAdminPage.isNoPostFoundMessageDisplayed("No posts found."));
//
//		// Navigate to EndUserPage
//		homeUserPage = postsAdminPage.openEndUserPage(driver);
//
//		verifyFalse(homeUserPage.isNewPostDisplayedLatestPost("edit_category", "edit_title", "date create"));
//		verifyFalse(homeUserPage.isPostImageDisplayedAtPostTitleName("edit_title", "android.jpg"));
//		
//		// Search_Post_At_User_Page
//		searchResultUserPage = homeUserPage.inputToSearchTextboxAtEndUserPage(driver, "");
//
//		verifyFalse(searchResultUserPage.isNewPostDisplayedLatestPost("edit_category", "edit_title", "date create"));
//		verifyFalse(searchResultUserPage.isPostImageDisplayedAtPostTitleName("edit_title", "android.jpg"));
//	}

	@AfterClass
	public void afterClass() {
		log.info("Post-Condition - Close browser");
//		closeBrowserAndDriver(driver);
	}

	WebDriver driver;
	LoginPageObject loginAdminPage;
	DashboardPageObject dashboardAdminPage;
	PostsPageObject postsAdminPage;
	NewEditPostPageObject newEditPostAdminPage;
	HomePageObject homeUserPage;
	PostDetailPageObject postDetailUserPage;
	SearchResultPageObject searchResultUserPage;
}
