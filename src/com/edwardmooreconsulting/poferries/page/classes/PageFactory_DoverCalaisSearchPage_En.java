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



}
