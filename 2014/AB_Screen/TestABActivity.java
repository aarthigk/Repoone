package AB_SCREEN;

import java.io.FileInputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import AB_Screen.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestABActivity {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//	AB_Main.getOrderNumber("C:\\Users\\TEST_ADMIN\\Desktop\\Demo.xlsx", "Sheet1",0,1);

		navigation n = new navigation();
		List<String> A = new ArrayList<String>();
		A = n.ScreenData("AABBC15061308589");
		System.out.println("Screen values :: " +A);

//navigation nb = new navigation();

		DB_fetch db = new DB_fetch();
//db.IsEthernet("AABBC16040795500");AABBC16032192821
		List<String> B = new ArrayList<String>();
		B = db.DBData("AABBC15061308589");

//nb.DBData("AABBC15041691232");

//System.out.print(n.ScreenData("AABBC15100157344"));
//List<String> B = new ArrayList<String>();
//B = nb.DBData("AABBC16033094166");
		System.out.print("DB Values :: " +B);

		if(A.equals(B))
		{
			System.out.println("Pass");
		}

		else
			System.out.println("Pass");

	}




	public List<String> ScreenData(String Ordernum)
	{
		List<String> A = new ArrayList<String>();
		//System.setProperty("webdriver.ie.driver","C:\\bzzmWF\\IEDriverServer.exe");
		InternetExplorerDriver ie = new InternetExplorerDriver();
		// ie.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ie.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.setProperty("webdriver.ie.driver","C:\\bzzmWF\\IEDriverServer.exe");
		//Load InternetExpoler Driver
		String Screen;



		//Pass URL to the Driver class
		ie.get("http://bzzmms-uat.azxc.sbc.com:8008/ms");
		//	ie.get("https://www.yapp.com");

		System.out.println("URL Loaded");

		//ie.get("http://bzzmms-uat.hydc.sbc.com:8008/ms");
		//System.out.println("URL Loaded");


		ie.switchTo().frame("main");

		ie.findElementByName("userid").sendKeys("MASKID");
		System.out.println("Found username here. just check");

		ie.findElementByName("password").isDisplayed();
		ie.findElementByName("password").sendKeys("MASKPASS");
		System.out.println("Found pwd");

		ie.findElementByName("btnSubmit").isDisplayed();
		ie.findElementByName("btnSubmit").click();
		System.out.println("Click1");

		//ie.findElementByXPath("//HTML/BODY/FORM[1]/CENTER/TABLE/TBODY/TR[2]/TD/CENTER/TABLE/TBODY/TR/TD/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[5]/TD/INPUT").isDisplayed();
		//	ie.findElementByXPath("//HTML/BODY/FORM[1]/CENTER/TABLE/TBODY/TR[2]/TD/CENTER/TABLE/TBODY/TR/TD/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[5]/TD/INPUT").click();
		//System.out.println("Click1");

		ie.findElementByName("successOK").isDisplayed();
		//	ie.findElementByXPath("//HTML/BODY/FORM[1]/CENTER/TABLE/TBODY/TR[2]/TD/CENTER/TABLE/TBODY/TR/TD/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[5]/TD/INPUT").isDisplayed();
		ie.findElementByName("successOK").click();
		//	ie.findElementByXPath("//HTML/BODY/FORM[1]/CENTER/TABLE/TBODY/TR[2]/TD/CENTER/TABLE/TBODY/TR/TD/TABLE/TBODY/TR[2]/TD/TABLE/TBODY/TR[5]/TD/INPUT").click();

		System.out.println("Click2");


		ie.findElementByXPath("/html/body/form/p/table/tbody/tr/td[1]/table/tbody/tr[18]/td/a").click();
		System.out.println("search screen");

		//Select dropdown = new Select(ie.findElementByXPath("/HTML/BODY/FORM/P/TABLE/TBODY/TR/TD[3]/TABLE[1]/TBODY/TR[2]/TD[2]/SELECT"));
		Select dropdown= new Select(ie.findElementByXPath("//SELECT[@name='requestType']"));
		dropdown.selectByVisibleText("Service Request");
		System.out.println("drop down selected for 1");

	/*	Select dropdownt= new Select(ie.findElementByXPath("//SELECT[@name='requestIdType']"));
		dropdownt.selectByVisibleText("Service Request Id");
		System.out.println("Choosen servcie id");*/


		ie.findElementByXPath("//HTML/BODY/FORM/P/TABLE/TBODY/TR/TD[3]/DIV/TABLE[3]/TBODY/TR/TD[2]/SPAN[1]/INPUT").sendKeys(Ordernum);
		System.out.println("Entering order number");


		WebDriverWait wb= new WebDriverWait(ie,180);
		wb.until(ExpectedConditions.elementToBeClickable(By.xpath("//INPUT[@value='Find Requests']")));
		ie.findElementByXPath("//INPUT[@value='Find Requests']").click();
		ie.findElementByXPath("//INPUT[@value='Find Requests']").click();
		wb.until(ExpectedConditions.elementToBeClickable(By.xpath("//INPUT[@value='Open']")));
		ie.findElementByXPath("//INPUT[@value='Open']").click();
		System.out.println("open order");

		//open the AB  tab


		ie.findElementByXPath("//HTML/BODY/FORM/P/TABLE/TBODY/TR/TD[3]/TABLE[1]/TBODY/TR/TD[5]/A").click();
//		System.out.println("go to AB");
		// choose radio button of first component


		int i=2;
		boolean loopfound =true;



		do
		{
			String findrow = "/html//body/form/p/table/tbody/tr/td[3]/table[2]/tbody/tr/td/table/tbody/tr["+i+"]/td[1]/input[1]";
			String sort = "html/body/form/p/table/tbody/tr/td[3]/table[2]/tbody/tr/td/table/tbody/tr[1]/th[5]/a";
			ie.findElementByXPath("//HTML/BODY/FORM/P/TABLE/TBODY/TR/TD[3]/TABLE[1]/TBODY/TR/TD[5]/A").click();

			//		WebDriverWait wait=new WebDriverWait(ie, 120);
			//	wait.until(ExpectedConditions.textToBePresentInElement(By.xpath("html/body/form/p/table/tbody/tr/td[3]/center[1]/span/input"), "Open"));


			System.out.println("go to AB");

			try
			{
				if(!(ie.findElementByXPath(findrow).isDisplayed()))
				{
					System.out.println("not found " );
					ie.close();
					return A ;
				}


			}catch(Exception e)
			{
				ie.close();
				return A ;




			}


			//ie.findElementByXPath(findrow).isDisplayed();
			ie.findElementByXPath(sort).click();
			//-aarthi  ScreenShot.CaptureScreenShot(ie, "ABScreen");//
			ie.findElementByXPath(findrow).click();

			String OrderType =	ie.findElementByXPath("//HTML/BODY/FORM/P/TABLE/TBODY/TR/TD[3]/TABLE[2]/TBODY/TR/TD/TABLE/TBODY/TR["+i+"]/TD[2]").getText();


			System.out.println(OrderType.trim());

			String ActionType =ie.findElementByXPath("//html/body/form/p/table/tbody/tr/td[3]/table[2]/tbody/tr/td/table/tbody/tr["+i+"]/td[3]").getText();;
			System.out.println(ActionType.trim());

			String ActivityId = ie.findElementByXPath("//html/body/form/p/table/tbody/tr/td[3]/table[2]/tbody/tr/td/table/tbody/tr["+i+"]/td[5]").getText();
			//		System.out.println(ActivityId);

			ie.findElementByXPath("//HTML/BODY/FORM/P/TABLE/TBODY/TR/TD[3]/CENTER[1]/SPAN/INPUT").click();
			//			System.out.println("Open first activity button");



			//ie.findElementByXPath("html/body/form/p/table/tbody/tr/td[3]/table[2]/tbody/tr/td/table/tbody/tr[2]/td[1]").click();
			//	System.out.println("choose first radio button");


			//capture data in screen while opening
	/*
		String OrderType1 =	ie.findElementByXPath("//HTML/BODY/FORM/P/TABLE/TBODY/TR/TD[3]/TABLE[2]/TBODY/TR/TD/TABLE/TBODY/TR[2]/TD[2]").getText();
		System.out.println(OrderType1);

		String ActionType1 =ie.findElementByXPath("//html/body/form/p/table/tbody/tr/td[3]/table[2]/tbody/tr/td/table/tbody/tr[2]/td[3]").getText();;
		System.out.println(ActionType1);

		String ActivityId1 = ie.findElementByXPath("//html/body/form/p/table/tbody/tr/td[3]/table[2]/tbody/tr/td/table/tbody/tr[2]/td[5]").getText();
		System.out.println(ActivityId1);
	*/
			//	ie.findElementByXPath("//HTML/BODY/FORM/P/TABLE/TBODY/TR/TD[3]/CENTER[1]/SPAN/INPUT").click();
			//System.out.println("Open first activity button");


			//Go to LHS service details
			ie.findElementByXPath("//HTML/BODY/FORM/P/TABLE/TBODY/TR/TD[1]/TABLE/TBODY/TR[38]/TD/A").isDisplayed();
			ie.findElementByXPath("//HTML/BODY/FORM/P/TABLE/TBODY/TR/TD[1]/TABLE/TBODY/TR[38]/TD/A").click();

			//	System.out.println("pickin Serivce details LHS");

			//AB tab navigation
	/*
		ie.findElementByXPath("//HTML/BODY/FORM/P/TABLE/TBODY/TR/TD[3]/TABLE[1]/TBODY/TR/TD[5]/A").click();

		ie.findElementByXPath("html/body/form/p/table/tbody/tr/td[3]/table[2]/tbody/tr/td/table/tbody/tr[3]/td[1]").click();
		System.out.println("choose 2nd radio button");

		String OrderTypea =	ie.findElementByXPath("//HTML/BODY/FORM/P/TABLE/TBODY/TR/TD[3]/TABLE[2]/TBODY/TR/TD/TABLE/TBODY/TR[3]/TD[2]").getText();
		System.out.println(OrderTypea);

		String ActionTypea =ie.findElementByXPath("//html/body/form/p/table/tbody/tr/td[3]/table[2]/tbody/tr/td/table/tbody/tr[3]/td[3]").getText();;
		System.out.println(ActionTypea);

		String ActivityIda = ie.findElementByXPath("//html/body/form/p/table/tbody/tr/td[3]/table[2]/tbody/tr/td/table/tbody/tr[3]/td[5]").getText();
		System.out.println(ActivityIda);


    ie.findElementByXPath("//HTML/BODY/FORM/P/TABLE/TBODY/TR/TD[3]/CENTER[1]/SPAN/INPUT").click();
    System.out.println("Open 2nd activity button");


		//goin to LHS for 2nd component

		ie.findElementByXPath("//HTML/BODY/FORM/P/TABLE/TBODY/TR/TD[1]/TABLE/TBODY/TR[38]/TD/A").isDisplayed();
		ie.findElementByXPath("//HTML/BODY/FORM/P/TABLE/TBODY/TR/TD[1]/TABLE/TBODY/TR[38]/TD/A").click();

		System.out.println("pickin Serivce details LHS");

		//AB tab navigation

		ie.findElementByXPath("//HTML/BODY/FORM/P/TABLE/TBODY/TR/TD[3]/TABLE[1]/TBODY/TR/TD[5]/A").click();

		ie.findElementByXPath("html/body/form/p/table/tbody/tr/td[3]/table[2]/tbody/tr/td/table/tbody/tr[4]/td[1]").click();
		System.out.println("choose first radio button");

		String OrderTypeb =	ie.findElementByXPath("//HTML/BODY/FORM/P/TABLE/TBODY/TR/TD[3]/TABLE[2]/TBODY/TR/TD/TABLE/TBODY/TR[4]/TD[2]").getText();
		System.out.println(OrderTypeb);

		String ActionTypeb =ie.findElementByXPath("//html/body/form/p/table/tbody/tr/td[3]/table[2]/tbody/tr/td/table/tbody/tr[4]/td[3]").getText();;

		System.out.println(ActionTypeb);

		String ActivityIdb = ie.findElementByXPath("//html/body/form/p/table/tbody/tr/td[3]/table[2]/tbody/tr/td/table/tbody/tr[4]/td[5]").getText();
		System.out.println(ActivityIdb);


		ie.findElementByXPath("//HTML/BODY/FORM/P/TABLE/TBODY/TR/TD[3]/CENTER[1]/SPAN/INPUT").click();
		System.out.println("Open first activity button");*/

			A.add(OrderType.trim());
			A.add(ActionType.trim());
			//	A.add(ActivityId);

	/*	A.add(OrderTypea);
		A.add(ActionTypea);
		A.add(ActivityIda);

		A.add(OrderTypeb);
		A.add(ActionTypeb);
		A.add(ActivityIdb);*/


			i++;

			//aarthi	ScreenShot S = new ScreenShot();
//		S.CaptureScreenShot(ie, "screenShotName");


		} while (loopfound);

//		System.out.println(A);

		return A;
	}

	public List DBData(String Ordernum)
	{
		List<String> B = new ArrayList<String>();
		// List<MSOrderType> C = new ArrayList<MSOrderType>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		System.out.println("dbconnect");
		String env="UAT";

		try {
			Properties prop1 = new Properties();
			prop1.load(new FileInputStream("C:\\bzzmwf\\jars\\dbprop.prop"));
			String url = null;
			String userName = null;
			String password = null;
			String ActivityId;
			String ActionTypeName;
			String OrderType=null;
			String Posoption =null;


			if (env.equalsIgnoreCase("UAT")) {
				url = prop1.getProperty("UAT_URL");
				userName = prop1.getProperty("UAT_USER_ID");
				password = prop1.getProperty("UAT_PASSWORD");
			}

			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, userName, password);
			pstmt = conn.prepareStatement("select * from table");
			pstmt.setString(1, Ordernum);


			ResultSet rs1=pstmt.executeQuery();
			while(rs1.next())
			{


				//	System.out.println("OrderType :: " +OrderType);
				//	B.add(OrderType)&& (Posoption != null);

				Posoption = String.valueOf(rs1.getInt("pos_option"));
				//	B.add(Posoption);
				//		int orderType = rs1.getInt("order_type");
				if ((rs1.getInt("order_type") == 212) || ((rs1.getInt("order_type") == 20)) && (rs1.getInt("bill_type") == 18))

				{
					B.add("ABPort");
				}


				else if ( (rs1.getInt("order_type")==210))
				{
					B.add("BBPort");
				}

				else if ((rs1.getInt("order_type")==211))
				{
					B.add("CCPort");

				}
				else if ( ((rs1.getInt("order_type")==1)) && (Posoption == null))
				{
					B.add("DDPORT");
				}

				else if ( ((rs1.getInt("order_type")==1)) && (Posoption != null))
				{
					B.add("EEPORT");
				}

				else if (((rs1.getInt("order_type")==1))&& (rs1.getInt("suffix")>=811) && (rs1.getInt("suffix")<=818))
				{
					//orderType == 26 &&suffixValue >= 811 && suffixValue <= 818
					B.add("FFPORT");
				}

				else if (((rs1.getInt("order_type")==1))&& (rs1.getInt("suffix")>=819) && (rs1.getInt("suffix")>=810))
				{
					//orderType == 26 && suffixValue >= 819 && suffixValue <= 810
					B.add("GGPORT");
				}


				else if ((rs1.getInt("order_type"))!=1 && (rs1.getInt("order_type"))!= 26 )
				{

					//	MSOrderActionType orderType = MSOrderActionType.get(rs1.getInt("order_type"));
					MSOrderType orderType = MSOrderType.get(rs1.getInt("order_type"));
					OrderType = orderType.getName();
					B.add(OrderType);

				}




				MSOrderActionType orderActionType = MSOrderActionType.get(rs1.getInt("action_type"));
				ActionTypeName = orderActionType.getName();
				//if (ActionTypeName.equals(Port))

				//	System.out.println("ActionTypeName :: " +ActionTypeName);
				B.add(ActionTypeName);

				ActivityId = String.valueOf(rs1.getInt("activity_id"));
				//		B.add(ActivityId);


				//	System.out.println(B);


				//		System.out.println(B);



				//	B.add(rs1.getString(1));
				//	B.add(rs1.getString(2));
				//	B.add(rs1.getString(3));
				//      System.out.print (OrderType);

				//System.out.println("\nAB Activity ID ........."+ActivityId+" Action Type "+ActionType+" Order Type"+OrderType);

			}

		}

		catch (Exception e)
		{

		}
		return B;
	}


}