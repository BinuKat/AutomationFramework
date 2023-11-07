package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class ProductReturnPage extends TestBase {

	public ProductReturnPage() {
		PageFactory.initElements(wd, this);

	}

	@FindBy(css = "div[id='content']>h1")
	WebElement messageOnReturnP;

	public String getReturnOptionText() {
		return messageOnReturnP.getText();

	}
}
