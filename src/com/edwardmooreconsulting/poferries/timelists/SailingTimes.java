package com.edwardmooreconsulting.poferries.timelists;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SailingTimes {	
	
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", ".\\selenium-geckodriver-firefox\\geckodriver.exe");
		WebDriver driver;
		String baseURL;
		baseURL = "http://www.poferries.com/en/calais-dover"; 
		driver = new FirefoxDriver();
		driver.get(baseURL);		
		String xPathSelectOptions = "//*[@id=\"singleJourneyTimeComboBoxSelectBoxItOptions\"]";
		driver.findElement(By.xpath("//*[@id=\"singleJourneyTimeComboBoxSelectBoxItText\"]")).click();
		List<WebElement> options = driver.findElements(By.xpath(xPathSelectOptions));
		for(int i=0;i<options.size();i++)
			{
		    System.out.println("Option Value : " + options.get(i).getAttribute("value"));
		    System.out.println("Display Text : " + options.get(i).getText());
			}
	}

}
