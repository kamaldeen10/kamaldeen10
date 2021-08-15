package test;


//import java.io.File;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;
//import java.util.logging.FileHandler;

//import org.openqa.selenium.TakesScreenshot;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.google.common.io.Files;

import org.openqa.selenium.support.ui.WebDriverWait;

public class Methods {
	static WebDriver driver = new ChromeDriver();
	static WebDriverWait wait = new WebDriverWait(driver, 50);
	static JavascriptExecutor js = (JavascriptExecutor) driver;
	
	//Variable
	static String url ="https://uat.e-cargoware.com/#!/login";
	static String Username = "sky.admin";
	static String Password = "Skyadmin1*";
	static String Awb_Prefix = "077";
	static String Awb_No = "65265465";
	static String Full_AwbNo = "077-6526-5465";
	static String Agent ="DHL-TEST";
	static String Origin_1 = "CGN";
	static String Destination_1 = "TLV";
	static String Origin_2 = "TLV";
	static String Destination_2 = "DXB";
	static String Pieces = "10";
	static String Gross_Wt = "100";
	static String Commodity = "CARGO";
	static String Shc = "DGR";
	static String Delivery_Date = "02/06/2021";
	static String Flight_1 ="MS5252";
	static String Flight_2 = "MS6262";
	static String Flight_Date_1 ="01/06/2021";
	static String Flight_Date_2 ="02/06/2021";
	static String SellingRate = "3";
	static String BuyingRate = "2";
	static String Delivery_Point ="CGNUPS";
	static String Status_1 = "Being Processed";
	static boolean Status = false;
	public static Object FileUtils;
 
 
//public static void getScreenshot (WebDriver driver) throws IOException
//{
	//File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    //The below method will save the screen shot in destination directory with name "screenshot.png"
   //  ((Object) FileUtils).copyFile(scrFile ,  new File("D:\\reports\\screenshot.png"));
     
//}


	
	
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
//						Thread.sleep(150);
					}
					Status = true;
					if (Status = true) { Thread.sleep(250); break; }
				} catch (Exception e) {
					continue;
				}
			}
		}
			
	}
	
	}
	
	
	public void LoadBrowserProcess ()
	{
	System.setProperty("webdriver.chromedriver","D:\\Automation\\chromedriver.exe");		
	
	//System.setProperty("webdriver.gecko.driver", "D:\\Automation\\geckodriver.exe");
	driver.manage().window().maximize();
			
			String url = "https://uat.e-cargoware.com/#!/login";;
			driver.get(url);
	}
	
	public void LoginProcess () 
	{
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@ng-model='userLogin.userName']")));
	
	driver.findElement(By.xpath("//input[@ng-model='userLogin.userName']")).sendKeys(Username);
	

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@ng-model='userLogin.password']")));
	driver.findElement(By.xpath("//input[@ng-model='userLogin.password']")).sendKeys(Password);

	driver.findElement(By.xpath("//button[@ng-click='login()']")).click();
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'ng-binding') and contains(text(), 'sky.admin')]")));
	
	//driver.findElement(By.xpath("//span[contains(@class,'ng-binding') and contains(text(), 'sky.admin')]"));
	WebElement alogin =  driver.findElement(By.xpath("//span[contains(@class,'ng-binding') and contains(text(), 'sky.admin')]"));

	String Loginname = alogin .getText();
	//used Assertion concept
	Assert.assertEquals(Loginname,Username);
	
	System.out.println(Loginname);

	
	if(Loginname.equals(Username))
	{
	System.out.println("Login Success");
	Assert.assertTrue(true);
	}
	else
	{
		Assert.assertTrue(false);
		System.out.println("Login Fail");
	}
	
	
	
			
	
}



	
	
	
	
	public  void MenuNavigateProcess ()
	{
		WebElement element1 = driver.findElement(By.xpath("//button[@ng-click='toggleSideNav()']"));	
js.executeScript("arguments[0].click()", element1);
	
		
		WebElement element2 =driver.findElement(By.xpath("//button[@ng-click='menuClick(menu)']"));
		js.executeScript("arguments[0].click()", element2);
		//wait.until(ExpectedConditions.elementToBeClickable(element2)).click();
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	
		WebElement element3 = driver.findElement(By.xpath("//span[contains(@class,'ng-binding') and contains(text(), 'RES Dashboard')]"));	
		js.executeScript("arguments[0].click()", element3);
		
	}
		
		
	
		
	

	public void CreateTabProcess()
	{
		WebElement element4 =driver.findElement(By.xpath("//button[@ng-click='showCreateTab()']"));
		js.executeScript("arguments[0].click()", element4);
		//Waittilljquesryupdated(driver);
			    //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@ng-click='showCreateTab()']")));
			   
				//driver.findElement(By.xpath("//button[@ng-click='showCreateTab()']")).click();
				//js.executeScript("window.scrollBy(0,1000)");
				
		
		WebElement element9 = driver.findElement(By.xpath("//button[@ng-click='toggleSideNav()']"));		
		js.executeScript("arguments[0].click()", element9);
		//Waittilljquesryupdated(driver);
	}
	
	public void booking_Agentdetails()
	{
		driver.findElement(By.xpath("//ecw-autocomplete[@md-search-text='tab.createRequest.agent.companyName']//input")).sendKeys(Agent);
		
        WebElement element6 =driver.findElement(By.xpath("//li[@ng-click='$mdAutocompleteCtrl.select($index)']"));
		js.executeScript("arguments[0].click()", element6);
		//Waittilljquesryupdated(driver);	
	}
	
	public void booking_Headerdetails()
	{
		driver.findElement(By.xpath("//input[@ng-model='tab.createRequest.$$awbPrefix']")).sendKeys(Awb_Prefix );
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@ng-model='tab.createRequest.$$awbNumber']")));			
		driver.findElement(By.xpath("//input[@ng-model='tab.createRequest.$$awbNumber']")).sendKeys(Awb_No);
		 
		driver.findElement(By.xpath("//ecw-autocomplete[@md-search-text='tab.createRequest.origin']//input")).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ecw-autocomplete[@md-search-text='tab.createRequest.origin']//input")));				
		driver.findElement(By.xpath("//ecw-autocomplete[@md-search-text='tab.createRequest.origin']//input")).sendKeys(Origin_1 );
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ecw-autocomplete[@md-search-text='tab.createRequest.destination']//input")));		
		driver.findElement(By.xpath("//ecw-autocomplete[@md-search-text='tab.createRequest.destination']//input")).sendKeys(Destination_2);
	}
	
	

	public void booking_FlightRoutingdetails1()
	{
	
	WebElement element5 =driver.findElement(By.xpath("//button[@ng-click='add(tab)']"));
	js.executeScript("arguments[0].click()", element5);
	//Waittilljquesryupdated(driver);	
	  driver.findElement(By.xpath("//ecw-autocomplete[@md-search-text='row.entity.origin']//input")).clear();													
		driver.findElement(By.xpath("//ecw-autocomplete[@md-search-text='row.entity.origin']//input")).sendKeys(Origin_1);
		driver.findElement(By.xpath("//ecw-autocomplete[@md-search-text='row.entity.destination']//input")).clear();
		driver.findElement(By.xpath("//ecw-autocomplete[@md-search-text='row.entity.destination']//input")).sendKeys(Destination_1);				
	driver.findElement(By.xpath("//input[@ng-model='row.entity.flight']")).sendKeys(Flight_1 );	
	//Waittilljquesryupdated(driver);
	driver.findElement(By.xpath("//descendant::input[@name='Flight'][1]//following-sibling::div//md-icon[@title='Click to open Flight Details Popup']")).click();
	// Waittilljquesryupdated(driver);														
  	driver.findElement(By.xpath("//md-dialog[contains(@class,'flight-details')]//button[text()='Search']")).click();
	//Waittilljquesryupdated(driver);	  				 
	 driver.findElement(By.xpath("//md-dialog[contains(@class,'flight-details')]//button[text()='Reset']")).click();
	//	Waittilljquesryupdated(driver);						
		driver.findElement(By.xpath("//input[@ng-model='searchCriteria.flight']")).sendKeys(Flight_1);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-dialog[contains(@class,'flight-details')]//md-datepicker[@name='from']//input")));
		 driver.findElement(By.xpath("//md-dialog[contains(@class,'flight-details')]//md-datepicker[@name='from']//input")).sendKeys(Flight_Date_1);					 
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-dialog[contains(@class,'flight-details')]//md-datepicker[@name='to']//input")));
		 driver.findElement(By.xpath("//md-dialog[contains(@class,'flight-details')]//md-datepicker[@name='to']//input")).sendKeys(Flight_Date_1);					
	 driver.findElement(By.xpath("//md-dialog[contains(@class,'flight-details')]//ecw-autocomplete[@name='origin']//input")).sendKeys(Origin_1 );	
	 //Waittilljquesryupdated(driver);
	 driver.findElement(By.xpath("//md-dialog[contains(@class,'flight-details')]//ecw-autocomplete[@name='destination']//input")).sendKeys(Destination_1);
	WebElement element11 = driver.findElement(By.xpath("//md-dialog[contains(@class,'flight-details')]//descendant::button[text()='Search'][2]"));		
	js.executeScript("arguments[0].click()", element11);	
	//Waittilljquesryupdated(driver);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-dialog[contains(@class,'flight-details')]//descendant::div[@role='grid'][2]//div[text()='MS5252']")));
	driver.findElement(By.xpath("//md-dialog[contains(@class,'flight-details')]//descendant::div[@role='grid'][2]//div[text()='MS5252']")).click();	
	
	//Waittilljquesryupdated(driver);	
	driver.findElement(By.xpath("//md-dialog[contains(@class,'flight-details')]//button[text()='Select']")).click();						
	//Waittilljquesryupdated(driver);
}
	
	public void booking_FlightRoutingdetails2()
	{
		driver.findElement(By.xpath("//descendant::ecw-autocomplete[@md-search-text='row.entity.origin'][2]//input")).clear();													
		driver.findElement(By.xpath("//descendant::ecw-autocomplete[@md-search-text='row.entity.origin'][2]//input")).sendKeys(Origin_2);
		driver.findElement(By.xpath("//descendant::ecw-autocomplete[@md-search-text='row.entity.destination'][2]//input")).clear();
		driver.findElement(By.xpath("//descendant::ecw-autocomplete[@md-search-text='row.entity.destination'][2]//input")).sendKeys(Destination_2);
	
	driver.findElement(By.xpath("//descendant::input[@ng-model='row.entity.flight'][2]")).sendKeys(Flight_2 );	
//	Waittilljquesryupdated(driver);
	driver.findElement(By.xpath("//descendant::input[@name='Flight'][2]//following-sibling::div//md-icon[@title='Click to open Flight Details Popup']")).click();
	// Waittilljquesryupdated(driver);														
  	driver.findElement(By.xpath("//md-dialog[contains(@class,'flight-details')]//button[text()='Search']")).click();
	//Waittilljquesryupdated(driver);	  				 
	 driver.findElement(By.xpath("//md-dialog[contains(@class,'flight-details')]//button[text()='Reset']")).click();
	//	Waittilljquesryupdated(driver);						
		driver.findElement(By.xpath("//input[@ng-model='searchCriteria.flight']")).sendKeys(Flight_2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-dialog[contains(@class,'flight-details')]//md-datepicker[@name='from']//input")));
		 driver.findElement(By.xpath("//md-dialog[contains(@class,'flight-details')]//md-datepicker[@name='from']//input")).sendKeys(Flight_Date_2);					 
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-dialog[contains(@class,'flight-details')]//md-datepicker[@name='to']//input")));
		 driver.findElement(By.xpath("//md-dialog[contains(@class,'flight-details')]//md-datepicker[@name='to']//input")).sendKeys(Flight_Date_2);					
	 driver.findElement(By.xpath("//md-dialog[contains(@class,'flight-details')]//ecw-autocomplete[@name='origin']//input")).sendKeys(Origin_2 );	
	// Waittilljquesryupdated(driver);	
	driver.findElement(By.xpath("//md-dialog[contains(@class,'flight-details')]//ecw-autocomplete[@name='destination']//input")).sendKeys(Destination_2);
	WebElement element13 = driver.findElement(By.xpath("//md-dialog[contains(@class,'flight-details')]//descendant::button[text()='Search'][2]"));		
	js.executeScript("arguments[0].click()", element13);	
	//Waittilljquesryupdated(driver);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-dialog[contains(@class,'flight-details')]//descendant::div[@role='grid'][2]//div[text()='MS6262']")));
	driver.findElement(By.xpath("//md-dialog[contains(@class,'flight-details')]//descendant::div[@role='grid'][2]//div[text()='MS6262']")).click();						
	//Waittilljquesryupdated(driver);	
	driver.findElement(By.xpath("//md-dialog[contains(@class,'flight-details')]//button[text()='Select']")).click();						
	//Waittilljquesryupdated(driver);			
 
		
	}
	
	
	public void booking_Shipmentdetails()
	{
		
		driver.findElement(By.xpath("//input[@ng-model='tab.createRequest.pieces']")).sendKeys(Pieces);
        driver.findElement(By.xpath("//input[@ng-model='tab.createRequest.grosswt']")).sendKeys(Gross_Wt);
 		driver.findElement(By.xpath("//input[@ng-model='tab.createRequest.commodity']")).sendKeys(Commodity);
	    driver.findElement(By.xpath("//input[@ng-model='tab.createRequest.shc']")).sendKeys(Shc);
	    
		
								 
		driver.findElement(By.xpath("//md-datepicker[@ng-model='tab.createRequest.deliverydate']//input")).clear();
		driver.findElement(By.xpath("//md-datepicker[@ng-model='tab.createRequest.deliverydate']//input")).sendKeys(Delivery_Date);
		
		
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-icon[@ng-click='getDeliveryPoint(tab.createRequest)']")));
		    WebElement element10 =driver.findElement(By.xpath("//md-icon[@ng-click='getDeliveryPoint(tab.createRequest)']"));
		    js.executeScript("arguments[0].click()", element10);
			
		 //   driver.findElement(By.xpath("//md-icon[@ng-click='getDeliveryPoint(tab.createRequest)']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@ng-model='searchCriteria.deliveryPoint']")));
		    driver.findElement(By.xpath("//input[@ng-model='searchCriteria.deliveryPoint']")).sendKeys(Delivery_Point );
		   // Waittilljquesryupdated(driver);												 
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'ui-grid-cell-contents ng-binding ng-scope') and contains(text(), 'CGNUPS')]")));
		   // Waittilljquesryupdated(driver);	
		    WebElement element15 =driver.findElement(By.xpath("//div[contains(@class,'ui-grid-cell-contents ng-binding ng-scope') and contains(text(), 'CGNUPS')]"));
		    js.executeScript("arguments[0].click()", element15);
			
			
		//Waittilljquesryupdated(driver);	
			driver.findElement(By.xpath("//button[text()='Select']")).click();						
			//Waittilljquesryupdated(driver);	
		
	}
	public void Booking_Save()
	
	{
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@ng-click='save()']")));
		driver.findElement(By.xpath("//button[@ng-click='save()']")).click();
		
		 
		System.out.println("Booking Created Succesfully");
		

	}
	}
		


