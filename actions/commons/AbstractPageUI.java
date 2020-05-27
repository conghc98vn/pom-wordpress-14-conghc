package commons;

public class AbstractPageUI {
	// Wordpress
	public static final String POSTS_LINK = "//div[@class='wp-menu-name' and text()='Posts']";
	public static final String MEDIA_LINK = "//div[@class='wp-menu-name' and text()='Media']";
	public static final String PAGES_LINK = "//div[@class='wp-menu-name' and text()='Pages']"; 
	
	// BankGuru
	public static final String NEWCUSTOMER_LINK = "//li/a[text()='New Customer']";
	public static final String DEPOSIT_LINK = "//li/a[text()='Deposit']";
	public static final String NEWACCOUNT_LINK = "//li/a[text()='New Account']";
	public static final String HOMEPAGE_LINK_BGR = "//a[text()='Manager']";
	public static final String WITHDRAWAL_LINK = "//li/a[text()='Withdrawal']";
	
	// Nop-Commerce
	public static final String FOOTER_MY_ACCOUNT_LINK = "//li/a[text()='My account']";
	public static final String HEADER_WISHLIST = "//li/a[text()='Deposit']";
	public static final String HOMEPAGE_LINK_NOP = "//li/a[text()='Deposit']";
	public static final String SEARCH_LINK = "//li/a[text()='Deposit']";
	public static final String SHIPPING_AND_RETURN_LINK = "//li/a[text()='Deposit']";
	public static final String SIMEMAP_LINK = "//li/a[text()='Deposit']";
}
