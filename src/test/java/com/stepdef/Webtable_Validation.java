package com.stepdef;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cucumber.listener.Reporter;
import com.excelFactory.ExcelColumn;
import com.extentreport.BaseTest;
import com.pagefactory.WebPageFactory;
import com.util.TakeScreenShot;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Webtable_Validation extends BaseTest{

	WebDriver driver;
	ArrayList<String> clubNames;
	WebPageFactory pf;
	String excelPath = "./TestData/WebTable Test Data.xlsx";
	ArrayList<String> ColumnValue;
	int chelseRank;
	List<String> notMatchWebTableClub;
	List<String> notMatchExcelClub;
	
	@Given("^User able to open any browser$")
	public void user_able_to_open_any_browser() throws Throwable {
		
		//Reporter.addScenarioLog("Scenario Log message goes here");
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		//Reporter.addStepLog("browser open");
	}

	@Given("^Put URL and go to home apge$")
	public void put_URL_and_go_to_home_apge() throws Throwable {
		
		driver.get("https://www.premierleague.com/tables/");
		pf = PageFactory.initElements(driver, WebPageFactory.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	  
	}

	@When("^I enter Username as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void i_enter_Username_as_and_Password_as(String email, String pass) throws Throwable {
	   
		pf.getSignInBtn().click();
		pf.getUserEmail().sendKeys(email);

		pf.getUserPassWord().sendKeys(pass);
		 TakeScreenShot.captureScreenShot(driver, "Login01");
		pf.getOkBtn().click();
	  
	}

	@Then("^login should be successful$")
	public void login_should_be_successful() throws Throwable {
		System.out.println(driver.getTitle());
		 TakeScreenShot.captureScreenShot(driver, "Login01");
	  
	}

	@Then("^Validate home page$")
	public void validate_home_page() throws Throwable {
	   String pageTilte="Premier League Table, Form Guide & Season Archives";
	  
		Assert.assertEquals(driver.getTitle(), pageTilte);
		
		//Reporter.addStepLog("Page Title::"+driver.getTitle());
		
	}

	@Then("^take screen shot of the web table$")
	public void take_screen_shot_of_the_web_table() throws Throwable {
		
		pf.getTableLink().click();
		TakeScreenShot.captureScreenShot(driver, "Web Table");
	  
	}

	@When("^User able to get web table data$")
	public void user_able_to_get_web_table_data() throws Throwable {
	   
clubNames = new ArrayList<String>();
		
		List<WebElement> Clubrows = pf.getClubNames();
		System.out.println("Total club count::" + Clubrows.size());

		for (WebElement club : Clubrows) {
			clubNames.add(club.getText().toString());
		}
		System.out.println(clubNames);
	
	//	Reporter.addStepLog("Club name from webTable::"+clubNames);
	}

	@Then("^Find out club name chelse$")
	public void find_out_club_name_chelse() throws Throwable {
		for (String club : clubNames) {
			if (club.equalsIgnoreCase("Chelsea")) {
				System.out.println("Test Passed:: Club name Found = " + club);
				//Reporter.addStepLog("Test Passed:: Club name Found = " + club);
				chelseRank=(clubNames.indexOf(club) + 1);
				
				
				break;

			}
		}
	  
	}

	@Then("^Find out chelse club rank$")
	public void find_out_chelse_club_rank() throws Throwable {
		System.out.println("CLub position::" + chelseRank);
		//Reporter.addStepLog("CLub position::" + chelseRank);
	  
	}

	@When("^User able to read excel data$")
	public void user_able_to_read_excel_data() throws Throwable {
	
		String excelPath="./TestData/WebTable Test Data.xlsx";
		 ColumnValue= new ArrayList<String>();
		
		ColumnValue=ExcelColumn.columnValue(excelPath,0);
		System.out.println("Value::"+ColumnValue);
		
		//Reporter.addStepLog("Excel Name::" + ColumnValue);
	  
	}

	@Then("^User able to validate match club name$")
	public void user_able_to_validate_match_club_name() throws Throwable {
	
		List<String> matchClub = new ArrayList<String>(ColumnValue);
		matchClub.retainAll(clubNames);
		System.err.println("WebTable club count: " + clubNames.size());
	
		System.err.println("Excel club count: " + ColumnValue.size());
		
		System.err.println("Matched club count: " + matchClub.size());
		
	    System.out.println("The common club name : " + matchClub);
	  
	}
	@Then("^User able to validate not match club name$")
	public void user_able_to_validate_not_match_club_name() throws Throwable {
		notMatchExcelClub = new ArrayList<> (ColumnValue);
		    notMatchExcelClub.removeAll(clubNames); 
		   
		    System.err.println("Not matched Excel club count: " + notMatchExcelClub.size());
	
		    notMatchWebTableClub = new ArrayList<> (clubNames);
		    notMatchWebTableClub.removeAll(ColumnValue); 
		    System.out.println("Not matched WebTable club name: " + notMatchWebTableClub);

		  
	}

	@Then("^user able to count not match club number$")
	public void user_able_to_count_not_match_club_number() throws Throwable {
	   
		  System.err.println("Not matched WebTable club count: " + notMatchWebTableClub.size());
		      System.out.println("Not matched Excel club name: " + notMatchExcelClub);
		   
	}

	@When("^close the browser$")
	public void close_the_browser() throws Throwable {
	   driver.quit();
	  
	}
	

}
