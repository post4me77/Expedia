package Epamepam.Epamepam;

import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class ExpediaTest {
	static WebDriver driver;
	Expedia expedia;
	String FIRSTPRICEITEM = "$131";
	String WRONGFIRSTPRICEITEM = "$1";
	String DEPARTINGDATE = "12/01/2019";
	String RETURNINGDATE = "12/07/2019";
	String URLLONDONDUBLIN = "https://www.expedia.com/Flights-Search?flight-type=on&starDate=12%2F01%2F2019&endDate="
			+ "12%2F07%2F2019&mode=search&trip=roundtrip&leg1=from%3ALondon%2C+England%2C+UK+%28"
			+ "LHR-Heathrow%29%2Cto%3ADublin%2C+Ireland+%28DUB%29%2Cdeparture%3A12%2F01%2F2019TANYT&leg2="
			+ "from%3ADublin%2C+Ireland+%28DUB%29%2Cto%3ALondon%2C+England%2C+UK+%28LHR-Heathrow%29%2C"
			+ "departure%3A12%2F07%2F2019TANYT&passengers=children%3A0%2Cadults%3A2%2Cseniors%3A0%2C"
			+ "infantinlap%3AY";

	@Before
	public void setUp() throws IOException, InterruptedException {
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
		expedia = new Expedia(driver);
		String BASEURL = "http://www.expedia.com";
		Dimension newSize = new Dimension(1200, 780);
		// Resize current window to the set dimension
		driver.manage().window().setSize(newSize);
		driver.navigate().to(BASEURL);
		expedia.waitForElement(expedia.flightButton);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void mySimpleEqualsTest() throws InterruptedException, IOException {
		expedia.flightButton.click();
		// Set from country field.
		expedia.setElementText(expedia.flyingFromField, "London");
		expedia.waitForElement(expedia.heathrowAirportTitle);
		// Select Heathrow airport in popup.
		expedia.heathrowAirportTitle.click();
		// Set to country field.
		expedia.setElementText(expedia.flyingToField, "Dublin");
		expedia.waitForElement(expedia.dublinwAirportTitle);
		// Select "Dublin Airport (DUB), Ireland" in popup.
		expedia.dublinwAirportTitle.click();
		expedia.waitForElement(expedia.flightDepartingDate);
		expedia.flightDepartingDate.click();
		// Write date in field.
		expedia.flightDepartingDate.sendKeys(DEPARTINGDATE);
		expedia.waitForElement(expedia.flightReturningDate);
		expedia.flightReturningDate.click();
		expedia.flightReturningDate.sendKeys(Keys.CONTROL + "a");
		// We need return Control key.
		expedia.flightReturningDate.sendKeys(Keys.CONTROL + "");
		// Write date in field.
		expedia.flightReturningDate.sendKeys(RETURNINGDATE);
		expedia.waitForElement(expedia.travelerSelectorButton);
		expedia.travelerSelectorButton.click();
		expedia.waitForElement(expedia.plusAdultButton);
		expedia.plusAdultButton.click();
		expedia.waitForElement(expedia.submitButton);
		expedia.submitButton.click();
		// This only appears after the progress bar has 100%
		expedia.waitForElement(expedia.goodTitle);
		// We need to check that have correct entered data.
		Assert.assertEquals(driver.getCurrentUrl(), URLLONDONDUBLIN);
		expedia.waitForElement(expedia.firstPriceTitle);
		// Assert that the price in first row is €122.98 (or any other price at your
		// time).
		Assert.assertEquals(expedia.firstPriceTitle.getText(), FIRSTPRICEITEM);
		// Assert that the price in first row is not €1.
		Assert.assertNotEquals(expedia.firstPriceTitle.getText(), WRONGFIRSTPRICEITEM);
	}
}
