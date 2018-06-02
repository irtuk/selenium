package com.edwardmooreconsulting.framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import com.edwardmooreconsulting.poferries.*;




public class SailingTimes {	
	
	public static void main(String CurrentPage) {
	
		System.setProperty("webdriver.gecko.driver", ".\\selenium-geckodriver-firefox\\geckodriver.exe");
		WebDriver driver;
		String baseURL;
		baseURL = "http://www.poferries.com/en/calais-dover"; 
		
		driver = new FirefoxDriver();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		

		driver.get(baseURL);
		closeCookie(driver);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"singleJourneyTimeComboBoxSelectBoxItText\"]")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div/div[1]/div[1]/div/form/div/dl[2]/dd[1]/span/span/ul/li[19]/a")).click();
		
		
		
	}

	
	public static void closeCookie (WebDriver Driver) {
		System.out.println("Clicking Cookie Accept");
		//WebElement CookieFrame = Driver.findElement(By.name("qb_cookie_consent_main"));
		Driver.switchTo().defaultContent();				
		Driver.switchTo().frame("qb_cookie_consent_main");
		Driver.findElement(By.xpath("//*[@id=\"buttonAccept\"]")).click();
		Driver.switchTo().defaultContent();		
		System.out.println("Bye Bye Cookie Window");
	}
	
	
	
}
