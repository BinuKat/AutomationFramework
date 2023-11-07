package com.naveenautomation.Utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorExample {

	WebDriver wd;
	JavascriptExecutor jse;

	@BeforeMethod
	public void setUp() {
		wd = WebDriverManager.chromedriver().create();
		wd.get(null);
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void test1() {
		String val = Utils.generateRandomString(0);
		System.out.println(val);
	}
}