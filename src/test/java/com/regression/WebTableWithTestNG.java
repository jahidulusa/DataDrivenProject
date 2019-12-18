package com.regression;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.excelFactory.ExcelColumn;
import com.extentreport.BaseTest;
import com.pagefactory.WebPageFactory;


public class WebTableWithTestNG extends BaseTest{

	WebDriver driver;
	ArrayList<String> clubNames;
	WebPageFactory pf;
	String excelPath = "./TestData/WebTable Test Data.xlsx";
	ArrayList<String> ColumnValue;
	

	@BeforeSuite
	public void beforesuite() {
		System.out.println("This is before all");

	}

	@BeforeTest
	public void befortest() {
		
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@Test
	public void getWebTableData() {
				test.log(Status.INFO, "This is Test one");
				test.assignCategory( "Browser opened");
				driver.get("https://www.premierleague.com/tables/");
				pf = PageFactory.initElements(driver, WebPageFactory.class);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				System.out.println(driver.getTitle());
				test.assignCategory("Page Title::"+driver.getTitle());
				
		clubNames = new ArrayList<String>();
		
		List<WebElement> Clubrows = pf.getClubNames();
		System.out.println("Total club count::" + Clubrows.size());

		for (WebElement club : Clubrows) {
			clubNames.add(club.getText().toString());
		}
		System.out.println(clubNames);
		test.assignCategory( "Club name from webTable::"+clubNames);
		for (String club : clubNames) {
			if (club.equalsIgnoreCase("Chelsea")) {
				System.out.println("Test Passed:: Club name Found = " + club);
				test.assignCategory("Test Passed:: Club name Found = " + club);
				System.out.println("CLub position::" + (clubNames.indexOf(club) + 1));
			    test.assignCategory("CLub position::" + (clubNames.indexOf(club) + 1));
				
				break;

			}
		}
	}

	
	@Test
	   public void getExcelData() throws Throwable {
		test.log(Status.INFO, "This is Test two");
		String excelPath="./TestData/WebTable Test Data.xlsx";
		 ColumnValue= new ArrayList<String>();
		
		ColumnValue=ExcelColumn.columnValue(excelPath,0);
		System.out.println("Value::"+ColumnValue);
		
		test.assignCategory("Excel club name::"+ColumnValue);
	}

	@Test
	   public void validation() throws Throwable {
		test.log(Status.INFO, "This is test three");
		List<String> matchClub = new ArrayList<String>(ColumnValue);
		
		
		matchClub.retainAll(clubNames);
		
		System.err.println("WebTable club count: " + clubNames.size());
		test.assignCategory("WebTable club count: " + clubNames.size());
		System.err.println("Excel club count: " + ColumnValue.size());
		test.assignCategory( "Excel club count: " + ColumnValue.size());
		System.err.println("Matched club count: " + matchClub.size());
		test.assignCategory( "Matched club count: " + matchClub.size());
	    System.out.println("The common club name : " + matchClub);
	    test.assignCategory( "The common club name : " + matchClub);
	   
	  
	    
	    List<String> notMatchExcelClub = new ArrayList<> (ColumnValue);
	    notMatchExcelClub.removeAll(clubNames); 
	    System.out.println("Not matched Excel club name: " + notMatchExcelClub);
	    test.assignCategory("Not matched Excel club name: " + notMatchExcelClub);
	    System.err.println("Not matched Excel club count: " + notMatchExcelClub.size());
	    test.assignCategory( "Not matched Excel club count: " + notMatchExcelClub.size());
	    
	    List<String> notMatchClub = new ArrayList<> (clubNames);
	    notMatchClub.removeAll(ColumnValue); 
	    System.out.println("Not matched WebTable club name: " + notMatchClub);
	    test.assignCategory("Not matched WebTable club name: " + notMatchClub);
	    System.err.println("Not matched WebTable club count: " + notMatchClub.size());
	    test.assignCategory( "Not matched WebTable club count: " + notMatchClub.size());
	}



	@AfterTest
	public void teardown() {
		driver.quit();
	}

	
}