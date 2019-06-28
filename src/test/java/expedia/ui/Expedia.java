package com.expedia.ui;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.expedia.BasePageObject;

public class Expedia extends BasePageObject {

	public Expedia(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='tab-flight-tab-hp']")
	WebElement flightButton;

	@FindBy(xpath = "//*[@id='flight-origin-hp-flight']")
	WebElement flyingFromField;

	@FindBy(xpath = "//*[@id=\"flight-destination-hp-flight\"]")
	WebElement flyingToField;

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

	public void setElementText(WebElement element, String text) throws IOException, InterruptedException {
		waitUntilElementIsLoaded(element);
		element.sendKeys(text);
	}
	
	public void windowsSizeSet(int x, int y) {
		windowsSizeSet(x, y);
	}

	public void waitForElement(WebElement element) throws IOException, InterruptedException {
		waitUntilElementIsLoaded(element);
	}

	public void setDepartureAirport(String DEPARTURE_CITY, String airportName) {
		flyingFromField.click();
		flyingFromField.sendKeys(DEPARTURE_CITY);
		WebElement departureAirportName = driver
				.findElement((By.xpath("//*[contains(text(), \"" + airportName + "\")]")));
		departureAirportName.click();

	}
	
	public void setArrivalAirport(String ARRIVAL_CITY, String airportName) {
		flyingToField.click();
		flyingToField.sendKeys(ARRIVAL_CITY);
		WebElement airportNameButton = driver
				.findElement((By.xpath("//*[contains(text(), \"" + airportName + "\")]")));
		airportNameButton.click();
	}

	public void setDepartureDate(String departureDate) throws IOException, InterruptedException {
		// waitForElement(flightDepartingDate);
		// Write date in field.
		flightDepartingDate.sendKeys(departureDate);
	}

	public void setArrivalDate(String arrivalDate) throws IOException, InterruptedException {
		// waitForElement(flightReturningDate);
		// Set focus on field.
		flightReturningDate.click();
		// Select or text on filed.
		flightReturningDate.sendKeys(Keys.chord(Keys.CONTROL, "a"), arrivalDate);
	}
}
