package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BrowserFactory {

	static WebDriver driver;
	
	public static WebDriver InitiateBrowser(String BrowserName, String URL)	{
		
		if(BrowserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(BrowserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"");
			driver=new ChromeDriver();
		}
		else if(BrowserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.InternetExplorer.driver", System.getProperty("user.dir")+"");
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get(URL);
		return driver;
	}
	
}
