package com.naveenautomation.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.ContactUsPage;
import com.naveenautomation.pages.HomePage;
import com.naveenautomation.pages.LoginPage;

public class ContactUsPageTest extends TestBase {
	LoginPage loginPage;
	AccountPage accountPage;
	ContactUsPage contactUsPage;
	HomePage homePage;

	@BeforeMethod
	public void launch() {
		initalize();
		loginPage = new LoginPage();

	}

	@Test
	public void validateIfVisitorIsAbleToSubmitContactUsForm() {
		accountPage = loginPage.submitLogin("andy123@mailinator.com", "Password@123");
		contactUsPage= accountPage.getContactOptionLink();
		contactUsPage.submitCtnBtn("Tamy", "", "I would like to learn more about Automation");
		
		//Assert.assertEquals(homePage.getHomePageTitle(), "Your Score","login");
		Assert.assertEquals(contactUsPage.ClickContinueAfterContactUs() ,
				"Your enquiry has been successfully sent to the store owner!", "Unabele to submit");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
