package apackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;



public class DoverCalaisSearchPage_En {
	
	WebDriver driver;	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	//Journey Type
	@FindBy(id="singleJourneyRadio")
	private WebElement OneWayRadioButton;
	
	@FindBy(id="returnJourneyRadio")
	private WebElement ReturnJourneyRadioButton;
	
	@FindBy(id="singleJourneyDateTextBox")
	private WebElement GoingOutDate;

	@FindBy(id="returnJourneyDateTextBox")
	private WebElement ComingBackDate;
	
	@FindBy(id="singleJourneyTimeComboBoxSelectBoxItContainer")
	private WebElement OutboundTimeList;	
	
	@FindBy(id="returnJourneyTimeComboBoxSelectBoxItContainer")
	private WebElement ReturnTimeList;		
	
	//outbound params
	@FindBy(id="vehicleTypeOutboundComboBoxSelectBoxItContainer")
	private WebElement OutboundVehicleType;
	
	@FindBy(id="trailerOutboundComboBoxSelectBoxItContainer")
	private WebElement OutboundTrailerType;
	
	@FindBy(id="samePassengersCheckBox")
	private WebElement SamePassengersCheckbox;
	
	@FindBy(id="ou_AD_pass_comboBoxSelectBoxItArrow")
	private WebElement OutboundAdultPassengers;
	
	@FindBy(id="ou_CH_pass_comboBoxSelectBoxItArrow")
	private WebElement OutboundChildPassengers;
	
	@FindBy(id="ou_IN_pass_comboBoxSelectBoxItArrow")
	private WebElement OutboundInfantPassengers;
	
	@FindBy(id="ou_length")
	private WebElement outboundVehicleLength;

	@FindBy(id="ou_height")
	private WebElement outboundVehicleHeight;
	
	//Return params
	@FindBy(id="vehicleTypeReturnComboBoxSelectBoxItContainer")
	private WebElement ReturnVehicleType;
	
	@FindBy(id="trailerReturnComboBoxSelectBoxItContainer")
	private WebElement ReturnTrailerType;
	
	@FindBy(id="re_AD_pass_comboBox")
	private WebElement ReturnAdultPassengers;
	
	@FindBy(id="re_CH_pass_comboBox")
	private WebElement ReturnChildPassengers;
	
	@FindBy(id="re_IN_pass_comboBox")
	private WebElement ReturnInfantPassengers;
	
	@FindBy(id="re_length")
	private WebElement ReturnVehicleLength;

	@FindBy(id="re_height")
	private WebElement ReturnVehicleHeight;

	@FindBy(id="discountCodeTextBox")
	private WebElement DiscountCode;

	@FindBy(id="ou_trailerLength")
	private WebElement OutboundTrailerLength;

	@FindBy(id="ou_trailerHeight")
	private WebElement OutboundTrailerHeight;
	
	@FindBy(id="re_trailerLength")
	private WebElement ReturnTrailerLength;

	@FindBy(id="re_trailerHeight")
	private WebElement ReturnTrailerHeight;	


	
	//initialize the elements using the selenium PageFactory method
	public DoverCalaisSearchPage_En(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println("Should have just initialized the Dover Calais page search factory");		
	}
	
	//expose public methods
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
	
