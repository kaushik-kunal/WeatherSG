package com.weathersg.haf.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

	
	WebDriver driver;
	
	
	@FindBy(how=How.XPATH, using="//a[@href='http://www.weather.gov.sg/home/']") 
	WebElement HrefHome;
	
	@FindBy(how=How.XPATH, using="//a[text()='Weather']") 
	WebElement DropdownWeather;
	
	@FindBy(how=How.XPATH, using="//a[@href='http://www.weather.gov.sg/weather-forecast-4dayoutlook/']") 
	WebElement ListItem4DayOutlook;
	
	  public HomePage(WebDriver driver) { PageFactory.initElements(driver, this); }
	  
	  public void NavigateTo4DayOutlook() {
		  
		  try {
			  DropdownWeather.click();
			  ListItem4DayOutlook.click();
		  }
		  catch(Exception e) {
			  throw e;
		  }
		  
		  
	  }
	 
}
