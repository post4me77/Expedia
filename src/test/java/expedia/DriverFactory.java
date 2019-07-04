package com.expedia;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.expedia.ReadPropertyFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	private WebDriver driver;
	ReadPropertyFile readPropertyFile= new ReadPropertyFile();

	public DriverFactory() {
		WebDriverManager.chromedriver().version(readPropertyFile.getChromeVersion()).setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void quitDriver() {
		driver.quit();
	}
}
