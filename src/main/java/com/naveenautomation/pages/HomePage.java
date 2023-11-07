package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class HomePage extends TestBase {

	public HomePage() {
		PageFactory.initElements(wd, this);

	}

	@FindBy(xpath = "//a[@href='https://naveenautomationlabs.com/opencart/index.php?route=information/information&information_id=5']")
	WebElement tandCOption;

	@FindBy(xpath = "//h3[text()='Featured']")
	WebElement homePageText;

	public String getHomePageText() {
		return homePageText.getText();
	}

	public TandCPage clickOnTandCPage() {
		tandCOption.click();
		return new TandCPage();

	}

}
