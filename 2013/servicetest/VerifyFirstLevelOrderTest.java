package com.mask.servicetest;

import org.testng.annotations.Test;
import org.openqa.selenium.*;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

//import org.h2.command.dml.Select;
import org.json.JSONException;
import org.openqa.selenium.By;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class VerifyFirstLevelOrderTest {
  
	// @Test(priority=1)
  public void f() throws MalformedURLException, JSONException {
	// TODO Auto-generated method stub 
	 	ResponseEntity<?> result2=null; 
	 
	//	String endpointUrl="http://localhost:8080/restservices/bmzzordermanagement/v1/ClientRequest/ABCCCC112222"; 
		
		String endpointUrl="http://someservice.vci.baa.com:31468/restservices/bmszzordermanagement/v1/clientRequests/ABCCCC112222";
		result2=restGetRequest(endpointUrl); 
		System.out.println("The response is"+result2);
		
/*		JSONObject obk = new JSONObject(result2.toString());
		System.out.println("Rest response"+	obk.get("sABNumber"));
		System.out.println("Rest response"+	obk.get("customerName"));
			*/
		
		JsonParser j= new JsonParser();
		j.Jsondata();
		List <String> jsondata = new ArrayList<String>();
		jsondata =j.Jsondata();
		
		Dbdemo d  = new Dbdemo();
		d.DBData();	
		List <String> dbbase = new ArrayList<String>();
		dbbase=d.DBData();
		
		System.out.println("Rest response"+ jsondata);
		System.out.println("DB response" + dbbase);
		if(jsondata.containsAll(dbbase))
		{
			System.out.println("pass");
		}
		
		}
	
	
	//@Test (priority=2)
 public	static void LanchApp()  
	{

		 InternetExplorerDriver ie = new InternetExplorerDriver();
		//static String Ordernum= "AABB12323";
		
		
			  //Pass URL to the Driver class
			   ie.get("http://bmszz-uat.bzz.sbc.com:8008/ms"); 
	
				System.out.println("URL Loaded 123");
				
			//	assertEquals(ie.getTitle()," Managed Services");
	
		ie.switchTo().frame("main");
			ie.findElementByName("userid").isDisplayed();
		    ie.findElementByName("userid").sendKeys("MASK_aaaa6q"); 
			System.out.println("Found username here. just check"); 

			ie.findElementByName("password").isDisplayed(); 
			ie.findElementByName("password").sendKeys("MASK_aaaa6q); 
			System.out.println("Found pwd"); 

			ie.findElementByName("btnSubmit").isDisplayed(); 
			ie.findElementByName("btnSubmit").click(); 
			System.out.println("Click1");
			
			
			ie.findElementByName("successOK").isDisplayed(); 
			ie.findElementByName("successOK").click();
			
			ie.findElementByXPath("/html/body/form/p/table/tbody/tr/td[1]/table/tbody/tr[18]/td/a").isDisplayed();
	    	ie.findElementByXPath("/html/body/form/p/table/tbody/tr/td[1]/table/tbody/tr[18]/td/a").click();
			

			
			ie.findElementByXPath("//SELECT[@name='requestType']").isDisplayed();
		
		//	Select dropdown= new Select(ie.findElementByXPath("//SELECT[@name='requestType']"));
		//	dropdown.selectByVisibleText("Solution CR");
			System.out.println("drop down selected for 1");
			
			ie.findElementByXPath("//HTML/BODY/FORM/P/TABLE/TBODY/TR/TD[3]/DIV/TABLE[3]/TBODY/TR/TD[2]/SPAN[1]/INPUT").sendKeys("CON071115162155");
			System.out.println("Entering order number");
			
			
			WebDriverWait wb= new WebDriverWait(ie,180);
			wb.until(ExpectedConditions.elementToBeClickable(By.xpath("//INPUT[@value='Find Requests']")));
			ie.findElementByXPath("//INPUT[@value='Find Requests']").isDisplayed();
			ie.findElementByXPath("//INPUT[@value='Find Requests']").click();
			ie.findElementByXPath("//INPUT[@value='Find Requests']").click();
			
			
			wb.until(ExpectedConditions.elementToBeClickable(By.xpath("//INPUT[@value='Open']")));
			
			if (ie.findElementByXPath("//INPUT[@value='Open']").isDisplayed())
		
			ie.findElementByXPath("//INPUT[@value='Open']").click();
			
			System.out.println("open order");
			
			ie.close();
			
					
			
	}
			

  
	  static ResponseEntity<?> restGetRequest(String endpointUrl) 
		{ 
	 
			HttpStatus _httpStatus = null; 
			Boolean er=null; 
			 String re=null; 
			String _id = null; 
	 
			RestTemplate _resttemplate=new RestTemplate(new HttpComponentsClientHttpRequestFactory()); 
			ResponseEntity<?> result=null; 
			RestTemplate restTemplate = new RestTemplate(); 
			//public static Logger log =Logger.getLogger(GetPermissions_Success_API.class); 
			ResponseEntity<?> response= null; 
			ResponseEntity<?> response1= null; 
	 
			HttpHeaders httpHeaders = new HttpHeaders(); 
		    httpHeaders.set("Accept", MediaType.APPLICATION_JSON_VALUE); 
		    HttpEntity<?> httpEntity = new HttpEntity<>(httpHeaders); 
		   // ResponseEntity<?> response = null; 
		    try 
		    { 
		        response = restTemplate.exchange(endpointUrl, HttpMethod.GET, httpEntity, String.class, _id); 
	 
		    //gets the body of the response 
		       re= response.getBody().toString(); 
	//	    System.out.println("The response body is"+re); 
	 
	 
		    } 
		    catch (Exception e) 
		    { 
		        if (e.toString().contains("500")) 
		        { 
		            _httpStatus = HttpStatus.METHOD_NOT_ALLOWED; 
		        } 
				if (e.toString().contains("404")) 
		        { 
		            _httpStatus = HttpStatus.CONFLICT; 
		        } 
	 
		    } 
		    return response; 
		}
  
  
  
}


