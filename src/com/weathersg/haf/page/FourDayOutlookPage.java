package com.weathersg.haf.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FourDayOutlookPage {

	
	WebDriver driver;
	
	
	@FindBy(how=How.XPATH, using="//table/tbody/tr[2]/td[2]/span[1]") 
	WebElement DayAfterTomorrowHighTempText;
	
	@FindBy(how=How.XPATH, using="//table/tbody/tr[2]/td[2]/span[2]") 
	WebElement DayAfterTomorrowLowTempText;
	
	@FindBy(how=How.PARTIAL_LINK_TEXT, using="4-Day Outlook") 
	WebElement FourDayOutlookLink;
	
	  public FourDayOutlookPage(WebDriver driver) { PageFactory.initElements(driver, this); }
	  
	  public Boolean NavigationCheck4DayOutlook() {
		  
		  try {
			  if(FourDayOutlookLink.isDisplayed()) {
				  return true;
			  }
			  else {
				  return false;
			  }
		  }
		  catch(Exception e) {
			  throw e;
		  }		  
		  
	  }

	  public String DayAfterTomorrowHighTemperatureExtraction() {
		  try {
			  
			  return DayAfterTomorrowHighTempText.getText().replace("°C", "");
			  
		  }
		  catch(Exception e) {
			  throw e;
		  }
	  }
	  
	  
	  public String DayAfterTomorrowLowTemperatureExtraction() {
		  try {
			  
			  return DayAfterTomorrowLowTempText.getText().replace("°C", "");
			  
		  }
		  catch(Exception e) {
			  throw e;
		  }
	  }

	  
	  
}
