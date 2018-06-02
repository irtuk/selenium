package com.edwardmooreconsulting.poferries;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.edwardmooreconsulting.poferries.page.classes;

public class TestCaseDoverCalais {
	
	private WebDriver driver;
	DoverCalaisSearchPage_En searchPage;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.gecko.driver", ".\\selenium-geckodriver-firefox\\geckodriver.exe");
		driver = new FirefoxDriver();
		private String baseURL = "http://www.poferries.com/en/dover-calais";
		
		searchPage = new DoverCalaisSearchPage_En(driver);
		
		//set up a pretty view
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		searchPage
	}

}
