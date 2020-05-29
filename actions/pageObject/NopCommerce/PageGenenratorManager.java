package pageObject.NopCommerce;
import org.openqa.selenium.WebDriver;

public class PageGenenratorManager {
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
}
