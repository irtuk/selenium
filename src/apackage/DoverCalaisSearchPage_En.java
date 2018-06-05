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
	
	@FindBy(id="singleJourneyTimeComboBoxSelectBoxItArrow")
	private WebElement OutboundTimeList;	
	
	@FindBy(id="returnJourneyTimeComboBoxSelectBoxItArrow")
	private WebElement ReturnTimeList;		
	
	//outbound params
	@FindBy(id="vehicleTypeOutboundComboBoxSelectBoxItArrow")
	private WebElement OutboundVehicleType;
	
	@FindBy(id="trailerOutboundComboBoxSelectBoxItArrow")
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

	@FindBy(id="ou_trailerLength")
	private WebElement OutboundTrailerLength;

	@FindBy(id="ou_trailerHeight")
	private WebElement OutboundTrailerHeight;
	
	//Return params
	@FindBy(id="vehicleTypeReturnComboBoxSelectBoxItArrow")
	private WebElement ReturnVehicleType;
	
	@FindBy(id="trailerReturnComboBoxSelectBoxItArrow")
	private WebElement ReturnTrailerType;
	
	@FindBy(id="re_AD_pass_comboBoxSelectBoxItArrow")
	private WebElement ReturnAdultPassengers;
	
	@FindBy(id="re_CH_pass_comboBoxSelectBoxItArrow")
	private WebElement ReturnChildPassengers;
	
	@FindBy(id="re_IN_pass_comboBoxSelectBoxItArrow")
	private WebElement ReturnInfantPassengers;
	
	@FindBy(id="re_length")
	private WebElement ReturnVehicleLength;

	@FindBy(id="re_height")
	private WebElement ReturnVehicleHeight;

	@FindBy(id="discountCodeTextBox")
	private WebElement DiscountCode;
	
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
		String objectType = "outboundVehicle";
		System.out.println("Setting an outbound vehicle type of " + vehicleType);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("selectboxit-option-anchor")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vehicleTypeOutboundComboBoxSelectBoxItContainer")));		
		OutboundVehicleType.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vehicleTypeOutboundComboBoxSelectBoxItOptions")));
		driver.findElement(By.id("vehicleTypeOutboundComboBoxSelectBoxItOptions"));
		String xpath = xpathBuilder(objectType, vehicleType);
		driver.findElement(By.xpath(xpath)).click();
		
	}
	
	public void selectReturnVehicle(String vehicleType) {
		String objectType = "returnVehicle";
		System.out.println("Setting a return vehicle type of " + vehicleType);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vehicleTypeReturnComboBoxSelectBoxItContainer")));	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vehicleTypeReturnComboBoxSelectBoxItArrow")));
		ReturnVehicleType.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vehicleTypeReturnComboBoxSelectBoxItOptions")));
		String xpath = xpathBuilder(objectType, vehicleType);
		driver.findElement(By.xpath(xpath)).click();
	}	
	
	public void selectOutboundTrailer(String trailerType) {
		String objectType = "outboundTrailer";
		System.out.println("Setting an outbound trailer type of " + trailerType);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("selectboxit-option-anchor")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("trailerOutboundComboBoxSelectBoxItContainer")));		
		OutboundTrailerType.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("trailerOutboundComboBoxSelectBoxItOptions")));
		driver.findElement(By.id("trailerOutboundComboBoxSelectBoxItOptions"));
		String xpath = xpathBuilder(objectType, trailerType);
		driver.findElement(By.xpath(xpath)).click();				
	}
		
	public void selectReturnTrailer(String trailerType) {
		String objectType = "returnTrailer";
		System.out.println("Setting a return trailer type of " + trailerType);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("selectboxit-option-anchor")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("trailerReturnComboBoxSelectBoxItContainer")));		
		ReturnTrailerType.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("trailerReturnComboBoxSelectBoxItOptions")));
		driver.findElement(By.id("trailerReturnComboBoxSelectBoxItOptions"));
		String xpath = xpathBuilder(objectType, trailerType);
		driver.findElement(By.xpath(xpath)).click();	
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
		System.out.println("Setting a return Trailer height of " + height );
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("re_trailerHeight")));	
		ReturnTrailerHeight.click();
		ReturnTrailerHeight.sendKeys(height);		
	}
	
	public void selectReturnTrailerLength(String length) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("selectboxit-option-anchor")));
		System.out.println("Setting a return Trailer length of " + length );
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("re_trailerLength")));	
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

	private String xpathBuilder ( String objectType, String objectDetail) {
		
		String returnXpath=null;
		System.out.println("Using xPath builder");
		
		switch (objectType) {
		case "outboundVehicle":
			switch (objectDetail) {
			
			case "Car ≤ 1.8m h & ≤ 6m l":
				returnXpath="/html/body/div[1]/div/div[2]/div/div[1]/div/div[1]/div[1]/div/form/div/dl[3]/dd[1]/span[2]/ul/li[1]";
				break;
			
			case "Car 1.8 - 2.4m h & ≤ 6 m l":
				returnXpath="/html/body/div[1]/div/div[2]/div/div[1]/div/div[1]/div[1]/div/form/div/dl[3]/dd[1]/span[2]/ul/li[2]";
				break;
			
			case "Car > 2.4m h & / or > 6m l":
				returnXpath="/html/body/div[1]/div/div[2]/div/div[1]/div/div[1]/div[1]/div/form/div/dl[3]/dd[1]/span[2]/ul/li[3]";
				break;
			
			case "Van":
				returnXpath="/html/body/div[1]/div/div[2]/div/div[1]/div/div[1]/div[1]/div/form/div/dl[3]/dd[1]/span[2]/ul/li[4]";
				break;
			
			case "Motorcycle":
				returnXpath="/html/body/div[1]/div/div[2]/div/div[1]/div/div[1]/div[1]/div/form/div/dl[3]/dd[1]/span[2]/ul/li[5]";
				break;
			
			case "Minibus":
				returnXpath="/html/body/div[1]/div/div[2]/div/div[1]/div/div[1]/div[1]/div/form/div/dl[3]/dd[1]/span[2]/ul/li[6]";
				break;
			
			case "Motorhome":
				returnXpath="/html/body/div[1]/div/div[2]/div/div[1]/div/div[1]/div[1]/div/form/div/dl[3]/dd[1]/span[2]/ul/li[7]";
				break;
			
			case "Bicycle":
				returnXpath="/html/body/div[1]/div/div[2]/div/div[1]/div/div[1]/div[1]/div/form/div/dl[3]/dd[1]/span[2]/ul/li[8]";
				break;
				
			case "Motorcycle with sidecar":
				returnXpath="/html/body/div[1]/div/div[2]/div/div[1]/div/div[1]/div[1]/div/form/div/dl[3]/dd[1]/span[2]/ul/li[9]";
				break;
				
			case "No Vehicle (Foot Passenger)":
				returnXpath="/html/body/div[1]/div/div[2]/div/div[1]/div/div[1]/div[1]/div/form/div/dl[3]/dd[1]/span[2]/ul/li[10]";
				break;
			
			default:
				System.out.println("Automation error. no recognised outbound vehicle");
				break;
			}

			break;
		
		case "returnVehicle":
			switch (objectDetail) {
			
			case "Car ≤ 1.8m h & ≤ 6m l":
				returnXpath="/html/body/div[1]/div/div[2]/div/div[1]/div/div[1]/div[1]/div/form/div/dl[6]/dd[1]/span[2]/ul/li[1]";
				break;
			
			case "Car 1.8 - 2.4m h & ≤ 6 m l":
				returnXpath="/html/body/div[1]/div/div[2]/div/div[1]/div/div[1]/div[1]/div/form/div/dl[6]/dd[1]/span[2]/ul/li[2]";
				break;
			
			case "Car > 2.4m h & / or > 6m l":
				returnXpath="/html/body/div[1]/div/div[2]/div/div[1]/div/div[1]/div[1]/div/form/div/dl[6]/dd[1]/span[2]/ul/li[3]";
				break;
			
			case "Van":
				returnXpath="/html/body/div[1]/div/div[2]/div/div[1]/div/div[1]/div[1]/div/form/div/dl[6]/dd[1]/span[2]/ul/li[4]";
				break;
			
			case "Motorcycle":
				returnXpath="/html/body/div[1]/div/div[2]/div/div[1]/div/div[1]/div[1]/div/form/div/dl[6]/dd[1]/span[2]/ul/li[5]";
				break;
			
			case "Minibus":
				returnXpath="/html/body/div[1]/div/div[2]/div/div[1]/div/div[1]/div[1]/div/form/div/dl[6]/dd[1]/span[2]/ul/li[6]";
				break;
			
			case "Motorhome":
				returnXpath="/html/body/div[1]/div/div[2]/div/div[1]/div/div[1]/div[1]/div/form/div/dl[6]/dd[1]/span[2]/ul/li[7]";
				break;
			
			case "Bicycle":
				returnXpath="/html/body/div[1]/div/div[2]/div/div[1]/div/div[1]/div[1]/div/form/div/dl[6]/dd[1]/span[2]/ul/li[8]";
				break;
				
			case "Motorcycle with sidecar":
				returnXpath="/html/body/div[1]/div/div[2]/div/div[1]/div/div[1]/div[1]/div/form/div/dl[6]/dd[1]/span[2]/ul/li[9]";
				break;
				
			case "No Vehicle (Foot Passenger)":
				returnXpath="/html/body/div[1]/div/div[2]/div/div[1]/div/div[1]/div[1]/div/form/div/dl[6]/dd[1]/span[2]/ul/li[10]";
				break;
			
			default:
				System.out.println("Automation error. no recognised return vehicle");
				break;
			}

			break;
		
		case "outboundTrailer":
			switch (objectDetail) {
			case "No trailer / Caravan":
				returnXpath = "/html/body/div[1]/div/div[2]/div/div[1]/div/div[1]/div[1]/div/form/div/dl[3]/dd[3]/span[2]/ul/li[1]";
				break;
			case "Trailer ≤ 1.8m h & ≤ 6m l":
				returnXpath = "/html/body/div[1]/div/div[2]/div/div[1]/div/div[1]/div[1]/div/form/div/dl[3]/dd[3]/span[2]/ul/li[2]";
				break;
			case "Trailer / Caravan > 1.8m h or > 6m l":
				returnXpath = "/html/body/div[1]/div/div[2]/div/div[1]/div/div[1]/div[1]/div/form/div/dl[3]/dd[3]/span[2]/ul/li[3]";
				break;	
			default:
				System.out.println("Automation error. no recognised outbound trailer");
				break;				
			}
			break;
		
		case "returnTrailer":
			switch (objectDetail) {
			case "No trailer / Caravan":
				returnXpath = "/html/body/div[1]/div/div[2]/div/div[1]/div/div[1]/div[1]/div/form/div/dl[6]/dd[3]/span[2]/ul/li[1]";
				break;
			case "Trailer ≤ 1.8m h & ≤ 6m l":
				returnXpath = "/html/body/div[1]/div/div[2]/div/div[1]/div/div[1]/div[1]/div/form/div/dl[6]/dd[3]/span[2]/ul/li[2]";
				break;
			case "Trailer / Caravan > 1.8m h or > 6m l":
				returnXpath = "/html/body/div[1]/div/div[2]/div/div[1]/div/div[1]/div[1]/div/form/div/dl[6]/dd[3]/span[2]/ul/li[3]";
				break;	
			default:
				System.out.println("Automation error. no recognised return trailer");
				break;				
			}
			break;
			
		case "outboundAdults":
			break;
		
		case "returnAdults":
			break;
		
		case "outboundChildren":
			break;
			
		case "returnChildren":
			break;
			
		case "outboundInfant":
			break;
			
		case "returnInfant":
			break;
			
			
		
		
		}		
		
	return returnXpath;
	}
	
}
