package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	
	public RegisterPage (WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-firstname")
	private WebElement FirstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement LastNameField;
	
	@FindBy(id="input-email")
	private WebElement InputEmailField;
	
	@FindBy(id="input-telephone")
	private WebElement InputTelephoneField;
	
	@FindBy(id="input-password")
	private WebElement InputPasswordField;
	
	@FindBy(id="input-confirm")
	private WebElement InputPasswordConfirmField;
	
	@FindBy(name="agree")
	private WebElement PrivacyPolicyOption;
	
	@FindBy (xpath="//input[@value='Continue']")
	private WebElement ContinueButton;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement NewsLetterOption;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement WarningMessage;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement FirstNameWarning;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement LastNameWarning;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement EmailWaning;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement TelephoneWarning;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement PasswordWarning;
	
	
	
	
	public void enterFirstName (String firstNameText) {
		
		FirstNameField.sendKeys(firstNameText);
	}
	
	public void enterLastName ( String LastNameText) {
		
		LastNameField.sendKeys(LastNameText);
	   
	}
	
	public void enterInputEmailField (String InputEmailText) {
		
		InputEmailField.sendKeys(InputEmailText);
	
	}
	
	public void entertelephoneField ( String InputTelephoneText) {
		
		InputTelephoneField.sendKeys(InputTelephoneText);
	}
	
	public void enterInputPasswordField ( String InputPasswordText) {
	
		InputPasswordField.sendKeys(InputPasswordText);
	}
	
	public void enterInputPasswordConfirmField ( String InputPasswordConfirmText) {
		
		InputPasswordConfirmField.sendKeys(InputPasswordConfirmText);
	}
	
	public void selectprivacypolicy () {
		
		PrivacyPolicyOption.click();
	}
	
	public void ClickContinueButton () {
		
		ContinueButton.click();
	}
	
	public void SeletcNewsLetterOption () {
		
		NewsLetterOption.click();
	}
	
	public String RetrieveWarningMessageText () {
		
		return WarningMessage.getText();
	}
	
	public String FirstNameWarning () {
		
		return FirstNameWarning.getText();
	}
	
	public String LastNameWarning () {
		
		return LastNameWarning.getText();
	}
	
	public String EmailWaning () {
		
		return EmailWaning.getText();
	}
	
	public String TelephoneWarning () {
		
		return TelephoneWarning.getText();
	}

	public String PasswordWarning () {
		
		return PasswordWarning.getText();
	}
}
