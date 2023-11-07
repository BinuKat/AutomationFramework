package com.naveenautomation.PageTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;


public class DummyTest extends TestBase{
	
	@BeforeMethod
	public void setUpAccount() {
		initalize();
	}
	
	@Test
	public void test1() {
		WebElement email= wd.findElement(By.id("input-email"));
		wd.navigate().refresh();
		email.sendKeys("Munni");
	}
	
	@AfterMethod
	public void quit() {
		tearDown();
	}

}


