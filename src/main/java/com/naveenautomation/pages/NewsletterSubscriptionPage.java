package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class NewsletterSubscriptionPage extends TestBase {

	public NewsletterSubscriptionPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(id = "Subscribe / unsubscribe to newsletter")
	WebElement clickNewsLetterOption;

	@FindBy(css = "div[class='pull-right']>input")
	WebElement contBtn;

	public AccountPage newsLetterSubClickCtn() {
		contBtn.click();
		return new AccountPage();
	}

}
