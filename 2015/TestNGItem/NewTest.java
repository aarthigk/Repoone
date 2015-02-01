package TestNGItem;

import static org.testng.AssertJUnit.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Sanity.ReadOrder;
import Sanity.ScreenShot;

public class NewTest {


	  
	  static InternetExplorerDriver ie = new InternetExplorerDriver();
		//static String Ordernum= "aaawww";
		
		static ScreenShot s= new ScreenShot();
		@Test
		public static void Urlloader() throws IOException{
				
			  //Pass URL to the Driver class
			   ie.get("http://validurl");
				System.out.println("URL Loaded 123");
				
				assertEquals(ie.getTitle(),"valid ttitle");
				
				s.getscreenshot(ie,"1_Launching_URL");
				login();
		}
		
		@Test (timeOut=8000)
		public static void login() throws IOException{ 
			
			ie.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
			try {
			ie.switchTo().frame("main");
			ie.findElementByName("userid").isDisplayed();
		    ie.findElementByName("userid").sendKeys("valid");
			System.out.println("Found username here. just check"); 

			ie.findElementByName("password").isDisplayed(); 
			ie.findElementByName("password").sendKeys("valid");
			System.out.println("Found pwd"); 

			ie.findElementByName("btnSubmit").isDisplayed(); 
			ie.findElementByName("btnSubmit").click(); 
			System.out.println("Click1");
			s.getscreenshot(ie,"2_User_Name");
			
			
			ie.findElementByName("successOK").isDisplayed(); 
			ie.findElementByName("successOK").click();
				
			s.getscreenshot(ie,"3_Logged");
			
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			SearchOrder();
		}
		
		 
		public static void SearchOrder() throws IOException{
			
			ReadOrder f= new ReadOrder();
				
			List<String> forder=f.orderreader();
			
			String Ordernum=forder.get(0);
			
			ie.findElementByXPath("/html/body/form/p/table/tbody/tr/td[1]/table/tbody/tr[18]/td/a").click();
			System.out.println("search screen");
			
			//Select dropdown = new Select(ie.findElementByXPath("/HTML/BODY/FORM/P/TABLE/TBODY/TR/TD[3]/TABLE[1]/TBODY/TR[2]/TD[2]/SELECT"));
			Select dropdown= new Select(ie.findElementByXPath("//SELECT[@name='requestType']"));
			dropdown.selectByVisibleText("Service Request");
			System.out.println("drop down selected for 1");
			
			ie.findElementByXPath("//HTML/BODY/FORM/P/TABLE/TBODY/TR/TD[3]/DIV/TABLE[3]/TBODY/TR/TD[2]/SPAN[1]/INPUT").sendKeys(Ordernum);
			System.out.println("Entering order number");
			
			s.getscreenshot(ie,"4_Enter_Order_Number");
			
			
			WebDriverWait wb= new WebDriverWait(ie,180);
			wb.until(ExpectedConditions.elementToBeClickable(By.xpath("//INPUT[@value='Find Requests']")));
			ie.findElementByXPath("//INPUT[@value='Find Requests']").click();
			ie.findElementByXPath("//INPUT[@value='Find Requests']").click();
			wb.until(ExpectedConditions.elementToBeClickable(By.xpath("//INPUT[@value='Open']")));
			ie.findElementByXPath("//INPUT[@value='Open']").click();
			
			System.out.println("open order");
					s.getscreenshot(ie,"5_Search_order");
			SrCriticalDate();
		}
  }

