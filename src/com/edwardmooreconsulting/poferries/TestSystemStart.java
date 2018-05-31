package com.edwardmooreconsulting.poferries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSystemStart {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver Driver;
		String BaseURL = "http://www.poferries.com";
		System.setProperty("webdriver.gecko.driver", ".\\selenium-geckodriver-firefox\\geckodriver.exe");
		Driver = new FirefoxDriver();
		Driver.get(BaseURL);
		
		Driver.close();

	}

}
