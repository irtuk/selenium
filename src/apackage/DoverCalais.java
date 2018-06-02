package apackage;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DoverCalais {

	private static WebDriver driver;
	private static String baseURL ;
	private static DoverCalaisSearchPage_En searchPage;
	
	

	@Before
	public void Before() throws Exception {
		System.setProperty("webdriver.gecko.driver", ".\\selenium-geckodriver-firefox\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseURL = "http://www.poferries.com/en/dover-calais";
		searchPage = new DoverCalaisSearchPage_En(driver);
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.switchTo().frame("qb_cookie_consent_main");
		driver.findElement(By.id("buttonAccept")).click();
		System.out.println("Should have just clicked cookie button");
		driver.switchTo().defaultContent();
		System.out.println("Should have just switched to default content");
		
	}


	@Test
	public void test1() throws InterruptedException {

		searchPage.clickSingleRadioButton();
		System.out.println("Click!");
		searchPage.ClickReturnRadioButton();
		System.out.println("Click!");
		searchPage.selectGoingOutDate("14/07/2018");
		System.out.println("Outbound Date Set");
		searchPage.selectComingBackDate("21/07/2018");
		System.out.println("Return Date Set");
		
		driver.findElement(By.xpath("//*[@id=\"singleJourneyTimeComboBoxSelectBoxItContainer\"]")).click();
		
		driver.switchTo();
		
		
		

	
	}
	
	

	
	

}
