package pageUI.NopCommerce;

public class MyAccountPageUI{
	public static final String GENDER_RADIO_BUTTON = "//input[@id='gender-%s']";
	public static final String FIRST_NAME_TEXTBOX = "//input[@id='FirstName']";
	public static final String LAST_NAME_TEXTBOX = "//input[@id='LastName']";
	public static final String DAY_DROPDOWN = "//select[@name='DateOfBirthDay']";
	public static final String MONTH_DROPDOWN = "//select[@name='DateOfBirthMonth']";
	public static final String YEAR_DROPDOWN = "//select[@name='DateOfBirthYear']";
	public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
	public static final String COMPANY_NAME_TEXTBOX = "//input[@id='Company']";
	public static final String SAVE_BUTTON = "//input[@id='save-info-button']";
	public static final String DAY_DROPDOWN_TEXT = "//select[@name='DateOfBirthDay']/option[@selected]";
	public static final String MONTH_DROPDOWN_TEXT = "//select[@name='DateOfBirthMonth']/option[@selected]";
	public static final String YEAR_DROPDOWN_TEXT = "//select[@name='DateOfBirthYear']/option[@selected]";
	
	//Address
	public static final String ADDRESSES_BUTTON = "//li[contains(@class, 'active')]/a[@href='/customer/addresses']";
	public static final String ADD_NEW_ADDRESSES_BUTTON = "//div[@class='add-button']/input";
	public static final String FIRST_NAME_ADDRESS_TEXTBOX = "//input[@id='Address_FirstName']";
	public static final String LAST_NAME_ADDRESS_TEXTBOX = "//input[@id='Address_LastName']";
	public static final String EMAIL_ADDRESS_TEXTBOX = "//input[@id='Address_Email']";
	public static final String COMPANY_ADDRESS_TEXTBOX = "//input[@id='Address_Company']";
	public static final String COUNTRY_ADDRESS_DROPDOWN = "//select[@id='Address_CountryId']";
	public static final String STATE_PROVINCE_ADDRESS_DROPDOWN = "//select[@id='Address_StateProvinceId']";
	public static final String CITY_ADDRESS_TEXTBOX = "//input[@id='Address_City']";
	public static final String ADDRESS_1_TEXTBOX = "//input[@id='Address_Address1']";
	public static final String ADDRESS_2_TEXTBOX = "//input[@id='Address_Address2']";
	public static final String ZIP_POSTAL_CODE_ADDRESS_TEXTBOX = "//input[@id='Address_ZipPostalCode']";
	public static final String PHONE_NUMBER_ADDRESS_TEXTBOX = "//input[@id='Address_PhoneNumber']";
	public static final String FAX_NUMBER_ADDRESS_TEXTBOX = "//input[@id='Address_FaxNumber']";
	public static final String SAVE_ADDRESS_BUTTON = "//input[@class='button-1 save-address-button']";
	
	public static final String FULL_NAME_ADDRESS_TEXT = "//li[@class='name']";
	public static final String EMAIL_ADDRESS_TEXT = "//li[@class='email']";
	public static final String PHONE_NUMBER_ADDRESS_TEXT = "//li[@class='phone']";
	public static final String FAX_NUMBER_ADDRESS_TEXT = "//li[@class='fax']";
	public static final String COMPANY_ADDRESS_TEXT = "//li[@class='company']";
	public static final String ADDRESS_1_TEXT = "//li[@class='address1']";
	public static final String ADDRESS_2_TEXT = "//li[@class='address2']";
	public static final String CITY_AND_ZIP_POSTAL_CODE_ADDRESS_TEXT = "//li[@class='city-state-zip']";
	public static final String COUNTRY_ADDRESS_TEXT = "//li[@class='country']";
}
