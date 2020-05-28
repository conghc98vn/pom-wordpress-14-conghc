package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.NopCommerce.FooterMyAccountPageObject;
import pageObject.NopCommerce.HeaderWishlistPageObject;
import pageObject.NopCommerce.SearchPageObject;
import pageObject.NopCommerce.ShippingAndReturnPageObject;
import pageObject.NopCommerce.SitemapPageObject;
import pageObjects.bankGuru.DepositPageObject;
import pageObjects.bankGuru.HomePageObject;
import pageObjects.bankGuru.NewAccountPageObject;
import pageObjects.bankGuru.NewCustomerPageObject;
import pageObjects.bankGuru.WithdrawalPageObject;
import pageObjects.wordpress.MediaPageObject;
import pageObjects.wordpress.PageGenenratorManager;
import pageObjects.wordpress.PagesPageObject;
import pageObjects.wordpress.PostsPageObject;

//public abstract class AbstractPage {
public class AbstractPage {
	public void sleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void openUrl(WebDriver driver, String urlValue) {
		driver.get(urlValue);
	}

	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void back(WebDriver driver) {
		driver.navigate().back();
	}

	public void forward(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void sendkeyToAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void waitAlertPresence(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstans.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void switchTWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();

		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			driver.switchTo().window(runWindow);
			String curentTitle = driver.getTitle();
			if (curentTitle.equals(title)) {
				break;
			}
		}
	}

