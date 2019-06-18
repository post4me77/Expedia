package Epamepam.Epamepam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Abstract class.
 */
public abstract class Helper {
	protected static WebDriver driver;

	public Helper(WebDriver driver) {
		super();
		Helper.driver = driver;
	}

	public void setElementText(WebElement element, String text) {
		element.click();
		element.clear();
		// Log.info("entering text '" + text + "' into element " + element);
		element.sendKeys(text);
	}

	public boolean exists(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException ignored) {
			return false;
		}
	}

	public static void waitUntilElementIsLoaded(WebElement element) throws IOException, InterruptedException {
		new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(element));
	}

	public void sort() throws IOException, InterruptedException {
		ArrayList<String> obtainedList = new ArrayList<String>();
		List<WebElement> elementList = driver
				.findElements(By.cssSelector(".odd td:nth-child(2) a, .even td:nth-child(2) a"));
		waitUntilElementIsLoaded(elementList.get(0));
		for (WebElement we : elementList) {
			obtainedList.add(we.getText());
		}
		ArrayList<String> sortedList = new ArrayList<String>();
		for (String s : obtainedList) {
			sortedList.add(s);
		}
		Collections.sort(sortedList);
		Assert.assertTrue(sortedList.equals(obtainedList));
	}
}