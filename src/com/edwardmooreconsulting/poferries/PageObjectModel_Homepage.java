package com.edwardmooreconsulting.poferries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjectModel_Homepage {
	
	public WebElement LarneDot (WebDriver Driver) {
	WebElement myElement;
	myElement = Driver.findElement(By.linkText("/larne-cairnryan"));
	return myElement;
	}
	
	
	

}
