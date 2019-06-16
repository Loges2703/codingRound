package com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.jna.Platform;

public class Common {

	private static final int TIMEOUT = 60;
	private static final int POLLING = 500;
	private static WebDriver driver =null;

	public Common(WebDriver driver){
		this.driver = driver;
	}

	public void waitFor(By element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, TIMEOUT, POLLING);
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		} catch (Exception e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}
	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	public void navigateToURL(String URL) {
		driver.get(URL);
	}

	public void clickElement(By by) {
		try {
			waitFor(by);
			driver.findElement(by).click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void switchToFrame(By by) {
		try {
			waitFor(by);
			driver.switchTo().frame(driver.findElement(by));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getTextFromElement(By by) {
		String textFromElement = "No Text";
		try {
			waitFor(by);
			textFromElement = driver.findElement(by).getText();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return textFromElement;
	
	}
}


