package stepdefinitions;

import org.junit.Assert;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchResultPage;

public class Search {
	
	public WebDriver driver;
	private HomePage homepage;

	
	@Given("User opens the application")
	public void user_opens_the_application() {
		
		driver = DriverFactory.getDriver();
	    
	}

	@When("User enters valid product {string} into search box field")
	public void user_enters_valid_product_into_search_box_field(String validproducttext) {
		
		homepage = new HomePage(driver);
		homepage.enterValidProductIntoSearchField(validproducttext);
		//driver.findElement(By.xpath("//input[@name='search']")).sendKeys(validproducttext);
	    
	}

	@When("User clicks on search button")
	public void user_clicks_on_search_button() {
		homepage = new HomePage(driver);
		homepage.ClickSearchButton();
		//driver.findElement(By.xpath("//button[contains(@class,'btn-default')]")).click();
	    
	}

	@Then("User should get valid product displayed in search result")
	public void user_should_get_valid_product_displayed_in_search_result() {
	    
		SearchResultPage searchResultPage = new SearchResultPage(driver);
		
		//Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
		Assert.assertTrue(searchResultPage.displayStatusOfValidProduct());
		//Assert.fail(); //to fail a test script.
	}

	@When("User enters invalid product {string} into search box field")
	public void user_enters_invalid_product_into_search_box_field(String invalidproducttext) {
		
		homepage = new HomePage(driver);
		homepage.enterValidProductIntoSearchField(invalidproducttext);
		//driver.findElement(By.xpath("//input[@name='search']")).sendKeys(invalidproducttext);
	    
	}

	@Then("User should get message about no product matching")
	public void user_should_get_message_about_no_product_matching() {
		
		SearchResultPage searchResultPage = new SearchResultPage(driver);
		
		//Assert.assertEquals("There is no product that matches the search criteria.", driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p")).getText());
		Assert.assertEquals("There is no product that matches the search criteria.", searchResultPage.getMessageText());
		
	    
	}

	@When("User dont enter any product name into search box field")
	public void user_dont_enter_any_product_name_into_search_box_field() {
		
		homepage = new HomePage(driver);
		homepage.enterValidProductIntoSearchField("");
		//driver.findElement(By.xpath("//input[@name='search']")).sendKeys("");
		
	}


	
}
