package com.jquery.datatable;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
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

	@Test
	public void TC_01_Input_To_Column_By_Name() {
		// Action
		dataTablePage.inputToColumnByName("Country", "Argentina");
		// Verify
		Assert.assertTrue(dataTablePage.isOnlyRowDisplayed("Argentina"));

		dataTablePage.refresh(driver);

		dataTablePage.inputToColumnByName("Total", "49397");
		Assert.assertTrue(dataTablePage.isOnlyRowDisplayed("49397"));

	}

	@Test
	public void TC_02_Edit_Delete_To_Column_By_Country_Name() {

	}

	@Test
	public void TC_03_Paging_By_Page_Index() {

	}

	@AfterTest
	public void afterClass() {
//		driver.quit();
	}

}
