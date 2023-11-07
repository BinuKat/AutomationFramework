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
import com.naveenautomation.pages.SideNavBar;

public class AccountPageTest extends TestBase {

	LoginPage loginPage;
	AccountPage accountPage;
	EditPage editPage;
	NewsletterSubscriptionPage newsletterSubscriptionPage;

	@BeforeMethod
	public void launch() {
		initalize();
		loginPage = new LoginPage();

	}

	@Test
	public void validateUserCanUpdatePersonalInfo() {
		accountPage = loginPage.submitLogin("andy123@mailinator.com", "Password@123");
		editPage = accountPage.clickEditInfoLink(SideNavBar.EDIT_ACCOUNT);
		editPage.enterFName("Anya");
		accountPage = editPage.clickSubmitBtn();
		Assert.assertEquals(accountPage.getSuccessMessage(), "Success: Your account has been successfully updated.",
				"Info not updated");
	}

	@Test
	public void validateNewsletterSubUpdated() {
		accountPage = loginPage.submitLogin("andy123@mailinator.com", "Password@123");
		newsletterSubscriptionPage = accountPage.clickNewsLetterLink(SideNavBar.NEWSLETTER);
		accountPage = newsletterSubscriptionPage.newsLetterSubClickCtn();
		Assert.assertEquals(accountPage.getSuccessMsgNewsLetter(),
				"Success: Your newsletter subscription has been successfully updated!", "Not Avaialble");

	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();

	}
}
