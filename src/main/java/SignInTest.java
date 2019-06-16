import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.jna.Platform;


public class SignInTest {

	private static final int TIMEOUT = 60;
	private static final int POLLING = 500;
	private static WebDriver driver =null;

    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

        setDriverPath();
        driver = new ChromeDriver();
        
        driver.get("https://www.cleartrip.com/");
        By yourtripslink =  By.linkText("Your trips");
        waitFor(yourtripslink);
        driver.findElement(yourtripslink).click();
        
        By signinlink =  By.id("SignIn");
        waitFor(signinlink);
        driver.findElement(signinlink).click();
        
        By modalwindowframe = By.id("modal_window");
        waitFor(modalwindowframe);
        driver.switchTo().frame(driver.findElement(modalwindowframe));
        
        By signinbutton =  By.id("signInButton");
        waitFor(signinbutton);
        driver.findElement(signinbutton).click();

        By errors = By.id("errors1");
        waitFor(errors);
        String errors1 = driver.findElement(errors).getText();
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
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
