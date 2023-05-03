package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class HomePage {

	WebDriver driver;
	//private ElementUtils elementUtils; // How to use methods from ElementUtils
	
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		//elementUtils = new ElementUtils(driver); // How to use methods from ElementUtils
		
	}
	
	@FindBy(xpath="//span[text ()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginoption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy (xpath="//input[@name='search']") 
	private WebElement searchBoxField;
	
	@FindBy (xpath="//button[contains(@class,'btn-default')]")
	private WebElement SearchButton;
	
	public void clickOnMyAccount() {
		myAccountDropMenu.click();
		//elementUtils.clickOnElement(myAccountDropMenu, 10);  // How to use methods from ElementUtils
		
	}
	//After clicking on login option the flow moves to login page hence in this function only we are returning LoginPage
	public void selectLoginOption () {
		loginoption.click();
					
	}
	
	public void selectRegisterOption () {
		
		registerOption.click();
	}
	
	
	public void enterValidProductIntoSearchField (String ProductText) {
		
		searchBoxField.sendKeys(ProductText);
	}
	
	public void ClickSearchButton () {
		
		SearchButton.click();
	}
	
}
