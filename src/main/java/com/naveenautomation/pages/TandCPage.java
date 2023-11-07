package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class TandCPage extends TestBase {
	public TandCPage() {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(xpath = "//a[@href='https://naveenautomationlabs.com/opencart/index.php?route=information/information&information_id=5']")
	WebElement tandCOption;
	
	
	public String getTandCText() {
		return tandCOption.getText();
	}
	
	

}
