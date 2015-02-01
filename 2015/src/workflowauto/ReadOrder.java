package workflowauto;


import java.io.File;
///import org.apache.log4j.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


public class ReadOrder {
	
	
	public List<String> orderreader() throws IOException
	{
		List<String> Order = new ArrayList();
	//	Logger log= Logger.getLogger("sanityLogger");
		
		try {        
		FileInputStream fileInputStream = new FileInputStream("C:\\test.xls");
		
		HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
		HSSFSheet worksheet = workbook.getSheet("Sheet1");
		HSSFRow row1 = worksheet.getRow(1);
		HSSFCell cellA1 = row1.getCell((short) 0);
		String a1Val = cellA1.getStringCellValue();
		Order.add(a1Val);
		
		}
		
		catch(IOException e){
			  //do something with e... log, perhaps rethrow etc.
			} 
			
		
	//	String[] Order = new String[Order.size()];
				
	//	Order.get(0);
//		System.out.println("Order Number "+ Order.get(0));
		
		return Order; 
		
		
	}
/*
	public static void main(String arg[]) throws IOException
	{
	ReadOrder R= new ReadOrder();
		
	List<String> forder=R.orderreader();
	
	//System.out.println("Main Method Number "+forder.get(0));
	}
*/

}