	public void selectReturnVehicle(String vehicleType) {
		System.out.println("Setting a return vehicle type of " + vehicleType);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.id("fareFindersubmitButton")));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vehicleTypeReturnComboBoxSelectBoxItContainer")));		
		ReturnVehicleType.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vehicleTypeReturnComboBoxSelectBoxItOptions")));
		driver.findElement(By.id("vehicleTypeReturnComboBoxSelectBoxItOptions"));
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
		
	public void selectReturnTrailer(String trailerType) {
		System.out.println("Setting a return trailer type of " + trailerType);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("selectboxit-option-anchor")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("trailerReturnComboBoxSelectBoxItContainer")));		
		OutboundTrailerType.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("trailerReturnComboBoxSelectBoxItOptions")));
		driver.findElement(By.id("trailerReturnComboBoxSelectBoxItOptions"));
		driver.findElement(By.linkText(trailerType)).click();
		
	}
	
	public void selectOutboundVehicleHeight(String height) {
		System.out.println("Setting an outbound vehicle height of " + height );
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("selectboxit-option-anchor")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ou_height")));	
		outboundVehicleHeight.click();
		outboundVehicleHeight.sendKeys(height);		
	}
	
	public void selectOutboundVehicleLength(String length) {
		System.out.println("Setting an outbound vehicle length of " + length );
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("selectboxit-option-anchor")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ou_length")));	
		outboundVehicleLength.click();
		outboundVehicleLength.sendKeys(length);		
	}

	public void selectReturnVehicleHeight(String height) {
		System.out.println("Setting an outbound vehicle height of " + height );
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("re_height")));	
		ReturnVehicleHeight.click();
		ReturnVehicleHeight.sendKeys(height);
		
	}
	
	public void selectReturnVehicleLength(String length) {
		System.out.println("Setting an outbound vehicle height of " + length );
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("re_length")));	
		ReturnVehicleLength.click();
		ReturnVehicleLength.sendKeys(length);
	}

	public void selectOutboundAdults(String adults)	{	
		System.out.println("Setting number of adults to " + adults);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("selectboxit-option-anchor")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ou_AD_pass_comboBoxSelectBoxItContainer")));		
		OutboundAdultPassengers.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ou_AD_pass_comboBoxSelectBoxItOptions")));
		driver.findElement(By.linkText(adults)).click();
	}
	
	public void selectOutboundChildren(String children) {
		System.out.println("Setting number of children to " + children);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ou_CH_pass_comboBoxSelectBoxItContainer")));		
		OutboundChildPassengers.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ou_CH_pass_comboBoxSelectBoxItOptions")));
		children = nastyChildXpathHack(children);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div/div[1]/div[1]/div/form/div/dl[4]/dd/div/ul[2]/li[2]/span/ul/li[" + children + "]")).click();
	}
	
	public void selectOutboundInfants(String infants) {	
		System.out.println("Setting number of infants to " + infants);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ou_IN_pass_comboBoxSelectBoxItContainer")));		
		OutboundInfantPassengers.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ou_IN_pass_comboBoxSelectBoxItOptions")));
		infants = nastyChildXpathHack(infants);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div/div[1]/div[1]/div/form/div/dl[4]/dd/div/ul[3]/li[2]/span/ul/li[" + infants + "]")).click();

	}
	
	public void selectReturnAdults(String adults)	{	
		System.out.println("Setting number of returning adults to " + adults);
		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("re_AD_pass_comboBoxSelectBoxIt")));		
		ReturnAdultPassengers.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("re_AD_pass_comboBoxSelectBoxIt")));
		driver.findElement(By.id("re_AD_pass_comboBoxSelectBoxItOptions"));
		driver.findElement(By.linkText(adults)).click();
	}
	
	public void selectReturnChildren(String children) {
		System.out.println("Setting number of returning children to " + children);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("selectboxit-option-anchor")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("re_CH_pass_comboBoxSelectBoxIt")));		
		ReturnChildPassengers.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("re_CH_pass_comboBoxSelectBoxIt")));
		driver.findElement(By.id("re_CH_pass_comboBoxSelectBoxItOptions"));
		driver.findElement(By.linkText(children)).click();
	}
	
	public void selectReturnInfants(String infants) {	
		System.out.println("Setting number of returning infants to " + infants);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("selectboxit-option-anchor")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("re_IN_pass_comboBoxSelectBoxIt")));		
		OutboundInfantPassengers.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("re_IN_pass_comboBoxSelectBoxIt")));
		driver.findElement(By.id("re_IN_pass_comboBoxSelectBoxItOptions"));
		driver.findElement(By.linkText(infants)).click();
	}
	
	public void selectOutboundTrailerHeight(String height) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("selectboxit-option-anchor")));
		System.out.println("Setting an outbound Trailer height of " + height );
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ou_trailerHeight")));	
		OutboundTrailerHeight.click();
		OutboundTrailerHeight.sendKeys(height);		
	}
	
	public void selectOutboundTrailerLength(String length) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("selectboxit-option-anchor")));
		System.out.println("Setting an outbound Trailer length of " + length );
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ou_trailerLength")));	
		OutboundTrailerLength.click();
		OutboundTrailerLength.sendKeys(length);		
	}
	
	public void selectReturnTrailerHeight(String height) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("selectboxit-option-anchor")));		
		System.out.println("Setting an outbound Trailer height of " + height );
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ou_trailerHeight")));	
		ReturnTrailerHeight.click();
		ReturnTrailerHeight.sendKeys(height);		
	}
	
	public void selectReturnTrailerLength(String length) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("selectboxit-option-anchor")));
		System.out.println("Setting an outbound Trailer length of " + length );
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ou_trailerLength")));	
		ReturnTrailerLength.click();
		ReturnTrailerLength.sendKeys(length);		
	}
	
	public void CheckSamePassengersCheckbox() {
		
		if (SamePassengersCheckbox.isSelected()) {
			System.out.println("Checkbox already checked. Taking no action");
		} else {
		System.out.println("Checkbox not already checked. Clicking it");
		SamePassengersCheckbox.click();
		}
		
	}
	
	public void UncheckSamePassengersCheckbox() {
		if (SamePassengersCheckbox.isSelected()) {
			System.out.println("Checkbox checked. Clicking it.");
			SamePassengersCheckbox.click();
		} else {
		System.out.println("Checkbox not already checked. Taking no action.");

		}

	}

	private String nastyChildXpathHack(String children) {
		System.out.println("Hacking xpath together. This procedure should be taken outside and shot as soon as possible...");
		int modifiedChildren = Integer.parseInt(children);
		modifiedChildren = modifiedChildren +1;
		String retval = String.valueOf(modifiedChildren);
		return retval;			
	}



}
