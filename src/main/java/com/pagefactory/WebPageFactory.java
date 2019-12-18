package com.pagefactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public  class WebPageFactory {

	/*
	final WebDriver driver;
	
	public WebPageFactory(WebDriver driver) {
		
		this.driver=driver;
	}*/
	
	@FindBy(how = How.XPATH, using = "(//tbody)[1]//tr//td[3]")
	 private List<WebElement> clubNames;
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Sign in')]")
	 private WebElement signInBtn;
	@FindBy(how = How.XPATH, using = "//*[@id='ism-email']")
	 private WebElement userEmail;
	@FindBy(how = How.XPATH, using = "//*[@id='ism-password']")
	 private WebElement userPassWord;
	@FindBy(how = How.XPATH, using = "(//*[contains(text(),'Sign in')])[2]")
	 private WebElement okBtn;
	@FindBy(how = How.XPATH, using = "(//a[@href='/tables'])[2]")
	 private WebElement tableLink;
	public List<WebElement> getClubNames() {
		return clubNames;
	}
	public WebElement getSignInBtn() {
		return signInBtn;
	}
	public WebElement getUserEmail() {
		return userEmail;
	}
	public WebElement getUserPassWord() {
		return userPassWord;
	}
	public WebElement getOkBtn() {
		return okBtn;
	}
	public WebElement getTableLink() {
		return tableLink;
	}
	

	
	
	
}
