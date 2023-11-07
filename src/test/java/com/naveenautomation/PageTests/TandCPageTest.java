package com.naveenautomation.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.HomePage;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.pages.ProductReturnPage;
import com.naveenautomation.pages.TandCPage;

public class TandCPageTest extends TestBase {

	LoginPage loginPage;
	AccountPage accountPage;
	HomePage homePage;
	ProductReturnPage productReturnPage;
	TandCPage tandCPage;

	@BeforeMethod
	public void launch() {
		initalize();
		homePage = new HomePage();
	}

	@Test
	public void validateThePageHeading() {
		tandCPage = homePage.clickOnTandCPage();
		Assert.assertEquals(tandCPage.getTandCText(), "Terms & Conditions", "naveen");

	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
