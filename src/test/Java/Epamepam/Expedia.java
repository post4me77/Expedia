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
		try {
			waitUntilElementIsLoaded(element);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		element.click();
		element.clear();
		element.sendKeys(text);
	}
	
	public void waitForElement(WebElement element) {
		try {
			waitUntilElementIsLoaded(element);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
