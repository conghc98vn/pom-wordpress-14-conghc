package pageFactory.bankGuru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//public abstract class AbstractPage {
public class AbstractPage {

	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public void openUrl(WebDriver driver, String urlValue) {
		driver.get(urlValue);
	}
	
	public void sendkeyToElement(WebDriver driver, WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	public String getElementText(WebDriver driver, WebElement element) {
		return element.getText().trim();
	}

	public void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}

	public boolean isElementDisplay(WebDriver driver, WebElement element) {
		return element.isDisplayed();
	}

	public void waitForElementVissible(WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver, longtime);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementClickable(WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver, longtime);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void sleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private int longtime = 30;
	private WebDriverWait explicitWait;
}
