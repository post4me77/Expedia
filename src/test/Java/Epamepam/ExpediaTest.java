package Epamepam.Epamepam;

import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExpediaTest {
	DriverFactory objDriver = new DriverFactory();
	Expedia expedia;
	String BASEURL = "http://www.expedia.com";
	String FIRST_PRICE_ITEM = "$131";
	String WRONG_FIRST_PRICE_ITEM = "$1";
	String DEPARTING_DATE = "12/01/2019";
	String RETURNING_DATE = "12/07/2019";
	String DEPARTURE_CITY = "London";
	String ARRIVAL_CITY = "Dublin";
	String URL_LONDON_DUBLIN = "https://www.expedia.com/Flights-Search?flight-type=on&starDate=12%2F01%2F2019&endDate="
			+ "12%2F07%2F2019&mode=search&trip=roundtrip&leg1=from%3ALondon%2C+England%2C+UK+%28"
			+ "LHR-Heathrow%29%2Cto%3ADublin%2C+Ireland+%28DUB%29%2Cdeparture%3A12%2F01%2F2019TANYT&leg2="
			+ "from%3ADublin%2C+Ireland+%28DUB%29%2Cto%3ALondon%2C+England%2C+UK+%28LHR-Heathrow%29%2C"
			+ "departure%3A12%2F07%2F2019TANYT&passengers=children%3A0%2Cadults%3A2%2Cseniors%3A0%2C"
			+ "infantinlap%3AY";

	@Before
	public void setUp() throws IOException, InterruptedException {
		expedia = new Expedia(objDriver.getDriver());
		expedia.setWindowsSize(1200, 780);
		objDriver.getDriver().navigate().to(BASEURL);
		expedia.waitForElement(expedia.flightButton);
	}

	@After
	public void tearDown() {
		objDriver.QuitDriver();
	}

	@Test
	public void mySimpleEqualsTest() throws InterruptedException, IOException {
		expedia.flightButton.click();
		// Set from country field.
		expedia.setDepartureAirport(DEPARTURE_CITY);
		// Select Heathrow airport in popup.
		expedia.waitForElement(expedia.heathrowAirportTitle);
		expedia.heathrowAirportTitle.click();
		// Set to country field.
		expedia.setArrivalAirport(ARRIVAL_CITY);
		expedia.waitForElement(expedia.dublinwAirportTitle);
		// Select "Dublin Airport (DUB), Ireland" in popup.
		expedia.dublinwAirportTitle.click();

		expedia.waitForElement(expedia.travelerSelectorButton);
		expedia.travelerSelectorButton.click();

		expedia.waitForElement(expedia.plusAdultButton);
		expedia.plusAdultButton.click();

		expedia.setDepartureDate(DEPARTING_DATE);

		expedia.setArrivalDate(RETURNING_DATE);

		expedia.waitForElement(expedia.submitButton);
		expedia.submitButton.click();

		// This only appears after the progress bar has 100%
		expedia.waitForElement(expedia.goodTitle);
		// We need to check that have correct entered data.
		Assert.assertEquals(objDriver.getDriver().getCurrentUrl(), URL_LONDON_DUBLIN);
		expedia.waitForElement(expedia.firstPriceTitle);
		// Assert that the price in first row is €122.98 (or any other price at your
		// time).
		Assert.assertEquals(expedia.firstPriceTitle.getText(), FIRST_PRICE_ITEM);
		// Assert that the price in first row is not €1.
		Assert.assertNotEquals(expedia.firstPriceTitle.getText(), WRONG_FIRST_PRICE_ITEM);
	}
}
