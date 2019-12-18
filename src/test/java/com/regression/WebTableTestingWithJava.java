package com.regression;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableTestingWithJava {

	
	static	WebDriver driver;
	public static void main(String[] args) {
		 System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
		 driver = new ChromeDriver();
		 
		 driver.get("https://www.premierleague.com/tables/");
		 
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 
		 ArrayList<String> clubNames = new ArrayList<String>();

		 List<WebElement> Clubrows = driver.findElements(By.xpath("(//tbody)[1]//tr//td[3]"));
		 System.out.println("Total club count::"+ Clubrows.size());
		 for(WebElement club:Clubrows){
			 clubNames.add(club.getText().toString());
		 }
		  System.out.println(clubNames);
		  
		  for(String club:clubNames) {
		  if(club.equalsIgnoreCase("Chelsea")) {
			  System.out.println("Test Passed:: Club name Found = "+ club);
			  break;
			  
		  }


		  }
		
			  for(int i=0;i<clubNames.size();i++) {
					  
					  if (clubNames.get(i).toString().equalsIgnoreCase("Chelsea")) {
						  
						  System.out.println("Chelsea position::"+ (i+1));
					  }
					  
					
				  }
			 } 
			  
		  
		  }
		 

