package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.naveenautomation.base.TestBase;

public class LoginPage extends TestBase {

	public LoginPage() {

		PageFactory.initElements(wd, this);
//As soon as constructor gets invoked it will say pagefactory initialize all the elements of using webdriver- this class
	}

	@FindBy(id = "input-email")
	WebElement emailInput;

	@FindBy(id = "input-password")
	WebElement passwordInput;

	@FindBy(css = "input[type='submit']")
	WebElement loginBtn;

	@FindBy(css = ".alert-dismissible")
	WebElement alertBanner;

	@FindBy(id = "Change your password")
	WebElement passwordChangeBtn;

	@FindBy(xpath = "//a[@href='https://naveenautomationlabs.com/opencart/index.php?route=information/information&information_id=4']")
	WebElement aboutUsLink;

	@FindBy(xpath = "//a[text()='Delivery Information']")
	WebElement deliveryInfoOption;

	private void enterEmail(String email) {
		emailInput.sendKeys(email);
	}

	private void enterPassword(String password) {
		passwordInput.sendKeys(password);
	}

	public AccountPage submitLogin(String email, String password) {
		enterEmail(email);
		enterPassword(password);
		loginBtn.click();
		return new AccountPage(); // It will return us the object of the page which is about to open
	}

	// public ContactUsPage submitLoginForContactUsPage(String email, String
	// password) {
//		enterEmail(email);
//		enterPassword(password);
//		loginBtn.click();
//		return new AccountPage(); // It will return us the object of the page which is about to open
//	}

	public LogoutPage submitLogin1(String email, String password) {
		enterEmail(email);
		enterPassword(password);
		loginBtn.click();
		return new LogoutPage();
	}

	public String getAlertText() {
		return alertBanner.getText();

	}

	public ForgottenPasswordPage clickForgottenBtn() {
		passwordChangeBtn.click();
		return new ForgottenPasswordPage();

	}

	public AboutUsPage clickAboutUsPage() {
		aboutUsLink.click();
		return new AboutUsPage();

	}

	public DeliveryInformationPage deliveryOptionText() {
		deliveryInfoOption.click();
		return new DeliveryInformationPage();
	}

}
