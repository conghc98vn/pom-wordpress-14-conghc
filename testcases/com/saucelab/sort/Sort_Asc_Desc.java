package com.saucelab.sort;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObject.jquery.DataTablePageObject;
import pageObjects.saucelab.SortPageObject;

public class Sort_Asc_Desc extends AbstractTest {
	WebDriver driver;
	DataTablePageObject dataTablePage;
	SortPageObject sortPage;

	@Parameters({ "browser", "url" })
	@BeforeTest
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		sortPage = new SortPageObject(driver);
	}

	@Test
	public void TC_01_Sort_Name() {
		sortPage.selectItemInSortDropdown("Name (A to Z)");

		verifyTrue(sortPage.isNameSortAscending());

		sortPage.selectItemInSortDropdown("Name (Z to A)");

		verifyTrue(sortPage.isNameSortDescending());
	}

	@Test
	public void TC_02_Sort_Price() {
		sortPage.selectItemInSortDropdown("Price (low to high)");

		verifyTrue(sortPage.isPriceSortAscending());

		sortPage.selectItemInSortDropdown("Price (high to low)");

		verifyTrue(sortPage.isPriceSortDescending());
	}

	@AfterTest
	public void afterClass() {
//		closeBrowserAndDriver(driver);
	}

}
