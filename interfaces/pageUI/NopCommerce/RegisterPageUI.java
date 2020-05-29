package pageUI.NopCommerce;

public class RegisterPageUI {
	public static final String REGISTER_BUTTON = "//input[@id='register-button']";
	public static final String CHOOSEGENDERBUTTON = "//label[text()='Male']/preceding-sibling::input";
	public static final String FIRSTNAME_TEXTBOX = "//input[@id='FirstName']";
	public static final String LASTNAME_TEXTBOX = "//input[@id='LastName']";
	public static final String SELECT_DAY_DROPDOWN = "//select[@name='DateOfBirthDay']";
	public static final String SELECT_MONTH_DROPDOWN = "//select[@name='DateOfBirthMonth']";
	public static final String SELECT_YEAR_DROPDOWN = "//select[@name='DateOfBirthYear']";
	public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
	public static final String COMPANY_NAME_TEXTBOX = "//input[@id='Company']";
	public static final String NEWSELETTER_OPTIONS_BUTTON = "//input[@id='Newsletter']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='Password']";
	public static final String PASSWORD_CONFIRM_TEXTBOX = "//input[@id='ConfirmPassword']";
	public static final String FIRSTNAME_ERROR_MESSAGE_TEXT = "//span[@id='FirstName-error']";
	public static final String LASTNAME_ERROR_MESSAGE_TEXT = "//span[@id='LastName-error']";
	public static final String EMAIL_ERROR_MESSAGE_TEXT = "//span[@id='Email-error']";
	public static final String PASSWORD_ERROR_MESSAGE_TEXT = "//span[@id='Password-error']";
	public static final String CONFIRM_PASSWORD_ERROR_MESSAGE_TEXT = "//span[@id='ConfirmPassword-error']";
	public static final String EMAIL_EXISTS_ERROR_MESSAGE_TEXT = "//div[@class='message-error validation-summary-errors']//li";
	public static final String MESSAGE_REGISTER_SUCCESS_TEXT = "//div[@class='result']";
}
