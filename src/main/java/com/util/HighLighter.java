package com.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HighLighter {
	
	static JavascriptExecutor js;
	
	public static WebElement getDrawRedColor(WebDriver driver, WebElement Element ){

		
		js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", Element);
		
		return Element;
		
}

	
	public static WebElement getDrawBlueColor(WebDriver driver, WebElement Element ){
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid blue'", Element);
		
		return Element;
		
}

	
	public static WebElement getDrawWhite(WebDriver driver, WebElement Element ){
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid white'", Element);
		
		return Element;
		
}
	
	
	public static WebElement getDrawBlueYellow(WebDriver driver, WebElement Element ){
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid yellow'", Element);
		
		return Element;
		
}
}