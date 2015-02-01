package workflowauto;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
/********

 @author aarthi Gk

 **/


public class Dbconnector {


	public static void main (String args[]) throws FileNotFoundException, IOException 
	{
		Dbconnector test = new Dbconnector();
		test.TaskTable();
	}

	public  void TaskTable() throws FileNotFoundException, IOException
	{
		 Connection conn = null;
		    PreparedStatement pstmt = null;
		  	System.out.println("dbconnect");
			String env="ST2";

			try {
				Properties prop1 = new Properties();
			//	prop1.load(new FileInputStream("C:\\wf\\jars\\dbprop.prop"));
				prop1.load(new FileInputStream("C:\\Users\\TEST_ADMIN\\Documents\\Automation\\TESTWF\\jars\\dbprop.prop"));
				
			  	System.out.println("dbconnect inside");
			  	String url = null;
				String userName = null;
				String password = null;
				String ActivityId;
				String ActionTypeName;
				String OrderType=null;
				String Posoption =null;
				
	
	  	  	if (env.equalsIgnoreCase("ST2")) {
					url = prop1.getProperty("ST2_URL");
					userName = prop1.getProperty("ST2_USER_ID");
					password = prop1.getProperty("ST2_PASSWORD");
				  	System.out.println("dbconnect");
				}
				
			
				Class.forName("oracle.jdbc.driver.OracleDriver");


				pstmt = conn.prepareStatement("SELECT sc.column1, t.column2, t.status FROM table1 sc, table2 j, table3 t WHERE " +
						"sc.id_column = j.entity_id AND " +
						"j.wf_job_id = t.wf_job_id " +
						"AND j.entity_type = 1 AND sc.column1 = 'SomeValue'");

				//pstmt.setString(1, Ordernum);
				System.out.println("Order");
			
				ResultSet rs1=pstmt.executeQuery();
				while(rs1.next())
				{
					Posoption = String.valueOf(rs1.getInt("name"));		
				System.out.println(Posoption);
				
	
			    }
			}
				catch (Exception e)
				{
					System.out.println (e);
					
				}
	
}
}
			
			
