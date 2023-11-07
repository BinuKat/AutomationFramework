package com.naveenautomation.PageTests;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.ContactUsPage;
import com.naveenautomation.pages.HomePage;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.pages.LogoutPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	AccountPage accountPage;
	ContactUsPage contactUsPage;
	HomePage homePage;
	LogoutPage logoutPage;

	@BeforeMethod
	public void launch() {
		initalize();
		loginPage = new LoginPage();
	}

	@Test
	public void validateAfterLogoutNavToHomePage() {
		accountPage = loginPage.submitLogin("andy123@mailinator.com", "Password@123");
		logoutPage = accountPage.selectLogoutOption();
		homePage = logoutPage.ClickContinueAfterLogout();
		Assert.assertEquals(homePage.getHomePageText(), "Featured", "Logged In");

	}

	@Test
	public void validateIfVisitorGetsNavToHomePageAfterSubmittingContactUsForm() {
		accountPage = loginPage.submitLogin("andy123@mailinator.com", "Password@123");
		contactUsPage = accountPage.getContactOptionLink();
		contactUsPage.submitCtnBtn("Tamy", "", "I would like to learn more about Automation");
		Assert.assertEquals(homePage.getHomePageText(), "Featured", "Still Logged in");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
