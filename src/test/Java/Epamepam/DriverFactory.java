package Epamepam.Epamepam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	private WebDriver driver;

	DriverFactory() {
		WebDriverManager.chromedriver().version("74.0.3729.6").setup();
		driver = new ChromeDriver();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void QuitDriver() {
		driver.quit();
	}
}
