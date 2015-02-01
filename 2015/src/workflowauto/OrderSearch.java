package workflowauto;

/**
 * TC for screen validation
 */

import java.io.IOException;
import efmsms.Task;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import workflowauto.ScreenShot;


public class OrderSearch
{
	static ScreenShot s= new ScreenShot();
	public void  ScreenData (String Ordernum) throws IOException
	{

		List<String> A = new ArrayList<String>();

		InternetExplorerDriver ie = new InternetExplorerDriver();
		ie.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// System.setProperty("webdriver.ie.driver","C:\\Users\\IBM_ADMIN\\Documents\\Automation\\EFMSWF\\IEDriverServer64.exe");

		//Load InternetExpoler Driver
		String Screen;



		//Pass URL to the Driver class
		ie.get("http://validurl:8008/ms");
		System.out.println("URL Loaded 113");


		ie.switchTo().frame("main");
		ie.findElementByName("userid").isDisplayed();
		ie.findElementByName("userid").sendKeys("validusername");
		System.out.println("Found username here. just check");

		ie.findElementByName("password").isDisplayed();
		ie.findElementByName("password").sendKeys("validpassword");
		System.out.println("Found pwd");

		ie.findElementByName("btnSubmit").isDisplayed();
		ie.findElementByName("btnSubmit").click();
		System.out.println("Click1");



		ie.findElementByName("successOK").isDisplayed();
		//	ie.findElementByXPath("//HTML/BODY/FORM[1]/CENTER/TABLE/TBODY/TR[2]/TD/CENTER/TABLE/TBODY/TR/TD/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[5]/TD/INPUT").isDisplayed();
		ie.findElementByName("successOK").click();
		//	ie.findElementByXPath("//HTML/BODY/FORM[1]/CENTER/TABLE/TBODY/TR[2]/TD/CENTER/TABLE/TBODY/TR/TD/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[5]/TD/INPUT").click();

		System.out.println("Click2");


		ie.findElementByXPath("/html/body/form/p/table/tbody/tr/td[1]/table/tbody/tr[18]/td/a").click();
		System.out.println("search screen");

		//Select dropdown = new Select(ie.findElementByXPath("/HTML/BODY/FORM/P/TABLE/TBODY/TR/TD[3]/TABLE[1]/TBODY/TR[2]/TD[2]/SELECT"));
		Select dropdown= new Select(ie.findElementByXPath("//SELECT[@name='requestType']"));
		dropdown.selectByVisibleText("Solution CR");
		System.out.println("drop down selected for 1");


		Select selectedoffer= new Select(ie.findElementByXPath("//SELECT[@name='offerType']"));
		selectedoffer.selectByVisibleText("EIS");

		String offer = selectedoffer.getFirstSelectedOption().getText();

		if (offer =="EIS")
		{
			System.out.println("Offer is EIS-- Passed");

		}


		/*	Select dropdownt= new Select(ie.findElementByXPath("//SELECT[@name='requestIdType']"));
			dropdownt.selectByVisibleText("Service Request Id");
			System.out.println("Choosen servcie id");*/


		ie.findElementByXPath("//HTML/BODY/FORM/P/TABLE/TBODY/TR/TD[3]/DIV/TABLE[3]/TBODY/TR/TD[2]/SPAN[1]/INPUT").sendKeys(Ordernum);
		System.out.println("Entering order number"+Ordernum);


		//WebDriverWait wb= new WebDriverWait(ie,180);
		WebDriverWait wb= new WebDriverWait(ie,120);
		wb.until(ExpectedConditions.elementToBeClickable(By.xpath("//INPUT[@value='Find Requests']")));
		ie.findElementByXPath("//INPUT[@value='Find Requests']").click();
		ie.findElementByXPath("//INPUT[@value='Find Requests']").click();
		System.out.println("Find button");
		wb.until(ExpectedConditions.elementToBeClickable(By.xpath("//INPUT[@value='Open']")));
		ie.findElementByXPath("//INPUT[@value='Open']").click();

		System.out.println("open order");

		ie.findElementByXPath("//html/body/p/table/tbody/tr/td[3]/table/tbody/tr[2]/td/form/table/tbody/tr/td/table/tbody/tr[1]/td[2]").isDisplayed();

		String LeadCountry = ie.findElementByXPath("//html/body/p/table/tbody/tr/td[3]/table/tbody/tr[2]/td/form/table/tbody/tr/td/table/tbody/tr[1]/td[2]").getText();
		s.getscreenshot(ie,"A_Solution_Cr_Detail");

		if (LeadCountry.matches("UNITED STATES"))
		{
			System.out.println("Lead country is Pass" + LeadCountry);
		}

		else
		{
			System.out.println("fail"+LeadCountry);
		}



		//open the  activity tab

		// got to country list tab

		ie.findElementByXPath("//html/body/p/table/tbody/tr/td[3]/table/tbody/tr[1]/td/table/tbody/tr/td[7]").isDisplayed();
		ie.findElementByXPath("//html/body/p/table/tbody/tr/td[3]/table/tbody/tr[1]/td/table/tbody/tr/td[7]").click();

		//ie.findElementByXPath("//html/body/div[1]/div/span/table/tbody/tr[2]/td[2]").isDisplayed();
		String Offer =ie.findElementByXPath("//html/body/div[1]/div/span/table/tbody/tr[2]/td[2]").getText();

		s.getscreenshot(ie,"B_Country List");

		if (Offer.matches("EIS"))
		{
			System.out.println("Offer is Pass refer Screenshot" + Offer);
		}

		else
		{
			System.out.println("fail"+Offer);


		}


		ie.findElementByXPath("//html/body/p/table/tbody/tr/td[3]/table/tbody/tr[1]/td/table/tbody/tr/td[2]").isDisplayed();
		ie.findElementByXPath("//html/body/p/table/tbody/tr/td[3]/table/tbody/tr[1]/td/table/tbody/tr/td[2]").click();
		System.out.println("Task");

		ie.findElementByXPath("//html/body/p/table/tbody/tr/td[3]/table/tbody/tr[2]/td/form/table[2]/tbody/tr/td/table/tbody/tr[4]/td[1]").isDisplayed();
		ie.findElementByXPath("//html/body/p/table/tbody/tr/td[3]/table/tbody/tr[2]/td/form/table[2]/tbody/tr/td/table/tbody/tr[4]/td[1]").click();
		WebElement FindTask =ie.findElementByXPath("//html/body/p/table/tbody/tr/td[3]/table/tbody/tr[1]/td/table/tbody/tr/td[2]/a");

		String taskname= ie.findElementByXPath("//html/body/p/table/tbody/tr/td[3]/table/tbody/tr[2]/td/form/table[2]/tbody/tr/td/table/tbody/tr[5]/td[2]").getText();
		System.out.println("came here"+ taskname);

		String taskstatus =ie.findElementByXPath("//html/body/p/table/tbody/tr/td[3]/table/tbody/tr[2]/td/form/table[2]/tbody/tr/td/table/tbody/tr[5]/td[7]").getText();
		System.out.println("Task Status"+ taskstatus);
		ie.findElementByXPath("//html/body/p/table/tbody/tr/td[3]/table/tbody/tr[2]/td/center/input[2]").click();

		ie.close();








		/*
			ie.findElementByXPath("//html/body/p/table/tbody/tr/td[3]/table/tbody/tr[1]/td/table/tbody/tr/td[2]").isDisplayed();
			ie.findElementByXPath("//html/body/p/table/tbody/tr/td[3]/table/tbody/tr[1]/td/table/tbody/tr/td[2]").click();
			System.out.println("Task");

			 ie.findElementByXPath("//html/body/p/table/tbody/tr/td[3]/table/tbody/tr[2]/td/form/table[2]/tbody/tr/td/table/tbody/tr[4]/td[1]").isDisplayed();
			  ie.findElementByXPath("//html/body/p/table/tbody/tr/td[3]/table/tbody/tr[2]/td/form/table[2]/tbody/tr/td/table/tbody/tr[4]/td[1]").click();
			 WebElement FindTask = ie.findElementByXPath("//html/body/p/table/tbody/tr/td[3]/table/tbody/tr[1]/td/table/tbody/tr/td[2]/a");

			String taskname= ie.findElementByXPath("//html/body/p/table/tbody/tr/td[3]/table/tbody/tr[2]/td/form/table[2]/tbody/tr/td/table/tbody/tr[4]/td[2]").getText();

	System.out.println("came here"+ taskname); */





	}




	public static void main (String arg[]) throws IOException

	{
		OrderSearch o = new OrderSearch();

		ReadOrder ro= new ReadOrder();
		List<String> Ordernum=ro.orderreader();
		o.ScreenData(Ordernum.get(0));

		//System.out.println(o.ScreenData(Ordernum.get(0)));

	}
}
