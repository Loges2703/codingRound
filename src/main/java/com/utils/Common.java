package com.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common {

	private static final int TIMEOUT = 60;
	private static final int POLLING = 500;
	private static WebDriver driver =null;

	public Common(WebDriver driver){
		this.driver = driver;
	}

	public void waitForElementToBeVisible(By element) {
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
			waitForElementToBeVisible(by);
			driver.findElement(by).click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void switchToFrame(By by) {
		try {
			waitForElementToBeVisible(by);
			driver.switchTo().frame(driver.findElement(by));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public String getTextFromElement(By by) {
		String textFromElement = "No Text";
		try {
			waitForElementToBeVisible(by);
			textFromElement = driver.findElement(by).getText();
		}catch(Exception e) {
			e.printStackTrace();
		}

		return textFromElement;

	}

	public void setValueToTextBox(By by,String value) {
		try {
			waitForElementToBeVisible(by);
			driver.findElement(by).clear();
			driver.findElement(by).sendKeys(value);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void setValueToDropdown(By by,String value) {
		try {
			waitForElementToBeVisible(by);
			new Select(driver.findElement(by)).selectByVisibleText(value);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void selectOptionFromListUsingIndex(By by,int index) {
		try {
			waitForElementToBeVisible(by);
			List<WebElement> options = driver.findElements(by);
			options.get(index).click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}


