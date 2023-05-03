package stepdefinitions;

//import java.util.Date;

import org.junit.Assert;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;

import factory.DriverFactory;
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.commonUtils;

public class Login {
	
   public  WebDriver driver; 
	private LoginPage loginPage;
		
	@Given("User navigates to login page")
	public void User_navigates_to_login_page()  {
	    driver = DriverFactory.getDriver();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		//driver.findElement(By.xpath("//span[text ()='My Account']")).click();
		homepage.selectLoginOption();
		//driver.findElement(By.linkText("Login")).click();
				
	}		
	
	@When("^User enters valid email address (.+)$")
	public void user_enters_valid_email_address(String emailText) {
		
		 loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(emailText);
		//driver.findElement(By.id("input-email")).sendKeys(emailText);
	   
	}

	@And("^User has entered valid password (.+)$")
	public void user_has_entered_valid_password(String passwordText) {
		
		 loginPage = new LoginPage(driver);
		loginPage.enterpasswordfield(passwordText);
		//driver.findElement(By.id("input-password")).sendKeys(passwordText);
	    
	}

	@And("User clicks on Login button")
	public void user_clicks_on_login_button() {
		
		loginPage.clickOnLoginButton();
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
	    
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
		
		AccountPage accountPage = new AccountPage(driver);
		accountPage.displaystautsOfEdityouAccountInformationOption();
		//Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		Assert.assertTrue(accountPage.displaystautsOfEdityouAccountInformationOption());
	    
	}

	@When("User enters invalid email address {string} in email field")
	
	public void user_enters_invalid_email_address_in_email_field(String InvalidEmailText) {
	   
		loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(commonUtils.getEmailWithTimeStamp());
		//driver.findElement(By.id("input-email")).sendKeys(getEmailWithTimeStamp());
	}

	@When("User enters invalid password {string} in password field")
	public void user_enters_invalid_password_in_password_field(String invalidPasswordText) {
		
		loginPage.enterpasswordfield(invalidPasswordText);
		//driver.findElement(By.id("input-password")).sendKeys(invalidPasswordText);
	    
	}

	@Then("User should get a proper warning message about credentials match")
	public void user_should_get_a_proper_warning_message_about_credentials_match() {
		
		Assert.assertTrue(loginPage.WarningMessageAboutCrdentialsMissMatch().contains("Warning: No match for E-Mail Address and/or Password."));
	  
	}

	@When("User dont enters any email address into email field")
	public void user_dont_enters_any_email_address_into_email_field() {
		
		//driver.findElement(By.id("input-email")).sendKeys("");
		loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress("");
	   
	}

	@When("User dont enters any password into password field")
	public void user_dont_enters_any_password_into_password_field() {
		
		//driver.findElement(By.id("input-password")).sendKeys("");
		loginPage = new LoginPage(driver);
		loginPage.enterpasswordfield("");
	}
	
	

}
