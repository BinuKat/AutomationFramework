package com.naveenautomation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class AccountPage extends TestBase {

	public AccountPage() {
		PageFactory.initElements(wd, this);

	}

	@FindBy(css = "#content>h2:first-of-type")
	WebElement myAccountText;

	@FindBy(css = "div.alert-success")
	WebElement acccountInfoUpdateSuccessMessage;

	@FindBy(css = "div[class='alert alert-success alert-dismissible']")
	WebElement newsLetterSuccessMessage;

	@FindBy(xpath = "//a[text()='Contact Us']")
	WebElement contactUs;

	// Success: Your account has been successfully updated.

	@FindBy(xpath = "//a[text()='Edit your account information']")
	WebElement editYourInfoLink;

	// Newsletter Option selection
	@FindBy(css = "div[class='list-group']>a:nth-of-type(12)")
	WebElement clickNewsLetterOption;

	// Reset password link (correct-email)
	@FindBy(css = "div[class='alert alert-success alert-dismissible']")
	WebElement resetPasswordLinkSentOnValidId;

	@FindBy(css = "div[class='list-group']>a:nth-of-type(10)")
	WebElement returnOption; // Return Option Link

	@FindBy(css = "div[class='list-group']>a:last-of-type") // Logout
	WebElement logoutBtnLink;

	@FindBy(css = "div.list-group>a")
	WebElement selectingNavMenu;

	public String getMyAccountText() {
		return myAccountText.getText();
	}

	public String getSuccessMessage() {
		return acccountInfoUpdateSuccessMessage.getText();
	}

	public String getSuccessMsgNewsLetter() {
		return newsLetterSuccessMessage.getText();

	}

	public String getSuccessMsgForPasswordReset() {
		return resetPasswordLinkSentOnValidId.getText();

	}

//	public void selectingSidNavMenu(SideNavigationBar menuSelected) {

	public void clickOnSideNavBar(SideNavBar navBar) {
		List<WebElement> sideNavMenu = wd.findElements(By.cssSelector("div.list-group>a"));
		for (int i = 0; i < sideNavMenu.size(); i++) {
			if (sideNavMenu.get(i).getText().equals(navBar.getSideNavBarMenu())) {
				sideNavMenu.get(i).click();
				break;
			}
		}

	}

	public EditPage clickEditInfoLink(SideNavBar navBar) {
		clickOnSideNavBar(navBar);
		return new EditPage();
	}

	public NewsletterSubscriptionPage clickNewsLetterLink(SideNavBar navBar) {
		clickOnSideNavBar(navBar);
		return new NewsletterSubscriptionPage();

	}

	public LogoutPage selectLogoutOption() {
		logoutBtnLink.click();
		return new LogoutPage();
	}

	public ProductReturnPage getReturnOptionLink() {
		returnOption.click();
		return new ProductReturnPage();

	}

	public ContactUsPage getContactOptionLink() {
		contactUs.click();
		return new ContactUsPage();
	}

	public LogoutPage clickLogout(SideNavBar logout) {
		logoutBtnLink.click();
		return new LogoutPage();

	}
}
