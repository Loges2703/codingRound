import com.sun.jna.Platform;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FlightBookingTest {
	
	

	private static final int TIMEOUT = 60;
	private static final int POLLING = 500;
	private static WebDriver driver =null;



    @Test
    public void testThatResultsAppearForAOneWayJourney() {

        setDriverPath();
        driver = new ChromeDriver();
        driver.get("https://www.cleartrip.com/");
        By onewayradiobutton = By.id("OneWay");
        waitFor(onewayradiobutton);
        driver.findElement(onewayradiobutton).click();
        
        By fromstationtextbox = By.id("FromTag");
        waitFor(fromstationtextbox);
        driver.findElement(fromstationtextbox).clear();
        driver.findElement(fromstationtextbox).sendKeys("Bangalore");

        //wait for the auto complete options to appear for the origin
        By autocompletefrom = By.id("ui-id-1");
        waitFor(autocompletefrom);
        List<WebElement> originOptions = driver.findElement(autocompletefrom).findElements(By.tagName("li"));
        originOptions.get(0).click();
        
        By tostationtextbox = By.id("ToTag");
        waitFor(tostationtextbox);

        driver.findElement(tostationtextbox).clear();
        driver.findElement(tostationtextbox).sendKeys("Delhi");

        //wait for the auto complete options to appear for the destination

        By autocompleteto = By.id("ui-id-2");
        waitFor(autocompleteto);
        //select the first item from the destination auto complete list
        List<WebElement> destinationOptions = driver.findElement(autocompleteto).findElements(By.tagName("li"));
        destinationOptions.get(0).click();
        
        By datebox = By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a");
        waitFor(datebox);
        driver.findElement(datebox).click();

        //all fields filled in. Now click on search
        By searchbutton = By.id("SearchBtn");
        waitFor(searchbutton);
        driver.findElement(searchbutton).click();

       
        //verify that result appears for the provided journey search
        By searchsummary = By.className("searchSummary");
        waitFor(searchsummary);
        Assert.assertTrue(isElementPresent(searchsummary));

        //close the browser
        driver.quit();

    }


    private void waitFor (By element) {
        try {
        	WebDriverWait wait = new WebDriverWait(driver, TIMEOUT, POLLING);
    		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }


    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private void setDriverPath() {
        if (Platform.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (Platform.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (Platform.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }
}
