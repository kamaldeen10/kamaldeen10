package test;

import static org.testng.Assert.assertTrue;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
//import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import de.redsix.pdfcompare.PdfComparator;



public class Practise {
	
	static WebDriver driver = new ChromeDriver();
	static WebDriverWait wait = new WebDriverWait(driver, 50);
	static JavascriptExecutor js = (JavascriptExecutor) driver;
	
	//Variable
	static String url ="https://uat.e-cargoware.com";
	static String Username = "sky.admin";
	static String Password = "Skyadmin1!";
	static String Awb_Prefix = "077";
	static String Awb_No = "24072053";
	static String Full_AwbNo = "077-2407-2053";
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
	static String Flight_Date_1 ="08/08/2021";
	static String Flight_Date_2 ="08/08/2021";
	static String Delivery_Point ="CGNUPS";
	static String Producttype = "General Cargo";
	static String Priority = "3";
	static String Security = "K";	
	static boolean Status = false;
	static String Status_1 = "Being Processed";
	static String VerifyBookingconfirm = " Booking Confirmation ";
	static String Buyamt = "312.50";
	static String Sellamt = "312.50";
	static String Othercharge = "250.00";
	static String Totaldue = "562.50";
	
	
	public static void Waittilljquesryupdated(WebDriver driver) throws InterruptedException, SocketTimeoutException {
//		JavascriptExecutor js = null;
		 boolean Status = false;
		Thread.sleep(500);
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
	


	public static void main(String[] args) throws InterruptedException, IOException {
		   System.setProperty("webdriver.chromedriver","D:\\Automation\\chromedriver.exe");		
			
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
            	//Waittilljquesryupdated(driver);				
				// Actions act = new Actions(driver);
           
           	
          
  		  
         
      
          //  actions.sendKeys(Keys.TAB).build().perform();
		//  actions.sendKeys(Keys.TAB).build().perform();
       
        
    //    driver.findElement(By.xpath("//button[@ng-click='showNotes(tab)']")).sendKeys(selectAll);
       // actions.sendKeys(Keys.CONTROL , "s").build().perform();
       //    	WebElement remo =  driver.findElement(By.xpath("//md-icon[@ng-click='removeTab($event)']"));
       //  	 js.executeScript("arguments[0].click()",  remo);
         	 Thread.sleep(8000);
          
           	
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
    		  Waittilljquesryupdated(driver);
    		  Thread.sleep(5000);
    		  
    		  String Winhand1 = driver.getWindowHandle(); 

              WebElement n =		driver.findElement(By.xpath("//div//button[@ng-click='generateBookingAwbReport(tab)']"));
              		  js.executeScript("arguments[0].click()", n);
              		 Thread.sleep(12000);
              	//	ArrayList tabs = new ArrayList (driver.getWindowHandles());
              	//	System.out.println(tabs.size());
              		
              		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
              	    newTab.remove(Winhand1);
              		driver.switchTo().window(newTab.get(0));          		
              		
              		
              			 System.out.println("New window has been opened.");
              			String newURL = driver.getCurrentUrl();
              		
            	          System.out.println(newURL);
            	          WebElement ab  =  driver.findElement(By.xpath("//pdf-viewer[@id='viewer']"));
            	          
           	           String s = ab.getText();
           	          System.out.println(s);
           	       Thread.sleep(1000);
           	          
            	      	actions.keyDown(ab ,Keys.CONTROL).sendKeys("p").build().perform();
            	      	Thread.sleep(1000);
            	    	actions.keyDown(ab ,Keys.CONTROL).sendKeys("s").build().perform();
            	          
            	         	Thread.sleep(1000);
            	           	
            	      //	driver.findElement(By.xpath("//descendant::title[contains(text(), 'MAWB')]")).click();
            	    //	driver.findElement(By.xpath("//descendant::title[contains(text(), 'MAWB')]")).getText();
                 	/*	 System.out.println(pdftext);
            	          actions.keyDown(Keys.CONTROL).sendKeys(String.valueOf('\u0053')).perform();        
            	          
            	          
            	          Thread.sleep(1000);
            	          
            	         actions.sendKeys(Keys.ENTER).build().perform();
            	          
            	    actions.sendKeys(Keys.CONTROL , "s").build().perform();
            	         
            	          
                 		String File1 =	"C:\\Users\\arif\\Downloads\\Latest\\AirwaybillExpected.pdf";
                 		String File2 = newURL;
                 		 String Result = "C:\\Users\\arif\\Downloads\\Latest\\Result\\result";
                 		 
                 		
                 		new PdfComparator(File1, File2).compare().writeTo(Result);
                 	   System.out.println("Process complted");
                 		 
                 	 
                 	  
                 		 
                 	//	  WebElement Q =		driver.findElement(By.xpath("//*[@id='download']"));
                 		//	 js.executeScript("arguments[0].click()", Q);
                 	
                 		//	actions.sendKeys(Keys.TAB ).build().perform();
                 		//	actions.sendKeys(Keys.TAB ).build().perform();
                 		 
                 	//	 String s = Keys.chord(Keys.CONTROL, "s");
                     
              		 
             
              	/*	 
              		for(String actual: handles) {
              		if(!actual.equalsIgnoreCase(Winhand1)) {
              		//Switch to the opened tab
              		driver.switchTo().window(actual);
              		              	            //your actions with the new window, e.g.
              	            String newURL = driver.getCurrentUrl();
              	          System.out.println(newURL);
              	          String pdftext =	driver.findElement(By.xpath("//descendant::title[contains(text(), 'MAWB')]")).getText();
                   		 System.out.println(pdftext);
                   		 
                   		 String s = Keys.chord(Keys.CONTROL, "s");
              	        }
              	    }
              		
              	//	actions.sendKeys(Keys.TAB ).build().perform();
              	//	driver.findElement(By.xpath("//descendant::title[contains(text(), 'MAWB')]")).click();
              		//driver.close();             	    
              		 
              		driver.switchTo().window(Winhand1);
              		 			   
              		/*actions.sendKeys(Keys.ENTER).build().perform();
              		 for(int i = 0; i < 8; i++) {
              	
              			 actions.sendKeys(Keys.TAB ).build().perform(); 			   
              			   Thread.sleep(2000);
              		 } 		 
              		actions.sendKeys(Keys.ENTER).build().perform();
    		  
    		  /*
          	WebElement C =	 	driver.findElement(By.xpath("//md-pagination-wrapper//md-tab-item[contains(@class,'md-tab ng-scope ng-isolate-scope') and contains(text(), 'Epouch')]"));
            js.executeScript("arguments[0].click()", C);
            Waittilljquesryupdated(driver);
            Thread.sleep(5000);
           	WebElement B =		driver.findElement(By.xpath("//descendant::md-select[@ng-model='row.productid']"));
  		  js.executeScript("arguments[0].click()", B);	
  		Waittilljquesryupdated(driver);
  		Thread.sleep(2000);
            WebElement As =		driver.findElement(By.xpath("//md-option[@ng-click='changeProduct(type,row)']//div[contains(@class , 'md-text ng-binding') and contains(text(), 'AWB')]"));
    		  js.executeScript("arguments[0].click()", As);
    		  Waittilljquesryupdated(driver);
    		  Thread.sleep(2000);
    		  
    		 
     WebElement P =	driver.findElement(By.xpath("//div[contains(@class,'file-input-button')]//input[@ng-click='validateFileSelection(row,$event)']"));
     js.executeScript("arguments[0].click()", P);
     
    		      //    actions.sendKeys(Keys.TAB).build().perform();
    			//	  actions.sendKeys(Keys.TAB).build().perform();
    			//	  actions.sendKeys(Keys.ENTER).build().perform();
    				  
           	Thread.sleep(5000);
           	Runtime.getRuntime().exec("D:\\Automation\\Project\\Autoit\\Epouch.exe");
           	
        	driver.findElement(By.xpath("//button[@ng-click='save()']")).click();
        	Waittilljquesryupdated(driver);
        	 WebElement N =		driver.findElement(By.xpath("//md-pagination-wrapper//md-tab-item[contains(@class,'md-tab ng-scope ng-isolate-scope') and contains(text(), 'Booking')]"));
   		  js.executeScript("arguments[0].click()", N);
   			Waittilljquesryupdated(driver);
   			
   			/*      	
           	//-WebElement Res_Verify_AwbNosearch ;		
  	      	WebElement BookingStatusCheck1 = driver.findElement(By.xpath("//span[contains(@class,'booking-status md-input ng-binding flex') and contains(text(), 'Being Processed')]"));
	      		Waittilljquesryupdated(driver);
	      		String BkgStatus1 = BookingStatusCheck1.getText();
	      		System.out.println("Booking status  is " + BkgStatus1); 		
	      		 Assert.assertEquals(BkgStatus1, Status_1);
      		 
	  //   AIRWAYBILL TAB:
	    	 
	      		 WebElement X =		driver.findElement(By.xpath("//md-pagination-wrapper//md-tab-item[contains(@class,'md-tab ng-scope ng-isolate-scope') and contains(text(), 'Airway Bill')]"));
	      		  js.executeScript("arguments[0].click()", X);
	      		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	      		Waittilljquesryupdated(driver);
	      			
	      		driver.findElement(By.xpath("//md-input-container//textarea[@ng-model='tab.awbRequest.airwaybill.$$accountingInformation']")).sendKeys("ACCOUNTING INFO");
	      		Waittilljquesryupdated(driver);
	      driver.findElement(By.xpath("//md-input-container//textarea[@ng-model='tab.awbRequest.airwaybill.$$handlingInformation']")).sendKeys("HANDLING INFO"); 
	      Waittilljquesryupdated(driver);	
	      driver.findElement(By.xpath("//md-autocomplete-wrap//div//input[@aria-label='Shipper']")).sendKeys("TESTSHIPPER");
	      		Waittilljquesryupdated(driver);
	      		driver.findElement(By.xpath("//li[@ng-click='$mdAutocompleteCtrl.select($index)']")).click();
	      		Waittilljquesryupdated(driver);
	      		driver.findElement(By.xpath("//md-autocomplete-wrap//div//input[@aria-label='Consignee']")).sendKeys("TESTCONSIGNEE");
	      		Waittilljquesryupdated(driver);
	      		driver.findElement(By.xpath("//li[@ng-click='$mdAutocompleteCtrl.select($index)']")).click();
	      		Waittilljquesryupdated(driver);
	
	      	   
	      driver.findElement(By.xpath("//button[@ng-click='saveAWBCharges(tab)']")).click();
	  	Waittilljquesryupdated(driver);	
	  //PRICNIG TAB:
	      WebElement B =		driver.findElement(By.xpath("  //md-pagination-wrapper////md-tab-item[contains(@class,'md-tab ng-scope ng-isolate-scope') and contains(text(), 'Pricing')]"));
  		  js.executeScript("arguments[0].click()", B);
  		Waittilljquesryupdated(driver);
  		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
  		 WebElement Cost = 	driver.findElement(By.xpath("//tr//td[contains(@class,'text-align-right pd5 header-size ng-binding') and contains(text(), '618.75')]"));
  		 WebElement Sell = 	driver.findElement(By.xpath(" //tr//td[contains(@class,'text-align-right pd5 header-size ng-binding') and contains(text(), '912.50')]"));
  	   WebElement TotAmt = driver.findElement(By.xpath("//div//md-input-container[@class = 'header-size mr-r0 layout-gt-xs-row flex md-input-has-value']//input[@ng-model='tab.createRequest.chargesheader.totAmnt']"));
  		WebElement VatAmt = driver.findElement(By.xpath("//div//md-input-container[@class = 'header-size mr-r0 layout-gt-xs-row flex md-input-has-value']//input[@ng-model='tab.createRequest.chargesheader.vatAmnt']"));
  		  WebElement LocalCostAmt = driver.findElement(By.xpath("//md-input-container[@class ='header-size mr-r0 layout-row flex md-input-has-value']//input[@ng-model='tab.createRequest.chargesheader.$$localCostAmnt']"));
  		 WebElement Commison =	driver.findElement(By.xpath("//div//input[@ng-model='tab.createRequest.gsaAgentCommission']"));
  		 WebElement Margin = driver.findElement(By.xpath("  //div//input[@class='text-align-right flex']"));
  						   
  		  String Cost1 = Cost.getAttribute("value");	
  		System.out.println("Cost1 is " + Cost1);
  		 String Sell1 = Sell.getAttribute("value");	
   		System.out.println("Sell1 is " + Sell1);	
   		String TotAmt1 = TotAmt.getAttribute("value");	
   		System.out.println("Totamt is " + TotAmt1);	
   		String VatAmt1 = VatAmt.getAttribute("value");	
   		System.out.println("VatAmt is " + VatAmt1);	
   		String LocalCostAmt1 = LocalCostAmt.getAttribute("value");	
   		System.out.println("LocalCostAmt is " + LocalCostAmt1);	
   		String Commison1 = Commison.getAttribute("value");	
   		System.out.println("Commison is " + Commison1);	
   		String Margin1 = Margin.getAttribute("value");	
   		System.out.println("Margin is " + Margin1);	
   		
   	 WebElement c =		driver.findElement(By.xpath("  //md-pagination-wrapper////md-tab-item[contains(@class,'md-tab ng-scope ng-isolate-scope') and contains(text(), 'Booking')]"));
		  js.executeScript("arguments[0].click()", c);
			Waittilljquesryupdated(driver);
			
			driver.findElement(By.xpath("//button[@ng-click='sendFFR(tab)']")).click();
			Waittilljquesryupdated(driver);
			driver.findElement(By.xpath("//button[@ng-click='send()']")).click();
			Waittilljquesryupdated(driver);
			driver.findElement(By.xpath("//button[@ng-click='sendFWB(tab)']")).click();
			Waittilljquesryupdated(driver);

   		
   		/*
  						 
  						 
  						 
	      		/*
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'ui-grid-cell-contents ng-binding ng-scope') and contains(text(), Full_AwbNo)]")));
            	WebElement Awbsearch =  driver.findElement(By.xpath("//div[contains(@class,'ui-grid-cell-contents ng-binding ng-scope') and contains(text(), Full_AwbNo)]"));
            	Waittilljquesryupdated(driver);
            	if(Awbsearch.isDisplayed()){
				    System.out.println("AwbNo searchverify is Pass");  
				}
				else {
				    System.out.println("AwbNo searchverify is Fail");  
				}
            	*/
           
           /*		           					
					
         	               WebElement Verify_Originsearch1 =  driver.findElement(By.xpath("//descendant::div[contains(@class,'ui-grid-cell-contents ng-binding ng-scope') and contains(text(), 'CGN')][1]"));
        	            	Waittilljquesryupdated(driver);         	            	
        	            	String Verify_Origin_search_List1 = Verify_Originsearch1.getText();
        	            	 System.out.println( Verify_Origin_search_List1);
        	                Assert.assertEquals(Verify_Origin_search_List1,Origin_1);
        	                
        	                WebElement Verify_Destinationsearch1 =  driver.findElement(By.xpath("//descendant::div[contains(@class,'ui-grid-cell-contents ng-binding ng-scope') and contains(text(), 'DXB')][1]"));
        	            	Waittilljquesryupdated(driver);         	            	
        	            	String Verify_Destination_search_List1 = Verify_Destinationsearch1.getText();
        	            	 System.out.println(Verify_Destination_search_List1);
        	                Assert.assertEquals(Verify_Destination_search_List1,Destination_2);
					
        	                WebElement Verify_Fligthsearch1 =  driver.findElement(By.xpath("//descendant::div[contains(@class,'ui-grid-cell-contents ng-binding ng-scope') and contains(text(), 'MS5252')][1]"));
         	            	Waittilljquesryupdated(driver);         	            	
         	            	String Verify_FLight_search_List1 = Verify_Fligthsearch1.getText();
         	            	 System.out.println(Verify_FLight_search_List1);
         	                Assert.assertEquals(Verify_FLight_search_List1,Flight_1);		
					
        	                


                            WebElement Verify_FligthDatesearch1 =  driver.findElement(By.xpath("//span[contains(@class,'ng-binding') and contains(text(), '06/07/2021')]"));
         	            	Waittilljquesryupdated(driver);         	            	
         	            	String Verify_FLightDate_search_List1 = Verify_FligthDatesearch1.getText();
         	            	 System.out.println(Verify_FLightDate_search_List1);
         	                Assert.assertEquals(Verify_FLightDate_search_List1,Flight_Date_1);
							
							
							WebElement Verify_Piecesearch1 =  driver.findElement(By.xpath("//descendant::span[contains(@class,'text-align-right ng-binding') and contains(text(), '15')]"));
         	            	Waittilljquesryupdated(driver);         	            	
         	            	String Verify_Piece_search_List1 = Verify_Piecesearch1.getText();
         	            	 System.out.println(Verify_Piece_search_List1);
         	                Assert.assertEquals(Verify_Piece_search_List1,Pieces);
							
							WebElement Verify_Groswtsearch1 =  driver.findElement(By.xpath("//descendant::span[contains(@class,'text-align-right ng-binding') and contains(text(), '125.0')]"));
         	            	Waittilljquesryupdated(driver);         	            	
         	            	String Verify_Grosswt_search_List1 = Verify_Groswtsearch1.getText();
         	            	 System.out.println(Verify_Grosswt_search_List1);
         	                Assert.assertEquals(Verify_Grosswt_search_List1,Gross_Wt);
							
							WebElement Verify_Volsearch1 =  driver.findElement(By.xpath("//descendant::span[contains(@class,'text-align-right ng-binding') and contains(text(), '0.75')]"));
         	            	Waittilljquesryupdated(driver);         	            	
         	            	String Verify_Vol_search_List1 = Verify_Volsearch1.getText();
         	            	 System.out.println(Verify_Vol_search_List1);
         	                Assert.assertEquals(Verify_Vol_search_List1,Volume);
							
							WebElement Verify_Agentsearch1 =  driver.findElement(By.xpath("//descendant::div[contains(@class,'ui-grid-cell-contents ng-binding ng-scope') and contains(text(), 'SKY10292')]"));
         	            	Waittilljquesryupdated(driver);         	            	
         	            	String Verify_Agent_search_List = Verify_Agentsearch1.getText();
         	            	 System.out.println( Verify_Agent_search_List);
         	                Assert.assertEquals( Verify_Agent_search_List,Agent);
							
							WebElement Verify_Productsearch =  driver.findElement(By.xpath("//descendant::div[contains(@class,'ui-grid-cell-contents ng-binding ng-scope') and contains(text(), 'General Cargo')]"));
         	            	Waittilljquesryupdated(driver);         	            	
         	            	String Verify_Product_search_List =Verify_Productsearch.getText();
         	            	 System.out.println( Verify_Product_search_List);
         	                Assert.assertEquals( Verify_Product_search_List,Producttype);
							
							
							
							WebElement Verify_SHCsearch1 =  driver.findElement(By.xpath("//descendant::div[contains(@class,'align-items-center display-flex overlay-dropdown-wrapper ng-binding flex') and contains(text(), 'AVI,')]"));
         	            	Waittilljquesryupdated(driver);         	            	
         	            	String Verify_SHC_search_List1 = Verify_SHCsearch1.getText();
         	            	 System.out.println( Verify_SHC_search_List1);
         	                Assert.assertEquals( Verify_SHC_search_List1,SHC);
							
							WebElement Verify_Securitysearch1 =  driver.findElement(By.xpath("//span//descendant::div[contains(text(), 'K')]"));
         	            	Waittilljquesryupdated(driver);         	            	
         	            	String Verify_Security_search_List1 = Verify_Securitysearch1.getText();
         	            	 System.out.println( Verify_Security_search_List1);
         	                Assert.assertEquals( Verify_Security_search_List1,Security);
					
							WebElement Verify_BkgStatussearch1 =  driver.findElement(By.xpath("//descendant::div[contains(@class,'align-items-center display-flex ng-binding flex') and contains(text(), 'Being Processed')]"));
         	            	Waittilljquesryupdated(driver);         	            	
         	            	String Verify_Bkgstatus_search_List1 = Verify_BkgStatussearch1.getText();
         	            	 System.out.println( Verify_Bkgstatus_search_List1);
         	               // Assert.assertEquals( Verify_Bkgstatus_search_List1,Status_1);
         	                
                     */
         	              
         	      		//driver.switchTo().window(Winhand1);
         	      	///	 Waittilljquesryupdated(driver);
         	      	//	WebElement BookingStatusCheck1 = driver.findElement(By.xpath("//span[contains(@class,'booking-status md-input ng-binding flex') and contains(text(), 'Being Processed')]"));
         	      	//	Waittilljquesryupdated(driver);
         	      	//	String BkgStatus1 = BookingStatusCheck1.getText();
         	      	//	System.out.println("Booking status  is " + BkgStatus1);
							
							

	}
	

}
