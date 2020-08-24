package commons;

public class AbstractPageUI {
	// Wordpress
	public static final String POSTS_LINK = "//div[@class='wp-menu-name' and text()='Posts']";
	public static final String MEDIA_LINK = "//div[@class='wp-menu-name' and text()='Media']";
	public static final String PAGES_LINK = "//div[@class='wp-menu-name' and text()='Pages']";
	public static final String DYNAMIC_SUCCESS_MESSAGE_ON_POST_OR_PAGE_PAGE = "//div[@id='message']/p[contains(., '%s')]";
	public static final String DYNAMIC_ROW_VALUE_AT_COLUMN_NAME = "//td[@data-colname='%s']//a[text()='%s']";
	public static final String DYNAMIC_POST_WITH_CATEGORY_TITLE_DATE = "//p[@class='post-categories']/a[text()='%s']/parent::p/following-sibling::h2[@class='post-title']/a[text()='%s']/parent::h2/following-sibling::p[@class='post-meta']/a[text()='%s']";
	public static final String DYNAMIC_POST_AVATAR_IMAGE_BY_TITLE = "//a[@title='%s']/img[contains(@src, '%s')]";
	public static final String DYNAMIC_POST_TITLE = "//h2[@class='post-title']/a[text()='%s']";
	public static final String SEARCH_ICON = "//a[@class='search-toggle']";
	public static final String SEARCH_TEXTBOX = "//input[@class='search-field']";
	public static final String INPUT_SEARCH_ICON_BUTTON = "//span[@class='fa fw fa-search']";
	
	
	// Dynamic Locator - WordPress
	public static final String DYNAMIC_PAGE_LINK = "//div[@class='wp-menu-name' and text()='%s']";
	public static final String UPLOAD_FILE_TYPE = "//input[@type='file']";
	public static final String MEDIA_INPROGRESS_BAR_ICON = "//div[@class='thumbnail']/div[@class='media-process-bar']";
	public static final String ALL_UPLOAD_IMAGE = "//div[@class='thumbnail']//img";

	// BankGuru
	public static final String NEWCUSTOMER_LINK = "//li/a[text()='New Customer']";
	public static final String DEPOSIT_LINK = "//li/a[text()='Deposit']";
	public static final String NEWACCOUNT_LINK = "//li/a[text()='New Account']";
	public static final String HOMEPAGE_LINK_BGR = "//a[text()='Manager']";
	public static final String WITHDRAWAL_LINK = "//li/a[text()='Withdrawal']";

	// Nop-Commerce
	public static final String FOOTER_MY_ACCOUNT_LINK = "//li/a[text()='My account']";
	public static final String HEADER_WISHLIST = "";
	public static final String HOMEPAGE_LINK_NOP = "";
	public static final String SEARCH_LINK = "";
	public static final String SHIPPING_AND_RETURN_LINK = "";
	public static final String SIMEMAP_LINK = "";
	public static final String LOGIN_BUTTON_NOP = "//a[@class='ico-login']";
	public static final String MYACCOUNT_BUTTON_NOP = "//a[@class='ico-account']";
}
