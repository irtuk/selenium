package apackage;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DoverCalais {

	private static WebDriver driver;
	private static String baseURL ;
	private static DoverCalaisSearchPage_En Searchpage;	
	
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
	String smallTrailer = "Trailer / Caravan > 1.8m h or > 6m l";
	String largeTrailer = "Trailer ≤ 1.8m h & ≤ 6m l";
	String noTrailer = "No trailer / Caravan";
	

	@Before
	public void Before() throws Exception {
		System.setProperty("webdriver.gecko.driver", ".\\selenium-geckodriver-firefox\\geckodriver.exe");
		driver = new FirefoxDriver();		
		baseURL = "http://www.poferries.com/en/dover-calais";
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
		Searchpage.selectGoingOutDate("14/07/2018");
		Searchpage.selectComingBackDate("21/07/2018");		
		Searchpage.selectOutboundSailing("12:55");		
		Searchpage.selectReturnSailing("14:20");
		Searchpage.selectOutboundVehicle(van);
		Searchpage.selectOutboundVehicleHeight("2.0");
		Searchpage.selectOutboundVehicleLength("3.0");		
		Searchpage.selectOutboundTrailer(largeTrailer);
		
	}
	
	
	@After
	public void cleanup() {
		driver.close();
		System.out.println("Script terminated");
	}
	

//	Car ≤ 1.8m h & ≤ 6m l
//	Car 1.8 - 2.4m h & ≤ 6 m l
//	Car > 2.4m h & / or > 6m l
//	Van
//	Motorcycle
//	Minibus
	

}
