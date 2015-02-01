package efmsms;
import java.io.FileInputStream;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;



public class TaskDB {

	public List TaskNameDBdata(String Ordernum)
	{
		List<String> tasksList = new ArrayList<String>();


		Connection conn = null;
		PreparedStatement pstmt = null;
		System.out.println("dbconnect");
		String env="ST2";

		try {
			Properties prop1 = new Properties();
			prop1.load(new FileInputStream("C:\\Users\\IBM_ADMIN\\Documents\\Automation\\EFMSWF\\jars\\dbprop.prop"));


			String url = null;
			String userName = null;
			String password = null;
			String ActivityId;
			String ActionTypeName;
			String taskstatus=null;
			String taskname =null;


			if (env.equalsIgnoreCase("ST2")) {
				url = prop1.getProperty("ST2_URL");
				userName = prop1.getProperty("ST2_USER_ID");
				password = prop1.getProperty("ST2_PASSWORD");
			}

			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, userName, password);
			pstmt = conn.prepareStatement("SELECT sc.column1, t.column2, t.status FROM table1 sc, table2 j, table3 t WHERE " +
					"sc.id_column = j.entity_id AND " +
					"j.wf_job_id = t.wf_job_id " +
					"AND j.entity_type = 1 AND sc.column1 LIKE ? ORDER BY t.column2");
			pstmt.setString(1, Ordernum);
			System.out.println("Order"+ Ordernum);


			ResultSet rs1=pstmt.executeQuery();
			while(rs1.next())
			{
				taskname = rs1.getString("name");

				//	System.out.println("OrderType :: " +OrderType);
				//	tasksList.add(OrderType)&& (Posoption != null);

				//	taskname = String.valueOf(rs1.getInt("name"));
				tasksList.add(taskname);

				taskstatus = rs1.getString("status");
				if ((rs1.getInt("status") == 1))
				{
					tasksList.add("READY");
				}
				if ((rs1.getInt("status") == 3))
				{

					tasksList.add("COMPLETED");

				}	else

					System.out.println("nothing");

			}
		}


		catch (Exception e)
		{
			System.out.println(e);
		}
		System.out.println(tasksList);
		return tasksList;

	}

}
