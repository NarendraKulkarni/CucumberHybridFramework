package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	
	WebDriver driver;
	public ElementUtils(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void clickOnElement (WebElement element, long durationInSeconds) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		webElement.click();
		
	}
	
	public void typeTextIntoElement(WebElement element, String textToBeTyped, long durationInSeconds) {
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		//WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		WebElement webElement = waitForElement(element, durationInSeconds);
		
		webElement.click();
		webElement.clear();
		webElement.sendKeys(textToBeTyped);
		
		
	}
	
	public WebElement waitForElement(WebElement element, long durationInSeconds) {
		
		WebElement webElement = null;
		
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		webElement =  wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch (Throwable e) {
			e.printStackTrace();
		}
		return webElement;
		
	}
	
	public void selectOptionInDropDown(WebElement element, String dropDownOption, long durationInSeconds) {
		
		WebElement webElement = waitForElement(element, durationInSeconds);
		Select select = new Select(webElement);
		select.selectByVisibleText(dropDownOption);
			
	}
	
	public void acceptAlert(long DurationInSeconds) {
		
		Alert alert = waitForAlert(DurationInSeconds);
		alert.accept();
				
	}
	
	public void dismissAlert(long DurationInSeconds) {
		
		Alert alert = waitForAlert(DurationInSeconds);
		alert.dismiss();
	}

	public Alert waitForAlert(long DurationInSeconds) {
		
		Alert alert = null;
		try {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(DurationInSeconds));
		 alert = wait.until(ExpectedConditions.alertIsPresent());
		}catch (Throwable e) {
			e.printStackTrace();
		}
		return alert;
		
	}
	
	public void mouseHoverAndClick(WebElement element, long durationInSeconds) {
		
		WebDriverWait wait = new WebDriverWait ( driver, Duration.ofSeconds(durationInSeconds));
		WebElement webElement = wait.until(ExpectedConditions.visibilityOf(element));
		//WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);
		Actions actions = new Actions(driver);
		actions.moveToElement(webElement).click().build().perform();
		
	}
	
	public WebElement waitForVisibilityOfElement(WebElement element, long durationInSeconds) {
		
		WebElement webElement = null;
		
		try {
				
				WebDriverWait wait = new WebDriverWait ( driver, Duration.ofSeconds(durationInSeconds));
				 webElement = wait.until(ExpectedConditions.visibilityOf(element));
		
		}catch 	(Throwable e) {
			e.printStackTrace();
		}
		return webElement;
	}
	
	
	public void javaScriptClick (WebElement element, long durationInSeconds) {
		
		WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].click();", webElement);
		
	}
	
	public void javaScriptType(WebElement element, long durationInSeconds, String textToBeTyped) {
		
		WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].value='"+textToBeTyped+"'", webElement);
		
	}
	
	public String getTextFromElement(WebElement element, long durationInSeconds) {
		
		WebElement webElement = waitForElement(element, durationInSeconds);
		return webElement.getText();
		
	}
}
