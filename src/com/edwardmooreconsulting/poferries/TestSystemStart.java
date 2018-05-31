package com.edwardmooreconsulting.poferries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSystemStart {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Initializing Web Driver");
		WebDriver Driver;
		String BaseURL = "http://www.poferries.com";
		System.setProperty("webdriver.gecko.driver", ".\\selenium-geckodriver-firefox\\geckodriver.exe");
		Driver = new FirefoxDriver();
		Driver.get(BaseURL);
		closeCookie(Driver);

		
	}

	public static void closeCookie (WebDriver Driver) {
		System.out.println("Clicking Cookie Accept");
		//WebElement CookieFrame = Driver.findElement(By.name("qb_cookie_consent_main"));
		Driver.switchTo().defaultContent();				
		Driver.switchTo().frame("qb_cookie_consent_main");
		Driver.findElement(By.xpath("//*[@id=\"buttonAccept\"]")).click();
		System.out.println("Did we Click Cookie Accept?");		
		Driver.switchTo().defaultContent();		
	}

}


