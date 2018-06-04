package apackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class DoverCalaisSearchPage_En {
	
	WebDriver driver;	
	
	//Journey Type
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
	
	//outbound params
	@FindBy(id="vehicleTypeOutboundComboBoxSelectBoxItContainer")
	WebElement OutboundVehicleType;
	
	@FindBy(id="trailerOutboundComboBoxSelectBoxItContainer")
	WebElement OutboundTrailerType;
	
	@FindBy(id="samePassengersCheckBox")
	WebElement SamePassengersCheckbox;
	
	@FindBy(id="ou_AD_pass_comboBoxSelectBoxItContainer")
	WebElement OutboundAdultPassengers;
	
	@FindBy(id="ou_CH_pass_comboBoxSelectBoxItContainer")
	WebElement OutboundChildPassengers;
	
	@FindBy(id="ou_IN_pass_comboBoxSelectBoxItContainer")
	WebElement OutboundInfantPassengers;
	
	@FindBy(id="ou_length")
	WebElement outboundVehicleLength;

	@FindBy(id="ou_height")
	WebElement outboundVehicleHeight;
	
	//Return params
	@FindBy(id="vehicleTypeReturnComboBoxSelectBoxItContainer")
	WebElement ReturnVehicleType;
	
	@FindBy(id="trailerReturnComboBoxSelectBoxItContainer")
	WebElement ReturnTrailerType;
	
	@FindBy(id="re_AD_pass_comboBoxSelectBoxItContainer")
	WebElement ReturnAdultPassengers;
	
	@FindBy(id="re_CH_pass_comboBoxSelectBoxItContainer")
	WebElement ReturnChildPassengers;
	
	@FindBy(id="re_IN_pass_comboBoxSelectBoxItContainer")
	WebElement ReturnInfantPassengers;
	
	@FindBy(id="re_length")
	WebElement returnVehicleLength;

	@FindBy(id="re_height")
	WebElement returnVehicleHeight;

	@FindBy(id="discountCodeTextBox")
	WebElement discountCode;
	
	
	
	//initialize the elements using the selenium PageFactory method
	public DoverCalaisSearchPage_En(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println("Should have just initialized the Dover Calais page search factory");		
	}
	
	//methods
	public void clickSingleTripRadioButton() {
		System.out.println("Selecting one way radio button");
		OneWayRadioButton.click();
	}
	
	public void clickReturnTripRadioButton() {
		System.out.println("Selecting return trip radio button");
		ReturnJourneyRadioButton.click();
	}
	
	public void selectGoingOutDate(String date) {
		System.out.println("Setting outbound date");
		GoingOutDate.clear();
		GoingOutDate.sendKeys(date);
		GoingOutDate.sendKeys(Keys.RETURN);
	}
	
	public void selectComingBackDate(String date) {
		System.out.println("Setting return date");
		ComingBackDate.clear();
		ComingBackDate.sendKeys(date);
		ComingBackDate.sendKeys(Keys.RETURN);
	}
	
	public void selectOutboundSailing(String outboundTime) {
		System.out.println("Setting outbound time");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("selectboxit-option-anchor")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("singleJourneyTimeComboBoxSelectBoxItContainer")));
		OutboundTimeList.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("singleJourneyTimeComboBoxSelectBoxItOptions")));		
		driver.findElement(By.id("singleJourneyTimeComboBoxSelectBoxItOptions"));
		driver.findElement(By.linkText(outboundTime)).click();	
	}
	
	public void selectReturnSailing(String returnTime) {
		System.out.println("Setting return time");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("selectboxit-option-anchor")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("returnJourneyTimeComboBoxSelectBoxItContainer")));		
		ReturnTimeList.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("returnJourneyTimeComboBoxSelectBoxItOptions")));
		driver.findElement(By.id("returnJourneyTimeComboBoxSelectBoxItOptions"));
		driver.findElement(By.linkText(returnTime)).click();		
	}
	
	public void selectOutboundVehicle(String vehicleType) {
		System.out.println("Setting an outbound vehicle type of " + vehicleType);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("selectboxit-option-anchor")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vehicleTypeOutboundComboBoxSelectBoxItContainer")));		
		OutboundVehicleType.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vehicleTypeOutboundComboBoxSelectBoxItOptions")));
		driver.findElement(By.id("vehicleTypeOutboundComboBoxSelectBoxItOptions"));
		driver.findElement(By.linkText(vehicleType)).click();		
	}
	
	public void selectOutboundTrailer(String trailerType) {
		System.out.println("Setting an outbound trailer type of " + trailerType);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("selectboxit-option-anchor")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("trailerOutboundComboBoxSelectBoxItContainer")));		
		OutboundTrailerType.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("trailerOutboundComboBoxSelectBoxItOptions")));
		driver.findElement(By.id("trailerOutboundComboBoxSelectBoxItOptions"));
		driver.findElement(By.linkText(trailerType)).click();
		
	}
	
	public void selectOutboundVehicleHeight(String height) {
		System.out.println("Setting an outbound vehicle height of " + height );
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ou_height")));	
		outboundVehicleHeight.click();
		outboundVehicleHeight.sendKeys(height);
		
	}
	
	public void selectOutboundVehicleLength(String length) {
		System.out.println("Setting an outbound vehicle length of " + length );
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ou_length")));	
		outboundVehicleLength.click();
		outboundVehicleLength.sendKeys(length);


		
	}

	public void selectReturnVehicleHeight(String height) {
		System.out.println("Setting an outbound vehicle height of " + height );
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("re_height")));	
		returnVehicleHeight.click();
		returnVehicleHeight.sendKeys(height);
		
	}
	
	public void selectReturnVehicleLength(String length) {
		System.out.println("Setting an outbound vehicle height of " + length );
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("re_length")));	
		returnVehicleLength.click();
		returnVehicleLength.sendKeys(length);
	}

	public void selectOutboundAdults(String adults)	{	
		System.out.println("Setting number of adults to " + adults);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("selectboxit-option-anchor")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ou_AD_pass_comboBoxSelectBoxIt")));		
		OutboundAdultPassengers.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ou_AD_pass_comboBoxSelectBoxIt")));
		driver.findElement(By.id("ou_AD_pass_comboBoxSelectBoxItOptions"));
		driver.findElement(By.linkText(adults)).click();
	}
	
	public void selectOutboundChildren(String children) {
		System.out.println("Setting number of children to " + children);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("selectboxit-option-anchor")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ou_CH_pass_comboBoxSelectBoxIt")));		
		OutboundChildPassengers.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ou_CH_pass_comboBoxSelectBoxIt")));
		driver.findElement(By.id("ou_CH_pass_comboBoxSelectBoxItOptions"));
		driver.findElement(By.linkText(children)).click();
	}
	
	public void selectOutboundInfants(String infants) {	
		System.out.println("Setting number of infants to " + infants);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("selectboxit-option-anchor")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ou_IN_pass_comboBoxSelectBoxIt")));		
		OutboundInfantPassengers.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ou_IN_pass_comboBoxSelectBoxIt")));
		driver.findElement(By.id("ou_IN_pass_comboBoxSelectBoxItOptions"));
		driver.findElement(By.linkText(infants)).click();
	}






}
