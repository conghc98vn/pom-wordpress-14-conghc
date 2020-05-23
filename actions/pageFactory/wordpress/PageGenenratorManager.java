package pageFactory.wordpress;
import org.openqa.selenium.WebDriver;

public class PageGenenratorManager {
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static DashboardPageObject getDashboardPage(WebDriver driver) {
		return new DashboardPageObject(driver);
	}
}
