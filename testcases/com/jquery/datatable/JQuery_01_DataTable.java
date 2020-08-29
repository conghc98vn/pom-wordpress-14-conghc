package com.jquery.datatable;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObject.jquery.DataTablePageObject;

public class JQuery_01_DataTable extends AbstractTest {
	WebDriver driver;
	DataTablePageObject dataTablePage;

	@Parameters({ "browser", "url" })
	@BeforeTest
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		dataTablePage = new DataTablePageObject(driver);

	}

//	@Test
	public void TC_01_Input_To_Column_By_Name() {
		// Action
		dataTablePage.inputToColumnByName("Country", "Argentina");
		// Verify
		Assert.assertTrue(dataTablePage.isOnlyRowDisplayed("Argentina"));

		dataTablePage.refresh(driver);

		dataTablePage.inputToColumnByName("Total", "49397");
		Assert.assertTrue(dataTablePage.isOnlyRowDisplayed("49397"));

	}

//	@Test
	public void TC_02_Edit_Delete_To_Column_By_Country_Name() {
		dataTablePage.refresh(driver);
		dataTablePage.clickToEditOrDeleteIconByCountry("Afghanistan", "remove");
		dataTablePage.clickToEditOrDeleteIconByCountry("AFRICA", "remove");
		dataTablePage.clickToEditOrDeleteIconByCountry("Algeria", "remove");

		dataTablePage.clickToEditOrDeleteIconByCountry("Argentina", "edit");
	}

//	@Test
	public void TC_03_Paging_By_Page_Index() {
		dataTablePage.refresh(driver);
		
		dataTablePage.navigateToPageNumberByIndex("10");
		Assert.assertTrue(dataTablePage.isPageActiveByIndex("10"));
		
		dataTablePage.navigateToPageNumberByIndex("6");
		Assert.assertTrue(dataTablePage.isPageActiveByIndex("6"));
		
		dataTablePage.navigateToPageNumberByIndex("5");
		Assert.assertTrue(dataTablePage.isPageActiveByIndex("5"));
	}
	
	@Test
	public void TC_04_Dynamic_Row() {
		dataTablePage.openUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		
		//  
		dataTablePage.inputToDynamicTextboxAtRowNumber("Company", "2", "Samsung");
		dataTablePage.inputToDynamicTextboxAtRowNumber("Order Placed", "1", "Ho Chi Minh");
		dataTablePage.inputToDynamicTextboxAtRowNumber("Contact Person", "3", "Nguyen Van Troi");
	}

	@AfterTest
	public void afterClass() {
//		driver.quit();
	}

}
