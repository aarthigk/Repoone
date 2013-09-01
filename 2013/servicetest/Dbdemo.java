package com.att.efms.orderservicetest;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class Dbdemo {
	
/*	public static void main(String arg[]) {
		Dbdemo d = new Dbdemo();
		d.DBData();
		
		
	
	}*/
	public List DBData()
	{
		 List<String> B = new ArrayList<String>();
		// List<MSOrderType> C = new ArrayList<MSOrderType>();
	
		    Connection conn = null;
		    PreparedStatement pstmt = null;
		  //	System.out.println("dbconnect");
	//		String env="STG";

			try {
		//		Properties prop1 = new Properties();
			//	prop1.load(new FileInputStream("C:\\MMwf\\jars\\dbprop.prop"));
			//	prop1.load(new FileInputStream("C:\\Users\\TESTADMIN\\Documents\\Automation\\MYWF\\jars\\dbprop.prop"));
				
				
				String url = "jdbc:oracle:thin:@SOMEID";
				String userName ="maskuser";
				String password = "maskpassword";
				String ActivityId;
				String ActionTypeName;
				String OrderType=null;
				String Posoption =null;
				String a ="id";
				String b ="customername";
		
	 /* 		if (env.equalsIgnoreCase("STG")) {
					url = prop1.getProperty("STG_URL");
					userName = prop1.getProperty("STG_USER");
					password = prop1.getProperty("STG_PASSWORD");
					
					
				}*/
			
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				conn = DriverManager.getConnection(url, userName, password);
			//	System.out.println(conn);
				pstmt = conn.prepareStatement("select ordernum from table where another_aa_number='AABBCC11223'");
	//			pstmt.setString(1, Ordernum);
				
				
				
			
				ResultSet rs1=pstmt.executeQuery();
			//	System.out.println(rs1);
				while(rs1.next())
				{
					String ordernum=rs1.getString("ordernum_id");
				//	System.out.println(rs1);
				//String ordernum =String.valueOf(rs1.getInt("ordernum_aa"));
			    String cutomername= rs1.getString("customer_name");
			    
			  
		//String tag1="id"+
		B.add(ordernum);
		//String tag2="customerName"+
		B.add(cutomername);
		
	//	B.add(tag1);
		//B.add(tag2);
				}	
				
			}
			
			catch (Exception e)
			{
				System.out.println(e);	
			}
//		System.out.println(B);
			return B;
			
	}

}
