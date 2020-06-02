package step;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {

	
	
	private WebDriver driver;
	
	  @Before 
	  public void setUp() {
	  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\drivers\\chromedriver.exe"); driver=new ChromeDriver();
	  //driver.manage().window().maximize();
	  
	  System.out.println("Aviet");
	  
	  
	  }
	  
	
	  @After(order = 0) 
	  
	  public void quitBrowser() {
	  
	  driver.close(); }
	  
	 
	
	
	
	 
	
	@Given("^I am in the login page of the Para Bank Application$")
	public void i_am_in_the_login_page_of_the_Para_Bank_Application()  {
		
	  driver.get("http://parabank.parasoft.com/parabank/index.htm");
	  
	  Reporter.addStepLog("Navigated to Bank application");
	  Reporter.addScenarioLog("Scenario Log message goes here");
	}

	@When("^I enter valid credentials$")
	public void i_enter_valid_credentials()  {
		
		
		driver.findElement(By.name("username")).sendKeys("testuser");
		driver.findElement(By.name("password")).sendKeys("password");
		
		driver.findElement(By.name("username")).submit();
		
		
		//Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Welcome')]")).isDisplayed());
		
	   
	}

	@Then("^I should be taken to the Overview page$")
	public void i_should_be_taken_to_the_Overview_page() throws InterruptedException  {
		
		Thread.sleep(2000);
		driver.findElement(By.linkText("Log Out")).click();
		 //System.out.println(base.UserFullName);
		
	}

	
	@After(order = 1)
	 public void afterScenario(Scenario scenario) {
	 if (scenario.isFailed()) {
	 String screenshotName = scenario.getName().replaceAll(" ", "_");
	 try {
	 //This takes a screenshot from the driver at save it to the specified location
	 File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 
	 //Building up the destination path for the screenshot to save
	 //Also make sure to create a folder 'screenshots' with in the cucumber-report folder
	 File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
	 
	 //Copy taken screenshot from source location to destination location
	 Files.copy(sourcePath, destinationPath);   
	 
	 //This attach the specified screenshot to the test
	 Reporter.addScreenCaptureFromPath(destinationPath.toString());
	 } catch (IOException e) {
	 } 
	 }
	 }
	
	
	
	
}
