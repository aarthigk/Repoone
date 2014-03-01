package AB_Screen;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;

public class DB_fetch {

	/**
	 * @param args
	 *
	 *
	 */
	private int Accessmethod;


	public static void main (String args[])
	{
		DB_fetch db = new DB_fetch();

		List<String> AB = new ArrayList<String>();
		AB= db.DBData("AAANNC21786545");

		System.out.print(""+AB);

	}


	public List DBData(String Ordernum)
	{
		List<String> B = new ArrayList<String>();


		Connection conn = null;
		PreparedStatement pstmt = null;
		//	  	System.out.println("dbconnect");
		String env="UAT";

		try {
			Properties prop1 = new Properties();
			prop1.load(new FileInputStream("C:\\MMswf\\jars\\dbprop.prop"));
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
			pstmt = conn.prepareStatement("MASKEDQUERY");
			pstmt.setString(1, Ordernum);




			ResultSet rs1=pstmt.executeQuery();
			while(rs1.next())
			{


				//	System.out.println("OrderType :: " +OrderType);
				//	B.add(OrderType)&& (Posoption != null);

				Posoption = String.valueOf(rs1.getInt("pos_option"));
				String TheBignetVal =null;
				String CountryVal =null;
				//			MethodCaller m = new MethodCaller();
				//		Hashtable pvc= null;
				//			pvc=ApAccess.makeAccessConnection((rs1.getInt("activity_id")));
				//	System.out.println(pvc);
				//		m.setAccessMethodType((String)pvc.get("a_access_method_type"));


				//		int aAccessMethod = m.getAccessMethodType();
				//	System.out.println(aAccessMethod);

				TheBignetVal= IsTheBignet(Ordernum);
				//	B.add(Posoption);
				//		int orderType = rs1.getInt("order_type");
				if ((rs1.getInt("order_type") == 212) || ((rs1.getInt("order_type") == 20)) && (rs1.getInt("bill_type") == 18))

				{
					B.add("AA Port");
				}

			}*/
					 else if ((!"US".equalsIgnoreCase(CountryVal)) && ("Y".equalsIgnoreCase(TheBignetVal)) && (rs1.getInt("pvc_type")==13))
			{
				B.add("AAABPORT");
			}

			else if ((!"US".equalsIgnoreCase(CountryVal)) && ("Y".equalsIgnoreCase(TheBignetVal)) && (rs1.getInt("pvc_type")==37))
			{
				B.add("CPORT");
			}

			else if ( (rs1.getInt("order_type")==210))
			{
				B.add("CPORT Port");
			}

			else if ((rs1.getInt("order_type")==211))
			{
				B.add("CPORT TWS");

			}






			else if ((rs1.getInt("order_type"))!=1 && (rs1.getInt("order_type"))!= 26 )
			{

				//	GenericActionType orderType = GenericActionType.get(rs1.getInt("order_type"));
				GenericOrderType orderType = GenericOrderType.get(rs1.getInt("order_type"));
				OrderType = orderType.getName();
				B.add(OrderType);

			}







			GenericOrderActionType orderActionType = GenericOrderActionType.get(rs1.getInt("action_type"));
			ActionTypeName = orderActionType.getName();


			System.out.println("ActionTypeName :: " +ActionTypeName);
			B.add(ActionTypeName);

			ActivityId = String.valueOf(rs1.getInt("activity_id"));


			System.out.println(B);


		}

	}

			catch (Exception e)
	{
		System.out.println(e);
	}
			return B;
}


public String IsTheBignet (String Ordernum)

{

	String TheBignet =null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	//	  	System.out.println("dbconnect");
	String env="UAT";

	try {
		Properties prop1 = new Properties();
		prop1.load(new FileInputStream("C:\\Bsswf\\jars\\dbprop.prop"));
		String url = null;
		String userName = null;
		String password = null;
		ResultSet rs2=null;



		if (env.equalsIgnoreCase("UAT")) {
			url = prop1.getProperty("UAT_URL");
			userName = prop1.getProperty("UAT_USER_ID");
			password = prop1.getProperty("UAT_PASSWORD");
		}

		Class.forName("oracle.jdbc.driver.OracleDriver");

		conn = DriverManager.getConnection(url, userName, password);

		System.out.println("Hello world");
		pstmt = conn.prepareStatement("MASKED QUERY");
		pstmt.setString(1, Ordernum);

		System.out.println("Ordernum:"+Ordernum);

		rs2=pstmt.executeQuery();

		if(rs2 == null){
			System.out.println("Empty");
		}

		if (rs2!=null && rs2.next() )
		{
			TheBignet = rs2.getString("str_value");
			// 	System.out.println("executed query" +TheBignet);

		}
	}

	catch (Exception e)
	{

	}

	return TheBignet;




}


public String Country (String Ordernum)

{

	String Country =null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	//  	System.out.println("dbconnect");
	String env="UAT";

	try {
		Properties prop1 = new Properties();
		prop1.load(new FileInputStream("C:\\BMMswf\\jars\\dbprop.prop"));
		String url = null;
		String userName = null;
		String password = null;
		ResultSet rs3=null;



		if (env.equalsIgnoreCase("UAT")) {
			url = prop1.getProperty("UAT_URL");
			userName = prop1.getProperty("UAT_USER_ID");
			password = prop1.getProperty("UAT_PASSWORD");
		}

		Class.forName("oracle.jdbc.driver.OracleDriver");

		conn = DriverManager.getConnection(url, userName, password);

		System.out.println("Hello world");
		pstmt = conn.prepareStatement("select maksed query from n_number=? ");
		pstmt.setString(1, Ordernum);

		System.out.println("Ordernum:"+Ordernum);

		rs3=pstmt.executeQuery();

		if(rs3 == null){
			System.out.println("Empty");
		}

		if(rs3!=null && rs3.next()){
			Country = rs3.getString("country_iso_code");
			//		System.out.println("executed query" +Country);

		}
	}



	catch (Exception e)
	{
		System.out.println(e);
	}

	return Country;




}



}