	public boolean areAllWindowClosedWithoutParent(WebDriver driver, String parentWindow) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentWindow)) {
				driver.switchTo().window(runWindow);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		if (driver.getWindowHandles().size() == 1) {
			return true;
		} else
			return false;

	}

	private By byXpath(String locator) {
		return By.xpath(locator);
	}

	private WebElement findElementByXpath(WebDriver driver, String locator) {
		return driver.findElement(By.xpath(locator));
	}

	private List<WebElement> findElementsByXpath(WebDriver driver, String locator) {
		return driver.findElements(By.xpath(locator));
	}

	public String castToObject(String locator, String...values) {
		return String.format(locator, (Object[]) values);
	}

	public void clickToElement(WebDriver driver, String locator) {
		findElementByXpath(driver, locator).click();
	}

	public void clickToElement(WebDriver driver, String locator, String values) {
		findElementByXpath(driver, castToObject(locator, values)).click();
	}

	public void sendkeyToElement(WebDriver driver, String locator, String value) {
		element = findElementByXpath(driver, locator);
		element.clear();
		element.sendKeys(value);
	}
	
	public void sendkeyToElement(WebDriver driver, String locator, String value, String...values) {
		element = findElementByXpath(driver, castToObject(locator, values));
		element.clear();
		element.sendKeys(value);
	}

	public String getElementText(WebDriver driver, String locator) {
		return findElementByXpath(driver, locator).getText();
	}

	public String getElementAttribute(WebDriver driver, String locator, String attributeName) {
		return findElementByXpath(driver, locator).getAttribute(attributeName);
	}

	public void selectValueInDropdown(WebDriver driver, String locator, String value) {
		select = new Select(findElementByXpath(driver, locator));
		select.selectByVisibleText(value);
	}

	public String getSelectItemInDropdown(WebDriver driver, String locator) {
		select = new Select(findElementByXpath(driver, locator));
		return select.getFirstSelectedOption().getText();
	}

	public void selectItemInDropdown(WebDriver driver, String parentXpath, String allItemXpath, String expectedItem) {
		element = findElementByXpath(driver, parentXpath);

		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", element);
		sleepInSecond(1);

		explicitWait = new WebDriverWait(driver, GlobalConstans.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byXpath(allItemXpath)));
		elements = findElementsByXpath(driver, allItemXpath);

		for (WebElement childElement : elements) {
			if (childElement.getText().equals(expectedItem)) {
				if (childElement.isDisplayed()) {
					childElement.click();
				} else {
					jsExecutor.executeScript("arguments[0].scrollIntoView(true);", childElement);
					sleepInSecond(1);
					jsExecutor.executeScript("arguments[0].click();", childElement);
				}
				sleepInSecond(1);
				break;
			}
		}
	}

	public int countElementNumber(WebDriver driver, String locator) {
		elements = findElementsByXpath(driver, locator);
		return elements.size();
	}
	
	public int countElementNumber(WebDriver driver, String locator, String... values) {
		elements = findElementsByXpath(driver, castToObject(locator, values));
		return elements.size();
	}

	public void checkToCheckbox(WebDriver driver, String locator) {
		element = findElementByXpath(driver, locator);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void unCheckToCheckbox(WebDriver driver, String locator) {
		element = findElementByXpath(driver, locator);
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplay(WebDriver driver, String locator) {
		return findElementByXpath(driver, locator).isDisplayed();
	}

	public boolean isElementDisplay(WebDriver driver, String locator, String... values) {
		return findElementByXpath(driver, castToObject(locator, values)).isDisplayed();
	}

	public boolean isElementEnabled(WebDriver driver, String locator) {
		return findElementByXpath(driver, locator).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver, String locator) {
		return findElementByXpath(driver, locator).isSelected();
	}

	public void switchToFrameOrIframe(WebDriver driver, String locator) {
		driver.switchTo().frame(findElementByXpath(driver, locator));
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void hoverMouseToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.moveToElement(findElementByXpath(driver, locator));
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.doubleClick(findElementByXpath(driver, locator));
	}

	public void rightClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.contextClick(findElementByXpath(driver, locator));
	}

	public void sendKeyboardToElement(WebDriver driver, String locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(findElementByXpath(driver, locator), key).perform();
	}

	public void sendKeyboardToElement(WebDriver driver, String locator, Keys key, String...values) {
		action = new Actions(driver);
		action.sendKeys(findElementByXpath(driver, castToObject(locator, values)), key).perform();
	}
	
	public Object executeForBrowser(WebDriver driver, String javaSript) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaSript);
	}

	public boolean verifyTextInInnerText(WebDriver driver, String textExpected) {
		jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		element = findElementByXpath(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 5px solid red; border-style: dashed;");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);

	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", findElementByXpath(driver, locator));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", findElementByXpath(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')",
				findElementByXpath(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				findElementByXpath(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor
				.executeScript(
						"return argument[0].complete && typeof arguments[0]"
								+ ".naturalWith != 'undefined' && arguments[0]" + ".naturalWith > 0",
						findElementByXpath(driver, locator));
		if (status) {
			return true;
		}
		return false;
	}

	public void waitForElementVissible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstans.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(locator)));
	}

	public void waitForElementVissible(WebDriver driver, String locator, String...values) {
		explicitWait = new WebDriverWait(driver, GlobalConstans.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(castToObject(locator, values))));
	}

	public void waitForElementInvissible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstans.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(byXpath(locator)));
	}

	public void waitForElementClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstans.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(byXpath(locator)));
	}

	public void waitForElementClickable(WebDriver driver, String locator, String... values) {
		explicitWait = new WebDriverWait(driver, GlobalConstans.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(byXpath(castToObject(locator, values))));
	}

	// Dynamic locator WordPress (Apply cho ít page 10-15-20)
	public AbstractPage clickToLessDynamicPageMenu(WebDriver driver, String pageName) {
		waitForElementVissible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, pageName);
		
		if (pageName.equals("Posts")) {
			return PageGenenratorManager.getPostsPage(driver);
		} else if (pageName.equals("Pages")) {
			return PageGenenratorManager.getPagesPage(driver);
		} else if (pageName.equals("Media")) {
			return PageGenenratorManager.getMediaPage(driver);
		} else {
			return PageGenenratorManager.getDashboardPage(driver);
		}
	}
	
	// Dynamic locator WordPress (Apply cho quá nhiều page)
	public void clickToMoreDynamicPageMenu(WebDriver driver, String pageName) {
		waitForElementVissible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, pageName);
	}

	// Common Page - WordPress

	public MediaPageObject clickToMediaMenu(WebDriver driver) {
		waitForElementVissible(driver, AbstractPageUI.MEDIA_LINK);
		clickToElement(driver, AbstractPageUI.MEDIA_LINK);
		return PageGenenratorManager.getMediaPage(driver);
	}

	public PagesPageObject clickToPagesMenu(WebDriver driver) {
		waitForElementInvissible(driver, AbstractPageUI.PAGES_LINK);
		clickToElement(driver, AbstractPageUI.PAGES_LINK);
		return PageGenenratorManager.getPagesPage(driver);
	}

	public PostsPageObject clickToPostsMenu(WebDriver driver) {
		waitForElementVissible(driver, AbstractPageUI.POSTS_LINK);
		clickToElement(driver, AbstractPageUI.POSTS_LINK);
		return PageGenenratorManager.getPostsPage(driver);
	}

	// Common Page - BankGuru
	public NewCustomerPageObject clickToNewCustomerMenu(WebDriver driver) {
		waitForElementInvissible(driver, AbstractPageUI.NEWCUSTOMER_LINK);
		clickToElement(driver, AbstractPageUI.NEWCUSTOMER_LINK);
		return pageObjects.bankGuru.PageGenenratorManager.getNewCustomerPage(driver);
	}

	public DepositPageObject clickToDepositPageMenu(WebDriver driver) {
		waitForElementInvissible(driver, AbstractPageUI.DEPOSIT_LINK);
		clickToElement(driver, AbstractPageUI.DEPOSIT_LINK);
		return pageObjects.bankGuru.PageGenenratorManager.getDepositPage(driver);
	}

	public HomePageObject clickToHomeMenuBGR(WebDriver driver) {
		waitForElementInvissible(driver, AbstractPageUI.HOMEPAGE_LINK_BGR);
		clickToElement(driver, AbstractPageUI.HOMEPAGE_LINK_BGR);
		return pageObjects.bankGuru.PageGenenratorManager.getHomePage(driver);
	}

	public NewAccountPageObject clickToNewAccontMenu(WebDriver driver) {
		waitForElementInvissible(driver, AbstractPageUI.NEWACCOUNT_LINK);
		clickToElement(driver, AbstractPageUI.NEWACCOUNT_LINK);
		return pageObjects.bankGuru.PageGenenratorManager.getNewAccountPage(driver);
	}

	public WithdrawalPageObject clickToWithdrawalMenu(WebDriver driver) {
		waitForElementInvissible(driver, AbstractPageUI.WITHDRAWAL_LINK);
		clickToElement(driver, AbstractPageUI.WITHDRAWAL_LINK);
		return pageObjects.bankGuru.PageGenenratorManager.getWithdrawalPage(driver);
	}

	// Common Page - NopCommerce

	public FooterMyAccountPageObject clickToFooterMyAccountMenu(WebDriver driver) {
		waitForElementInvissible(driver, AbstractPageUI.FOOTER_MY_ACCOUNT_LINK);
		clickToElement(driver, AbstractPageUI.FOOTER_MY_ACCOUNT_LINK);
		return pageObject.NopCommerce.PageGenenratorManager.getFooterMyAccountPage(driver);
	}

	public HeaderWishlistPageObject clickToHeaderWishlistMenu(WebDriver driver) {
		waitForElementInvissible(driver, AbstractPageUI.HEADER_WISHLIST);
		clickToElement(driver, AbstractPageUI.HEADER_WISHLIST);
		return pageObject.NopCommerce.PageGenenratorManager.getHeaderWishlistPage(driver);
	}

	public pageObject.NopCommerce.HomePageObject clickToHomeMenuNOP(WebDriver driver) {
		waitForElementInvissible(driver, AbstractPageUI.HOMEPAGE_LINK_NOP);
		clickToElement(driver, AbstractPageUI.HOMEPAGE_LINK_NOP);
		return pageObject.NopCommerce.PageGenenratorManager.getHomePage(driver);
	}

	public SearchPageObject clickToSearchMenu(WebDriver driver) {
		waitForElementInvissible(driver, AbstractPageUI.SEARCH_LINK);
		clickToElement(driver, AbstractPageUI.SEARCH_LINK);
		return pageObject.NopCommerce.PageGenenratorManager.getSearchPage(driver);
	}

	public ShippingAndReturnPageObject clickToShippingAndReturnMenu(WebDriver driver) {
		waitForElementInvissible(driver, AbstractPageUI.SHIPPING_AND_RETURN_LINK);
		clickToElement(driver, AbstractPageUI.SHIPPING_AND_RETURN_LINK);
		return pageObject.NopCommerce.PageGenenratorManager.getShippingAndReturnPage(driver);
	}

	public SitemapPageObject clickToSitemapMenu(WebDriver driver) {
		waitForElementInvissible(driver, AbstractPageUI.SIMEMAP_LINK);
		clickToElement(driver, AbstractPageUI.SIMEMAP_LINK);
		return pageObject.NopCommerce.PageGenenratorManager.getSitemapPage(driver);
	}

	private Select select;
	private Actions action;
	private WebElement element;
	private List<WebElement> elements;
	private WebDriverWait explicitWait;
	private JavascriptExecutor jsExecutor;
}
