package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class ForgottenPasswordPage extends TestBase {

	public ForgottenPasswordPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "input[id='input-email']")
	WebElement emailInput;

	@FindBy(css = "input[type='submit']")
	WebElement continueBtn;

	@FindBy(css = "div.alert-dismissible")
	WebElement notFoundEmailAlert;

	private void enterEmailAdd(String email) {
		emailInput.sendKeys(email);

	}

	public void clickSubmitBtn(String email) {
		enterEmailAdd(email);
		continueBtn.click();
	}

	public String notFoundEmailAlertText() {
		return notFoundEmailAlert.getText();

	}
}
