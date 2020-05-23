package browserFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import commons.GlobalConstans;

public abstract class DriverManager {
	protected WebDriver driver;
	
	protected abstract void createDriver();
	
	public void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
	
	public WebDriver getDriver() {
		if (driver == null) {
			createDriver();
		}
		driver.get(GlobalConstans.WORDPRESS_URL);
		
		driver.manage().timeouts().implicitlyWait(GlobalConstans.LONG_TIMEOUT, TimeUnit.SECONDS);
		return driver;
	}
}
