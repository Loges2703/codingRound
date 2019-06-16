import com.sun.jna.Platform;
import com.utils.Common;
import com.utils.Prerequisite;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.utils.PageObjects;

import java.util.List;

public class FlightBookingTest {

	private static WebDriver driver =null;

	@BeforeTest
	public void setUp() {
		new Prerequisite().setDriverPath();
		driver = new ChromeDriver();
	}


	@Test
	public void testThatResultsAppearForAOneWayJourney() {
		Common common = new Common(driver);
		common.navigateToURL("https://www.cleartrip.com");
		common.clickElement(PageObjects.onewayRadioButton);
		common.setValueToTextBox(PageObjects.fromstationTextBox, "Bangalore");
		common.selectOptionFromListUsingIndex(PageObjects.autocompleteFromList, 0);
		common.setValueToTextBox(PageObjects.tostationTextBox, "Delhi");
		common.selectOptionFromListUsingIndex(PageObjects.autocompleteToList, 0);
		common.clickElement(PageObjects.dateBox);
		common.clickElement(PageObjects.searchButton);
		Assert.assertTrue(common.isElementPresent(PageObjects.searchSummary));
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
