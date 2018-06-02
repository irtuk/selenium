package com.edwardmooreconsulting.poferries.page.classes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageFactory_DoverCalaisSearchPage_En {
	
	
	@FindBy(id="SingleJourneyRadio")
	WebElement OneWayRadioButton;
	
	@FindBy(id="ReturnJourneyRadio")
	WebElement ReturnJourneyRadioButton;
	
	@FindBy(id="SingleJourneyDateTextBox")
	WebElement GoingOutDate;

	@FindBy(id="ReturnJourneyDateTextBox")
	WebElement ComingBackDate;
	
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
		ComingBackDate.clear;
		ComingBackDate.sendKeys(date);
	}


}
