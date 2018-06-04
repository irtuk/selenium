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
	private static DoverCalaisSearchPage_En Toolbox;	
	

	@Before
	public void Before() throws Exception {
		System.setProperty("webdriver.gecko.driver", ".\\selenium-geckodriver-firefox\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseURL = "http://www.poferries.com/en/dover-calais";
		Toolbox = new DoverCalaisSearchPage_En(driver);
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
		Toolbox.ClickReturnTripRadioButton();		
		Toolbox.selectGoingOutDate("14/07/2018");
		Toolbox.selectComingBackDate("21/07/2018");		
		Toolbox.selectOutboundSailing("12:55");		
		Toolbox.selectReturnSailing("14:20");
	}
	
	
	@After
	public void cleanup() {
		driver.close();
		System.out.println("Script terminated");
	}
	

	
	

}
