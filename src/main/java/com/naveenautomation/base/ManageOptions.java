package com.naveenautomation.base;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.naveenaautomation.browsers.Browser;

public class ManageOptions {

	private ChromeOptions getChromeOptions(boolean runHeadless) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.setHeadless(runHeadless);
		return options;

	}

	private EdgeOptions getEdgeOptions(boolean runHeadless) {
		EdgeOptions options = new EdgeOptions();
		return options;

	}

	private FirefoxOptions getFireFoxOptions(boolean runHeadless) {
		FirefoxOptions options = new FirefoxOptions();
		return options;

	}

	public MutableCapabilities getOption(Browser browser) {

		switch (browser) {
		case CHROME:
			return this.getChromeOptions(true);
		case FIREFOX:
			return this.getFireFoxOptions(true);
		case EDGE:
			return this.getEdgeOptions(true);

		default:
			throw new IllegalArgumentException();
		}

	}
}
