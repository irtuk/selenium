package apackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
	
	@FindBy(id="singleJourneyTimeComboBoxSelectBoxItContainer")
	WebElement OutboundTimeList;	
	
	@FindBy(id="returnJourneyTimeComboBoxSelectBoxItContainer")
	WebElement ReturnTimeList;	
	
	

	//initialize the elements using the selenium PageFactory method
	public DoverCalaisSearchPage_En(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println("Should have just initialized the page search factory");		
	}
	
	//methods
	public void clickSingleTripRadioButton() {
		OneWayRadioButton.click();
	}
	
	public void ClickReturnTripRadioButton() {
		ReturnJourneyRadioButton.click();
	}
	
	public void selectGoingOutDate(String date) {
		//driver.manage().timeouts().implicitlyWait(500,TimeUnit.MILLISECONDS);
		GoingOutDate.clear();
		GoingOutDate.sendKeys(date);
		GoingOutDate.sendKeys(Keys.RETURN);
	}
	
	public void selectComingBackDate(String date) {
		ComingBackDate.clear();
		ComingBackDate.sendKeys(date);
		ComingBackDate.sendKeys(Keys.RETURN);
	}
	
	public void selectOutboundSailing(String outboundTime) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("singleJourneyTimeComboBoxSelectBoxItContainer")));
		
		OutboundTimeList.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("singleJourneyTimeComboBoxSelectBoxItOptions")));		
		
		driver.findElement(By.id("singleJourneyTimeComboBoxSelectBoxItOptions"));
		driver.findElement(By.linkText(outboundTime)).click();	
	}
	
	public void selectReturnSailing(String returnTime) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("returnJourneyTimeComboBoxSelectBoxItContainer")));		
		
		ReturnTimeList.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("returnJourneyTimeComboBoxSelectBoxItOptions")));

		driver.findElement(By.id("returnJourneyTimeComboBoxSelectBoxItOptions"));
		driver.findElement(By.linkText(returnTime)).click();		
	}
	
	

	
}
