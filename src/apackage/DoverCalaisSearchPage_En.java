package apackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;


public class DoverCalaisSearchPage_En {
	
	WebDriver driver;	
	
	@FindBy(id="singleJourneyRadio")
	WebElement OneWayRadioButton;
	
	@FindBy(id="returnJourneyRadio")
	WebElement ReturnJourneyRadioButton;
	
	@FindBy(id="singleJourneyDateTextBox")
	WebElement GoingOutDate;

	@FindBy(id="returnJourneyDateTextBox")
	WebElement ComingBackDate;
	
	//initialize the elements using the selenium PageFactory method
	public DoverCalaisSearchPage_En(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println("Should have just initialized the page search factory");
		
		
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
