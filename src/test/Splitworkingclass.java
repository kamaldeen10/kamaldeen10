package test;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;

public class Splitworkingclass {
	static WebDriver driver = new ChromeDriver();

	static WebDriverWait wait = new WebDriverWait(driver, 50);
	static JavascriptExecutor js = (JavascriptExecutor) driver;
	
	//Variable
	static String url ="https://uat.e-cargoware.com";
	static String Username = "sky.admin";
	static String Password = "Skyadmin1!";
	static String Awb_Prefix = "077";
	static String Awb_No = "12141231";
	static String Full_AwbNo = "077-1214-1231";
	static String Agent ="SKY10292";	
	static String Origin_1 = "CGN";
	static String Destination_1 = "TLV";
	static String Origin_2 = "TLV";
	static String Destination_2 = "DXB";

	static String Pieces = "15";
	static String Gross_Wt = "125.0";
	static String Volume = "0.75";	
	static String Commodity = "CARGO";
	static String SHC = "AVI,";
	static String Delivery_Date = "07/07/2021";
	static String Flight_1 ="MS5252";
	static String Flight_2 = "MS6262";
	static String Flight_Date_1 ="08/07/2021";
	static String Flight_Date_2 ="08/07/2021";
	static String Delivery_Point ="CGNUPS";
	static String Producttype = "General Cargo";

	public static void Waittilljquesryupdated(WebDriver driver2) {
		// TODO Auto-generated method stub
		
	}
	
	public void WaitforReadystate () throws InterruptedException, SocketTimeoutException {
		{
		
			
			Thread.sleep(500);
			JavascriptExecutor driver = null;
			JavascriptExecutor js = (JavascriptExecutor) driver;
			for (int i=1; i<10; i++) {
				if (js == null) {
					Thread.sleep(150);
					js = (JavascriptExecutor) driver;
					continue;
				} else {
					try {
						while(!(js.executeScript("return document.readyState").equals("complete")))
						{
		//					System.out.println("dom state is" +(js.executeScript("return document.readyState")));
//							Thread.sleep(150);
						}
						boolean Status = true;
						if (Status = true) { Thread.sleep(250); break; }
					} catch (Exception e) {
						continue;
					}
				}
			}
				
		}
		
		}
	

