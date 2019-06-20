package Epamepam.Epamepam;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Epamepam.Epamepam.Helper;

public class Expedia extends Helper {

	public Expedia(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='tab-flight-tab-hp']")
	WebElement flightButton;

	@FindBy(xpath = "//*[@id='flight-origin-hp-flight']")
	WebElement flyingFromField;

	@FindBy(xpath = "//*[@id=\"aria-option-1\"]/div/span[2]")
	WebElement heathrowAirportTitle;

	@FindBy(xpath = "//*[@id=\"flight-destination-hp-flight\"]")
	WebElement flyingToField;

	@FindBy(xpath = "//*[@id=\"aria-option-0\"]/span[2]/div")
	WebElement dublinwAirportTitle;

	@FindBy(css = ".gcw-submit")
	WebElement submitButton;

	@FindBy(xpath = "//*[@id='flight-departing-hp-flight']")
	WebElement flightDepartingDate;

	@FindBy(xpath = "//*[@id='flight-returning-hp-flight']")
	WebElement flightReturningDate;

	@FindBy(xpath = "//*[@id='traveler-selector-hp-flight']")
	WebElement travelerSelectorButton;

	@FindBy(css = ".uitk-grid .uitk-step-input-plus")
	WebElement plusAdultButton;

	@FindBy(css = ".full-bold")
	WebElement firstPriceTitle;

	@FindBy(xpath = "//*[@class='good']")
	WebElement goodTitle;

	public void setElementText(WebElement element, String text) {
		waitUntilElementIsLoaded(element);
		element.sendKeys(text);
	}

	public void setWindowsSize(int x, int y) {
		Dimension newSize = new Dimension(x, y);
		// Resize current window to the set dimension
		driver.manage().window().setSize(newSize);
	}

	public void waitForElement(WebElement element) {
		waitUntilElementIsLoaded(element);
	}

	public void sendKeysText(String text) {
		// Set focus on field.
		flightReturningDate.click();
		// Select or text on filed.
		flightReturningDate.sendKeys(Keys.CONTROL + "a");
		// We need return Control key.
		flightReturningDate.sendKeys(Keys.CONTROL + "");
		// Write date in field.
		flightReturningDate.sendKeys(text);
	}

	public void setDepartureAirport(String airportName) {
		setElementText(setElementText, airportName);
	}

	public void setArrivalAirport(String airportName) {
		setElementText(flyingToField, airportName);
	}

	public void setDepartureDate(String departureDate) {
		waitForElement(flightDepartingDate);
		// Write date in field.
		flightDepartingDate.sendKeys(departureDate);
	}

	public void setArrivalDate(String arrivalDate) {
		waitForElement(expedia.flightReturningDate);
		// Write date in field.
		sendKeysText(arrivalDate);
	}

	/*
	 * List<WebElement> elementList = driver .findElements(By.
	 * cssSelector(".odd td:nth-child(2) a, .even td:nth-child(2) a"));
	 * Assert.assertTrue(sort(elementList, sortButton));
	 */
}
