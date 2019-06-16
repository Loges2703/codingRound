package com.utils;

import org.openqa.selenium.By;


public class PageObjects {
	  public static By yourTripsLink =  By.linkText("Your trips");
	  public static By signInLink =  By.id("SignIn");
	  public static By modalWindowFrame = By.id("modal_window");
	  public static By signInButton =  By.id("signInButton");
	  public static By errors = By.id("errors1");
	  public static By onewayRadioButton = By.id("OneWay");
	  public static By fromstationTextBox = By.id("FromTag");
	  public static By autocompleteFromList = By.xpath("//*[@id='ui-id-1']//li");
	  public static By tostationTextBox = By.id("ToTag"); 
	  public static By autocompleteToList = By.xpath("//*[@id='ui-id-2']//li");  
	  public static By dateBox = By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr/td[7]/a");
	  public static By searchButton = By.id("SearchBtn");
	  public static By searchSummary = By.className("searchSummary");
	  public static By hotelLink = By.linkText("Hotels");
	  public static By localityTextBox = By.id("Tags");
	  public static By searchHotelsButton = By.id("SearchHotelsButton");
	  public static By travellerSelection = By.id("travellersOnhome");
}
