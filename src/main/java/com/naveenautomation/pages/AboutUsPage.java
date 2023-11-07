package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class AboutUsPage extends TestBase {

	public AboutUsPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(xpath = "//a[@href='https://naveenautomationlabs.com/opencart/index.php?route=information/information&information_id=4']")
	WebElement aboutUsLink;

	public String getAboutUsText() {
		return aboutUsLink.getText();
	}
}
