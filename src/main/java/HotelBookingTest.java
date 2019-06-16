import com.utils.Common;
import com.utils.PageObjects;
import com.utils.Prerequisite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HotelBookingTest {

    private static WebDriver driver = null;
   
	@BeforeTest
	public void setUp() {
		new Prerequisite().setDriverPath();
		driver = new ChromeDriver();
	}


    @Test
    public void shouldBeAbleToSearchForHotels() {
    	Common common = new Common(driver);
		common.navigateToURL("https://www.cleartrip.com");
		common.clickElement(PageObjects.hotelLink);
		common.setValueToTextBox(PageObjects.localityTextBox, "Indiranagar, Bangalore");
		common.setValueToDropdown(PageObjects.travellerSelection, "1 room, 2 adults");
        common.clickElement(PageObjects.searchHotelsButton);
    }

    @AfterTest
	public void tearDown() {
		driver.quit();
	}

}
