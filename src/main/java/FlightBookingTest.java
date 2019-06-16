import com.utils.Common;
import com.utils.Prerequisite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.utils.PageObjects;

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
