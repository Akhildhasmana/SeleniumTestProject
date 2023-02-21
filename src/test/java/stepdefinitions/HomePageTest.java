package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashMap;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HomePageTest {
	WebDriver driver;





	@Given("I am at home page")
	public void iAmAtLoginPage() {
		HashMap<String, Integer> conentSettings = new HashMap<String, Integer>();
		HashMap<String, Object> profile = new HashMap<String, Object>();
		HashMap<String, Object> prefs = new HashMap<String, Object>();
        conentSettings.put("geolocation", 2);//(Use 1 to allow ,use 2 to disallow,0 to always ask)
		profile.put("managed_default_content_settings", conentSettings);
		prefs.put("profile", profile);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);
		driver.get("https://www.tvsmotor.com/");
	}

	@When("I click on book a vehicle icon from top bar")
	public void i_click_on_book_a_vehicle_icon_from_top_bar() {
		WebElement bookVehicle = driver.findElement(By.id("NavBookaVehicle"));
		bookVehicle.click();
	}

	@Then("Book online page is displayed")
	public void book_online_page_is_displayed() {
		WebElement bookOnlinePageTitle = driver.findElement(By.xpath("//h1[normalize-space()='Book Online']"));
		Assert.assertEquals("Book Online",bookOnlinePageTitle.getText());
	}
}




