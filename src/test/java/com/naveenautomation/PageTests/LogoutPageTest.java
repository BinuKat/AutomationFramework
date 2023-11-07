package com.naveenautomation.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.pages.LogoutPage;
import com.naveenautomation.pages.SideNavBar;

public class LogoutPageTest extends TestBase {
	LoginPage loginPage;
	AccountPage accountPage;
	LogoutPage logoutPage; // defined here because need to be used throughout

	@BeforeMethod
	public void launch() {
		initalize();
		loginPage = new LoginPage();

	}

	@Test
	public void validateIfLogoutdoneSuccessfully() {
		accountPage = loginPage.submitLogin("andy123@mailinator.com", "Password@123");
		logoutPage = accountPage.selectLogoutOption();
		Assert.assertEquals(logoutPage.getLogoutAlertText(), "Account Logout", "My Account");

	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}
}
