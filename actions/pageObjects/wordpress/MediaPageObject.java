package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class MediaPageObject extends AbstractPage {
	WebDriver driver;

	public MediaPageObject(WebDriver driver) {
		this.driver = driver;
		System.out.println("Driver at Media Page = " + driver.toString());
	}

	public void clickToAddNewButton() {
		// TODO Auto-generated method stub
		
	}

	public void uploadMultipleFiles(WebDriver driver2, String ieName, String iosName, String safariName) {
		// TODO Auto-generated method stub
		
	}
}
