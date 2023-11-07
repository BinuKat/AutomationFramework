package com.naveenautomation.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.ForgottenPasswordPage;
import com.naveenautomation.pages.LoginPage;

public class ForgottenPasswordPageTest extends TestBase {

	LoginPage loginPage;
	ForgottenPasswordPage forgottenPasswordPage;

	@BeforeMethod
	public void launch() {
		initalize();
		loginPage = new LoginPage();
	}

	@Test
	public void validateUserNotAbleToResetPasswordWithInValidId() {
		forgottenPasswordPage.clickSubmitBtn("andy@123");
		forgottenPasswordPage = loginPage.clickForgottenBtn();
		Assert.assertEquals(forgottenPasswordPage.notFoundEmailAlertText(),
				"Warning: The E-Mail Address was not found in our records, please try again!)",
				"An email with a confirmation link has been sent your email address.");
	}


	@AfterMethod
	public void quitBrowser() {
		tearDown();

	}
}
