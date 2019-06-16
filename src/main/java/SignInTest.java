import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.utils.Common;
import com.utils.Prerequisite;
import com.utils.PageObjects;


public class SignInTest {

	private static WebDriver driver =null;

	@BeforeTest
	public void setUp() {
		new Prerequisite().setDriverPath();
		driver = new ChromeDriver();
	}

	@Test
	public void shouldThrowAnErrorIfSignInDetailsAreMissing() {        
		Common common = new Common(driver);
		common.navigateToURL("https://www.cleartrip.com");
		common.clickElement(PageObjects.yourTripsLink);
		common.clickElement(PageObjects.signInLink);
		common.switchToFrame(PageObjects.modalWindowFrame);
		common.clickElement(PageObjects.signInButton);
		String errors1 = common.getTextFromElement(PageObjects.errors);
		Assert.assertTrue(errors1.contains("There were errors in your submission"));

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
