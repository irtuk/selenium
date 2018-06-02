package com.edwardmooreconsulting.framework;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;


public class DoverCalaisSearchPage_En {
	
	WebDriver driver;
	
	
	
	@FindBy(id="SingleJourneyRadio")
	WebElement OneWayRadioButton;
	
	@FindBy(id="ReturnJourneyRadio")
	WebElement ReturnJourneyRadioButton;
	
	@FindBy(id="SingleJourneyDateTextBox")
	WebElement GoingOutDate;

	@FindBy(id="ReturnJourneyDateTextBox")
	WebElement ComingBackDate;
	
	//initialize the elements using the selenium PageFactory method
	public DoverCalaisSearchPage_En(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	
	//methods
	public void clickSingleRadioButton() {
		OneWayRadioButton.click();
	}
	
	public void ClickReturnRadioButton() {
		ReturnJourneyRadioButton.click();
	}
	
	public void selectGoingOutDate(String date) {
		GoingOutDate.clear();
		GoingOutDate.sendKeys(date);
	}
	
	public void selectComingBackDate(String date) {
		ComingBackDate.clear();
		ComingBackDate.sendKeys(date);
	}	
	

}
