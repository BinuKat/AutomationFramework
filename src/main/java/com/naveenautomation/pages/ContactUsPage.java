package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class ContactUsPage extends TestBase {
	public ContactUsPage() {
		PageFactory.initElements(wd, this);

	}

	@FindBy(xpath = "//a[text()='Contact Us']")
	WebElement contactUs;

	@FindBy(css = "input[id='input-name']")
	WebElement inputName;

	@FindBy(css = "input[id='input-email']")
	WebElement inputEmail;

	@FindBy(css = "textarea[id='input-enquiry']")
	WebElement enquiryRemarks;

	@FindBy(css = "input[class='btn btn-primary']")
	WebElement submitBtnOnContactUsPage;

	@FindBy(css = "//p[text()='Your enquiry has been successfully sent to the store owner!']")
	WebElement contactUsAlertBanner;

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement continueBtnOnConfPage;

	public void enterName(String name) {
		inputName.sendKeys(name);
	}

	public void enterEmailId(String email) {
		inputEmail.sendKeys(email);
	}

	public void enterRemarks(String text) {
		enquiryRemarks.sendKeys(text);
	}

	public HomePage submitCtnBtn(String name, String email, String text) {
		enterName(name);
		enterEmailId(email);
		enterRemarks(text);
		submitBtnOnContactUsPage.click();
		continueBtnOnConfPage.click();
		return new HomePage();

	}

//	public String getContactUsAlertText() {
//		return contactUsAlertBanner.getText();
//	}

	public HomePage ClickContinueAfterContactUs() {
		submitBtnOnContactUsPage.click();
		return new HomePage();
	}
}
