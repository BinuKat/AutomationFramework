package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class DeliveryInformationPage extends TestBase {
	public DeliveryInformationPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(xpath = "//a[text()='Delivery Information']")
	WebElement deliveryInfoOption;

	public String getdeliveryOptionText() {
		return deliveryInfoOption.getText();
	}
	public void dInfoBtn() {
		deliveryInfoOption.click();
}
}
