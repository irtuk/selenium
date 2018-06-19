package apackage;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LarneCairnryan {
	private static WebDriver driver;
	private static String baseURL="http://qa1.poferries.com/en/larne-cairnryan";
	private static LarneCairnryanSearchPage_En mytoolbox;
	
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.gecko.driver", ".\\selenium-geckodriver-firefox\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.get(baseURL);
		mytoolbox = new LarneCairnryanSearchPage_En(driver);	
		driver.switchTo().frame("qb_cookie_consent_main");
		driver.findElement(By.id("buttonAccept"));
		driver.switchTo().defaultContent();		
		}
	
	@Test
	 public void mytest() {
	System.out.println("I made it here");
	mytoolbox.selectComingBackDate("25/06/2018");
	mytoolbox.selectOutboundPets("1");
	System.out.println("3 adults returning");
	mytoolbox.SelectOutboundSeniors("1");
	
	}	
	


@AfterClass
	public static void tearDownAfterClass() throws Exception {
//		driver.close();		
	}
}