	public static void main(String[] args) throws InterruptedException, IOException {
		 System.setProperty("webdriver.chromedriver","D:\\Automation\\driver\\Chromedriver\\chromedriver.exe");			
			
			//System.setProperty("webdriver.gecko.driver", "D:\\Automation\\geckodriver.exe");
			driver.manage().window().maximize();
					
				
				driver.get(url);
				Waittilljquesryupdated(driver);
			 	Thread.sleep(8000);
			 	Actions actions = new Actions(driver);
		//Login
				driver.findElement(By.xpath("//descendant::input[@ng-model='userLogin.userName']")).sendKeys(Username);
				driver.findElement(By.xpath("//descendant::input[@type='password']")).sendKeys(Password);
				driver.findElement(By.xpath("//descendant::button[@type='submit']")).click();
				
				Waittilljquesryupdated(driver);
	

				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
						WebElement element2 = driver.findElement(By.xpath("//descendant::button[@ng-click='menuClick(menu)'][4]"));
						js.executeScript("arguments[0].click()", element2);
						//wait.until(ExpectedConditions.elementToBeClickable(element2)).click();						
						driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
						Waittilljquesryupdated(driver);
						WebElement element3 = driver.findElement(By.xpath("//span[contains(@class,'ng-binding') and contains(text(), 'RES Dashboard')]"));	
						js.executeScript("arguments[0].click()", element3);		
						Waittilljquesryupdated(driver);
						WebElement element1 = driver.findElement(By.xpath("//button[@ng-click='toggleSideNav()']"));	
						js.executeScript("arguments[0].click()", element1);
						Waittilljquesryupdated(driver);
						
						//AWb SEARCH:
						
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@ng-click='ui.showSearch=!ui.showSearch']")));              		  
   WebElement element88 = driver.findElement(By.xpath("//button[@ng-click='ui.showSearch=!ui.showSearch']"));
   js.executeScript("arguments[0].click()", element88);
	Waittilljquesryupdated(driver);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@ng-model='bookingSearch.$$awbPrefix']")));  
   driver.findElement(By.xpath("//input[@ng-model='bookingSearch.$$awbPrefix']")).sendKeys(Awb_Prefix);
	Waittilljquesryupdated(driver);
	driver.findElement(By.xpath("//input[@ng-model='bookingSearch.$$awbNumber']")).sendKeys(Awb_No);
	Waittilljquesryupdated(driver);	
	driver.findElement(By.xpath("//input[@ng-model='bookingSearch.flight']")).sendKeys(Flight_1);
	Waittilljquesryupdated(driver);
	driver.findElement(By.xpath("//div[contains(@class ,'md-datepicker-input-container')]//input[@placeholder='Flt From']")).sendKeys(Flight_Date_1);
	driver.findElement(By.xpath("//div[contains(@class ,'md-datepicker-input-container')]//input[@placeholder='Flt To']")).sendKeys(Flight_Date_1);
	Waittilljquesryupdated(driver);
	WebElement element89 =driver.findElement(By.xpath("//button[@ng-click='searchQuoteAndBooking()']"));	
	   
	 js.executeScript("arguments[0].click()", element89);
				Waittilljquesryupdated(driver);
				Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'ui-grid-cell-contents ng-binding ng-scope') and contains(text(), Full_AwbNo )]")));
            	WebElement Awbsearch =  driver.findElement(By.xpath("//div[contains(@class,'ui-grid-cell-contents ng-binding ng-scope') and contains(text(), Full_AwbNo )]"));
           	 js.executeScript("arguments[0].click()", Awbsearch);
            	  
           	WebElement CTab =  driver.findElement(By.xpath("//button[@ng-click='showCreateTab()']"));
            js.executeScript("arguments[0].click()",  CTab);
            Waittilljquesryupdated(driver);
            Thread.sleep(8000);
           	WebElement remo =  driver.findElement(By.xpath("//md-icon[@ng-click='removeTab($event)']"));
         	 js.executeScript("arguments[0].click()",  remo);
         	 Thread.sleep(8000);
          	WebElement remo2 =  driver.findElement(By.xpath("//md-icon[@ng-click='removeTab($event)']"));
        	 js.executeScript("arguments[0].click()",  remo2);
        	 Thread.sleep(8000);
           	driver.findElement(By.xpath("//div[contains(@class,'ui-grid-cell-contents ng-binding ng-scope') and contains(text(),  Full_AwbNo)]")).click();
           	Thread.sleep(8000);
           	
            ArrayList tabs1 = new ArrayList<String> (driver.getWindowHandles());
            
        	WebElement element7  =	driver.findElement(By.xpath("//button[@ng-click='showNotes(tab)']"));
            js.executeScript("arguments[0].click()", element7);
            Waittilljquesryupdated(driver);
            
            driver.findElement(By.xpath("//md-input-container//textarea[@ng-model='notes']")).sendKeys("notes");
            Waittilljquesryupdated(driver);
           
            WebElement element8  =	driver.findElement(By.xpath("//div//button[contains(@class, 'md-primary md-raised md-button') and contains(text(), 'Save')]"));
           js.executeScript("arguments[0].click()", element8);
           Waittilljquesryupdated(driver);
           Thread.sleep(8000);
           
           
           WebElement X =		driver.findElement(By.xpath("//md-pagination-wrapper//md-tab-item[contains(@class,'md-tab ng-scope ng-isolate-scope') and contains(text(), 'Airway Bill')]"));
   		  js.executeScript("arguments[0].click()", X);
   		 Thread.sleep(3000);
   		 
         WebElement n =		driver.findElement(By.xpath("//div//button[@ng-click='generateBookingAwbReport(tab)']"));
 		  js.executeScript("arguments[0].click()", n);
 		 Thread.sleep(8000);
 		 ArrayList tabs2 = new ArrayList<String> (driver.getWindowHandles());
 		
 		 for(int i = 0; i < 10; i++) {
 			 
 			 actions.sendKeys(Keys.TAB).build().perform(); 			   
 			   Thread.sleep(1000);
 		 } 		 
 		actions.sendKeys(Keys.ENTER).build().perform();
 				
				
				
	}			
	
}
