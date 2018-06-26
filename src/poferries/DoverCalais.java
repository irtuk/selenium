package poferries;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.Verifier;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DoverCalais {

	private static WebDriver driver;
	private static String baseURL ;
	private static DoverCalaisSearchPage_En Searchpage;	
	
	// All these do is make it possible to say "smallCar" and not have to type or paste "Car ≤ 1.8m h & ≤ 6m l"
	// remember, these are variable names so they do not need to be in quotes.
	String smallCar = "Car ≤ 1.8m h & ≤ 6m l";
	String mediumCar = "Car 1.8 - 2.4m h & ≤ 6 m l";
	String largeCar = "Car > 2.4m h & / or > 6m l";
	String van = "Van";
	String bicycle = "Bicycle";
	String motorcycle = "Motorcycle";
	String minibus = "Minibus";
	String motorhome = "Motorhome";
	String motorcyleWithSidecar = "Motorcycle with sidecar";
	String footPassenger = "No Vehicle (Foot Passenger)";
	String largeTrailer = "Trailer / Caravan > 1.8m h or > 6m l";
	String smallTrailer = "Trailer ≤ 1.8m h & ≤ 6m l";
	String noTrailer = "No trailer / Caravan";

	@Before
	public void Before() throws Exception {
		System.setProperty("webdriver.gecko.driver", ".\\selenium-geckodriver-firefox\\geckodriver.exe");
		
		//headless
	    FirefoxBinary firefoxBinary = new FirefoxBinary();
	    firefoxBinary.addCommandLineOptions("--headless");
	    System.setProperty("webdriver.gecko.driver", ".\\selenium-geckodriver-firefox\\geckodriver.exe");
	    FirefoxOptions firefoxOptions = new FirefoxOptions();
	    firefoxOptions.setBinary(firefoxBinary);
	    driver = new FirefoxDriver(firefoxOptions);
		// headless
			
		//not headless		
		//driver = new FirefoxDriver();
		
		baseURL = "http://www.poferries.com/en/dover-calais";
		//baseURL = "http://www.poferries.com/en/dover-calais";
		Searchpage = new DoverCalaisSearchPage_En(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get(baseURL);
		
		driver.switchTo().frame("qb_cookie_consent_main");
		driver.findElement(By.id("buttonAccept")).click();
		System.out.println("Should have just clicked cookie button");
		driver.switchTo().defaultContent();
		System.out.println("Should have just switched to default content");		
	}	

	@Test
	public void makeReturnDoverCalaisBooking() throws InterruptedException {		
		Searchpage.clickReturnTripRadioButton();
		Searchpage.selectGoingOutDate("02/07/2018");
		Searchpage.selectComingBackDate("09/07/2018");
		Searchpage.selectOutboundVehicle("Van");
		Searchpage.selectOutboundVehicleHeight("2.5");
		Searchpage.selectOutboundVehicleLength("6.0");
		Searchpage.selectOutboundAdults("1");
		Searchpage.UncheckSamePassengersCheckbox();
		Searchpage.selectReturnVehicle(smallCar);
		Searchpage.selectReturnAdults("4");
		Searchpage.selectReturnPets("2");		
		}
	
	
	@After
	public void cleanup() {
	//	driver.close();
	//	driver.quit();
		System.out.println("Script terminated");
	}
	
	

}
