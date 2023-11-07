package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class LogoutPage extends TestBase {

	public LogoutPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "div[class='list-group']>a:nth-of-type(13)")
	WebElement logoutBtn;

	@FindBy(css = "div[id='content']>h1")
	WebElement logoutAlertBanner;
	
	@FindBy(css= "div.pull-right>a")
	WebElement continueBtn;

	public void submitBtn() {
		logoutBtn.click();
	}

	public String getLogoutAlertText() {
		return logoutAlertBanner.getText();
	}
	public HomePage ClickContinueAfterLogout() {
		continueBtn.click();
		return new HomePage();
	}
	//return new homepage
}
