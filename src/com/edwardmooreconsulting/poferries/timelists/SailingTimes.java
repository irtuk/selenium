package com.edwardmooreconsulting.poferries.timelists;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;



public class SailingTimes {	
	
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", ".\\selenium-geckodriver-firefox\\geckodriver.exe");
		WebDriver driver;
		String baseURL;
		baseURL = "http://www.poferries.com/en/calais-dover"; 
		driver = new FirefoxDriver();
		driver.get(baseURL);
		closeCookie(driver);
		driver.manage().window().maximize();
		

		
		driver.findElement(By.id("singleJourneyTimeComboBoxSelectBoxItText")).click();
		
		
		// this one correctly gets all the options in the list
		//String xPathSelectOptions = "//*[@id=\"singleJourneyTimeComboBoxSelectBoxItOptions\"]";
		
		//this statement opens the list up
		driver.findElement(By.xpath("//*[@id=\"singleJourneyTimeComboBoxSelectBoxItText\"]")).click();
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div/div[1]/div[1]/div/form/div/dl[2]/dd[1]/span/span/ul/li[19]/a")).click();
		
		
		//List<WebElement> options = driver.findElements(By.xpath(xPathSelectOptions));
		//List<WebElement> myList = new Select(driver.findElement(By.id("singleJourneyTimeComboBox"))).getOptions();
		//for(int i=0;i<myList.size();i++)
		//{
	    //System.out.println("Option Value : " + myList.get(i).getAttribute("value"));
	    //System.out.println("Display Text : " + myList.get(i).getText());
		//}		
		//System.out.println("Ok lets try and do something : 1");
		//driver.findElement(By.xpath("//*ul[@id='singleJourneyTimeComboBox']/li[@data-val='20:35']")).click();

		//System.out.println("Ok lets try and do something : 2");
		//driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div/div[1]/div[1]/div/form/div/dl[2]/dd[1]/span/span/ul/li[4]")).click();
			
		//driver.findElement(By.xpath("//ul[@id = 'singleJourneyTimeComboBoxSelectBoxItOptions']/li[@data-val = '06:45']")).click();
		
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
