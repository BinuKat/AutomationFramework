package com.naveenautomation.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.EditPage;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.pages.NewsletterSubscriptionPage;
import com.naveenautomation.pages.ProductReturnPage;

public class ProductReturnPageTest extends TestBase {

	LoginPage loginPage;
	AccountPage accountPage;
	ProductReturnPage productReturnPage;

	@BeforeMethod
	public void launch() {
		initalize();
		loginPage = new LoginPage();

	}

	@Test
	public void validateIfUserisAbleToReturn() {
		accountPage = loginPage.submitLogin("andy123@mailinator.com", "Password@123");
		productReturnPage = accountPage.getReturnOptionLink();
		Assert.assertEquals(productReturnPage.getReturnOptionText(), "Product Returns", "List of Items are as below");

	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}
}
