package workflowauto;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;

import org.openqa.selenium.ie.InternetExplorerDriver;



public class Login {
	
	static InternetExplorerDriver ie = new InternetExplorerDriver();
	static String Ordernum= "assa111";

	static ScreenShot s= new ScreenShot();
 	static Logger log= Logger.getLogger("sanityLogger");
	
	public static void Urlloader() throws IOException{
			
		  //Pass URL to the Driver class
		   ie.get("http://validurle:8008/arts"); 
		
			System.out.println("URL Loaded 123");
	    	log.debug("Entering  Uat");
			
		
			
			s.getscreenshot(ie,"1_Launching_URL");
			login();
	}
	
	
	public static void login() throws IOException{ 
		
		ie.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
		try {
		ie.switchTo().frame("main");
		ie.findElementByName("userid").isDisplayed();
	    ie.findElementByName("userid").sendKeys("validname"); 
		System.out.println("Found username here. just check"); 
		log.debug("Entering UserName");

		ie.findElementByName("password").isDisplayed(); 
		ie.findElementByName("password").sendKeys("validname"); 
		System.out.println("Found pwd"); 
		log.debug("Entering Password");

		ie.findElementByName("btnSubmit").isDisplayed(); 
		ie.findElementByName("btnSubmit").click(); 
		System.out.println("Click1");
		s.getscreenshot(ie,"2_User_Name");
		log.debug("Taking ss of usre name page");
		
		
		ie.findElementByName("successOK").isDisplayed(); 
		ie.findElementByName("successOK").click();
		log.debug("Clicking Sucess ok");
		
			
		s.getscreenshot(ie,"3_Logged");
		log.debug("Taking ss of Sucess ok");
		
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	

}
