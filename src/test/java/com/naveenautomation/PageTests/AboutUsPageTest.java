package com.naveenautomation.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AboutUsPage;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.LoginPage;

public class AboutUsPageTest extends TestBase {

	LoginPage loginPage;
	AccountPage accountPage;
	AboutUsPage aboutUsPage;

	@BeforeMethod
	public void launch() {
		initalize();
		loginPage = new LoginPage();
	}

	@Test
	public void validateAboutUsPageHeading() {
		accountPage = loginPage.submitLogin("andy123@mailinator.com", "Password@123");
		aboutUsPage = loginPage.clickAboutUsPage();
		Assert.assertEquals(aboutUsPage.getAboutUsText(), "About Us", "naveen");

	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
