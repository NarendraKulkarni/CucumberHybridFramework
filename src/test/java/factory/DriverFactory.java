package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	static WebDriver driver = null;
	
	public static void  initializeBrowser (String BrowserName) {
	
		
		if(BrowserName.equals("Chrome")) {
			
			 driver = new ChromeDriver();
		
		}else if (BrowserName.equals("Firefox")) {
			
			 driver = new FirefoxDriver();
			
		}else if (BrowserName.equals("Edge")) {
			
		     driver = new EdgeDriver();
			
		}
		
		
		
		
	}
	
		public static WebDriver getDriver () {
			
			return driver;
		}
	

}
