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

	public boolean sort(List<WebElement> elementList, sortButton) throws IOException, InterruptedException {
		sortButton.click();
		ArrayList<String> obtainedList = new ArrayList<String>();
		waitUntilElementIsLoaded(elementList.get(0));
		for (WebElement we : elementList) {
			obtainedList.add(we.getText());
		}
		ArrayList<String> sortedList = new ArrayList<String>();
		for (String s : obtainedList) {
			sortedList.add(s);
		}
		Collections.sort(sortedList);
		return  sortedList.equals(obtainedList);
	}
}
