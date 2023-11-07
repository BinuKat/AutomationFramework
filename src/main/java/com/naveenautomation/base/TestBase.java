
package com.naveenautomation.base;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.naveenaautomation.browsers.Browser;
import com.naveenautomation.Utils.WebdriverEvents;
import com.naveenautomation.environment.Environment;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver wd;
	private final Browser DEFAULT_BROWSER = Browser.CHROME;
	private final Environment URL = Environment.PROD;
	List<WebElement> sideNavMenu = null;

	public static Logger logger;
	public WebdriverEvents events;
	public EventFiringWebDriver e_driver;
	private static final boolean RUN_On_Grid = true;
	// Remote webdriver accpts options and hub url.It accepts capbilities and URL

	@BeforeClass
	public void loggerSetup() {
		logger = Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.INFO);
	}

	public void initalize() {

		if (RUN_On_Grid) {
			try {
				wd = new RemoteWebDriver(new URL("http://192.168.2.10:4444/"), getOptions());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			switch (DEFAULT_BROWSER) {
			case CHROME:
//			WebDriverManager.chromedriver().setup();//Instead of setup we used "Create", setup was Void method and create returned instance of webdriver
//			wd=new ChromeDriver();
				wd = WebDriverManager.chromedriver().create();

				break;
			case EDGE:
				wd = WebDriverManager.edgedriver().create();
				break;
			case FIREFOX:
				wd = WebDriverManager.firefoxdriver().create();
				break;

			default:
				throw new IllegalArgumentException();
			}
			// wrap the instance
			e_driver = new EventFiringWebDriver(wd);

			// Events which need to be captured
			events = new WebdriverEvents();
			e_driver.register(events);

			// Assigning back the value to Web driver
			wd = e_driver;

			// loading the page
			wd.get(URL.getUrl());
			wd.manage().window().maximize();
			wd.manage().deleteAllCookies();
			wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}

	public MutableCapabilities getOptions() {
		return new ManageOptions().getOption(DEFAULT_BROWSER);
	}

//	}
	@AfterMethod

	public void tearDown() {
		try {
			wd.quit();

		} finally {
			wd.quit();
		}

	}
}
