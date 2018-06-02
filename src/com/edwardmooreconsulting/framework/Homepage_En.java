package com.edwardmooreconsulting.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage_En {
	
	public static WebElement element = null;
	private static String baseURL = "http://www.poferries.com/en/portal"; 
	
	//return to the portal
	public static void ReturnToPortal(WebDriver driver) {
		driver.get(baseURL);
	}
	
	// LINKS FROM IMAGES
	//dover calais graphic
	private static WebElement DoverCalaisImageLink(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/article[1]/a/img"));
		return element;		
		}
	
	//hull rotterdam graphic
	private static WebElement HullRotterdamImageLink(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/article[2]/a/img"));
		return element;
		}

	//hull zebrugge graphic
	private static WebElement HullZebruggeImageLink(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/article[3]/a/img"));
		return element;
		}

	//cairnryan larne graphic
	private static WebElement CairnryanLarneImageLink(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[3]/div/div[1]/article[1]/a/img"));
		return element;
		}
	
	//liverpool dublin graphic
	private static WebElement LiverpoolDublinImageLink(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[3]/div/div[1]/article[2]/a/img"));
		return element;
		}
	
	// LINKS FROM THE MAP
	//dover calais maplink
	private static WebElement DoverCalaisMaplink(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div/svg/a[12]/path"));
		return element;
		}
	
	//hull rotterdam maplink
	private static WebElement HullRotterdamMaplink(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div/svg/a[6]/path"));
		return element;
		}

	//hull zebrugge maplink
		private static WebElement HullZebruggeMaplink(WebDriver driver) {
			element = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div/svg/a[9]/path"));
			return element;
		}

	//cairnryan larne maplink
		private static WebElement CairnryanLarneMaplink(WebDriver driver) {
			element = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div/svg/a[3]/path"));
			return element;
		}

	//liverpool dublin maplink	
		private static WebElement LiverpoolDublinMaplink(WebDriver driver) {
			element = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div/svg/a[6]/path"));
			return element;
		}

	// ONE WAY ROUTE SELECTORS
	//dover calais routeselector
		private static WebElement DoverCalaisOneWayRouteSelector(WebDriver driver) {
			element = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div/div[2]/div/form/span/ul/li[2]"));
			return element;
		}		
	
	//calais dover routeselector
		private static WebElement CalaisDoverOneWayRouteSelector(WebDriver driver) {
			element = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div/div[2]/div/form/span/ul/li[3]"));
			return element;
		}	

	//hull rotterdam routeselector
		private static WebElement HullRotterdamOneWayRouteSelector(WebDriver driver) {
			element = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div/div[2]/div/form/span/ul/li[4]"));
			return element;
		}
    
	//rotterdam hull routeselector
		private static WebElement RotterdamHullOneWayRouteSelector(WebDriver driver) {
			element = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div/div[2]/div/form/span/ul/li[5]"));
			return element;
		}

	//hull zebrugge routeselector
		private static WebElement HullZebruggeOneWayRouteSelector(WebDriver driver) {
			element = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div/div[2]/div/form/span/ul/li[6]"));
			return element;
		}	
	
	//zebrugge hull routeselector
		private static WebElement ZebruggeHullOneWayRouteSelector(WebDriver driver) {
			element = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div/div[2]/div/form/span/ul/li[7]"));
			return element;
		}

	//cairnryan larne routeselector
		private static WebElement CairnryanLarneOneWayRouteSelector(WebDriver driver) {
			element = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div/div[2]/div/form/span/ul/li[8]"));
			return element;
		}	
	
	//larne cairnryan routeselector
		private static WebElement LarneCairnryanOneWayRouteSelector(WebDriver driver) {
			element = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div/div[2]/div/form/span/ul/li[9]"));
			return element;
		}
	
	//liverpool dublin routeselector
		private static WebElement LiverpoolDublinOneWayRouteSelector(WebDriver driver) {
			element = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div/div[2]/div/form/span/ul/li[10]"));
			return element;
		}	
	
	//dublin liverpool routeselector		
		private static WebElement DublinLiverpoolOneWayRouteSelector(WebDriver driver) {
			element = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div/div[2]/div/form/span/ul/li[11]"));
			return element;
		}

	//routeSelectorGoButton
		private static WebElement RouteSelectorGoButton(WebDriver driver) {
			element = driver.findElement(By.id("go"));
			return element;
		}
	
	//public methods for clicking on the elements identified above	
	//IMAGE LINKS
	public static void ClickOnDoverCalaisImage(WebDriver driver) {
		element = DoverCalaisImageLink(driver);
		element.click();
	}
	
	public static void ClickOnHullRotterdamImage(WebDriver driver) {
		element = HullRotterdamImageLink(driver);
		element.click();
	}
	
	public static void ClickOnHullZebruggeImage(WebDriver driver) {
		element = HullZebruggeImageLink(driver);
		element.click();				
	}
	
	public static void ClickOnCairnryanLarneImageLink(WebDriver driver) {
		element = CairnryanLarneImageLink(driver);
		element.click();
	}

	public static void ClickOnLiverpoolDublinImageLink(WebDriver driver) {
		element = LiverpoolDublinImageLink(driver);
		element.click();
	}
	
	// MAP LINKS
	public static void  ClickOnDoverCalaisMapLink(WebDriver driver) {
		element = DoverCalaisMaplink(driver);
		element.click();		
	}
	
	public static void ClickOnHullRotterdamMapLink(WebDriver driver) {
		element = HullRotterdamMaplink(driver);
		element.click();
	}

	public static void ClickOnHullZebruggeMapLink(WebDriver driver) {
		element = HullZebruggeMaplink(driver);
		element.click();
	}
	
	public static void ClickOnCairnryanLarneMapLink(WebDriver driver) {
		element = CairnryanLarneMaplink(driver);
		element.click();
	}

	public static void ClickOnLiverpoolDublinMapLink(WebDriver driver) {
		element = LiverpoolDublinMaplink(driver);
		element.click();		
	}
	
	//ROUTE SELECTOR LINKS
	public static void ClickOnDoverCalaisOneWayRouteSelector (WebDriver driver) {
		element = DoverCalaisOneWayRouteSelector(driver);
		element.click();
		element = RouteSelectorGoButton (driver);
		element.click();
		
	}

	public static void ClickOnCalaisDoverOneWayRouteSelector (WebDriver driver) {
		element = CalaisDoverOneWayRouteSelector (driver);
		element.click();
		element = RouteSelectorGoButton (driver);
		element.click();					
	}
	
	public static void ClickOnHullRotterdamOneWayRouteSelector (WebDriver driver) {
		element = HullRotterdamOneWayRouteSelector (driver);
		element.click();
		element = RouteSelectorGoButton (driver);
		element.click();
	}
	
	public static void ClickOnRotterdamHullOneWayRouteSelector (WebDriver driver) {
		element = RotterdamHullOneWayRouteSelector (driver);
		element.click();
		element = RouteSelectorGoButton (driver);
		element.click();
		}

	public static void ClickOnHullZebruggeOneWayRouteSelector (WebDriver driver) {
		element = HullZebruggeOneWayRouteSelector (driver);
		element.click();
		element = RouteSelectorGoButton(driver);
		element.click();	
	}
	
	public static void ClickOnZebruggeHullOneWayRouteSelector (WebDriver driver) {
		element = ZebruggeHullOneWayRouteSelector (driver);
		element.click();
		element = RouteSelectorGoButton(driver);
		element.click();
	}
	
	public static void ClickOnCairnryanLarneOneWayRouteSelector (WebDriver driver) {
		element = CairnryanLarneOneWayRouteSelector(driver);
		element.click();
		element = RouteSelectorGoButton(driver);
		element.click();
	}
	
	public static void ClickOnLarneCairnryanOneWayRouteSelector (WebDriver driver) {
		element = LarneCairnryanOneWayRouteSelector(driver);
		element.click();
		element = RouteSelectorGoButton(driver);
		element.click();
	}
	
	public static void ClickOnLiverpoolDublinOneWayRouteSelector (WebDriver driver) {
		element = LiverpoolDublinOneWayRouteSelector (driver);
		element.click();
		element = RouteSelectorGoButton(driver);
		element.click();
	}
	
	public static void ClickOnDublinLiverpoolOneWayRouteSelector (WebDriver driver) {
		element = DublinLiverpoolOneWayRouteSelector(driver);
		element.click();
		element = RouteSelectorGoButton(driver);
		element.click();
		}
	




}

