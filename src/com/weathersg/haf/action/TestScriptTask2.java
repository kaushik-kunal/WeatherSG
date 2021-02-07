package com.weathersg.haf.action;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.weathersg.haf.page.FourDayOutlookPage;
import com.weathersg.haf.page.HomePage;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import utility.BrowserFactory;


public class TestScriptTask2 {
	Properties prop;
	WebDriver driver;
	String HighTempUI,LowTempUI,LowTempAPI,HighTempAPI;

	@BeforeClass
	public void PreTests() {
		try (InputStream input = new FileInputStream(System.getProperty("user.dir") + "/src/config.properties")) {
			prop = new Properties();

			prop.load(input);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@AfterClass
	public void PostExecution() {
		driver.close();
		driver.quit();
	}

	@Test(priority=1)
	public void HomeNav() {

		try {
			driver = BrowserFactory.InitiateBrowser(prop.getProperty("browsername"), prop.getProperty("url"));
			HomePage HP = new HomePage(driver);
			HP.NavigateTo4DayOutlook();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	@Test(priority=2)
	public void FourDayOutlookAPIResponseCheck() {
		
		RestAssured rs=new RestAssured();
		rs.baseURI="https://api.data.gov.sg/v1/environment/4-day-weather-forecast";
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date today = Calendar.getInstance().getTime();        
		String reportDate = df.format(today);
		
		String resp=given().queryParam("date", reportDate).when().get().asString();
		
		JsonPath js= new JsonPath(resp);
		LowTempAPI =js.getString("items.forecasts[1].temperature[1].low").replace("°C", "");
		HighTempAPI =js.getString("items.forecasts[1].temperature[1].high").replace("°C", "");
	}
	
	@Test(priority=3)
	public void NavigationTo4DayOutlookScreenCheck() {
		FourDayOutlookPage FDO=new FourDayOutlookPage(driver);
		Assert.assertTrue("The Navigation to 4 Day Outlook Screen is successfull", FDO.NavigationCheck4DayOutlook());
	}
	
	@Test(priority=4)
	public void DayAfterTomorrowLowTempExtractionUI() {
		FourDayOutlookPage FDO=new FourDayOutlookPage(driver);
		LowTempUI=FDO.DayAfterTomorrowLowTemperatureExtraction();
		//System.out.println(LowTempUI);
	}
	
	@Test(priority=4)
	public void DayAfterTomorrowHighTempExtractionUI() {
		FourDayOutlookPage FDO=new FourDayOutlookPage(driver);
		HighTempUI=FDO.DayAfterTomorrowHighTemperatureExtraction();
		//System.out.println(HighTempUI);
	}
	
	@Test(priority=5)
	public void APIvsUIOvermorrowTemperaturesComparison() {
		
		if(HighTempUI.equals(HighTempAPI) && LowTempUI.equals(LowTempAPI)) {
			Assert.assertTrue("Both the API and UI temperatures are same", true);
		}
		else {
			Assert.fail("There is deviation in API Response and UI temperatures: API High & Low temp respectively "+HighTempAPI+" "+LowTempAPI+"  UI High & Low temp respectively "+HighTempUI+" "+LowTempUI);
		}
		
	}
}
