package workflowauto;


import java.io.File;
import org.apache.log4j.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


public class ReadCredentials {
	
	
	public List<String> orderreader() throws IOException
	{
		List<String> Order = new ArrayList();
	 	Logger log= Logger.getLogger("sanityLogger");
		
		try {
		FileInputStream fileInputStream = new FileInputStream("C:\\test.xls");
		
		//pass file name
		HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
		
		//pass sheet name
		HSSFSheet worksheet = workbook.getSheet("Sheet2");
		
		//rowiterator
		Iterator rowIter = worksheet.rowIterator();
		
		while (rowIter.hasNext())
		{
			HSSFRow myrow=(HSSFRow) rowIter.next();
			Iterator cellIter = myrow.cellIterator();
			Vector<String> cellStoreVector= new Vector<String> ();
			
			while (cellIter.hasNext())
			{
				HSSFCell mycell=(HSSFCell) cellIter.next();
				String cellvalue = mycell.getStringCellValue();
				cellStoreVector.addElement(cellvalue);
				
			}
		
			
		
	
		String firstcolumnvalue=null;
		String secondcolumnvalue=null;
		
		int i=0;
		
		firstcolumnvalue = cellStoreVector.get(i).toString();
		secondcolumnvalue = cellStoreVector.get(i+1).toString();
		
		
		System.out.println("Order Number "+ firstcolumnvalue);
		System.out.println("Order Number "+ secondcolumnvalue);
		
		Order.add(firstcolumnvalue);
		Order.add(secondcolumnvalue);
		}
		
		}
		catch(IOException e){
			  //do something with e... log, perhaps rethrow etc.
			
			System.out.println(e);
			} 
			
		
	//	String[] Order = new String[Order.size()];
				
	//	Order.get(0);
		//System.out.println("Order Number "+ Order.get(0));
		
		return Order; 
		
		
	}
	
	
	
	public static void main(String arg[]) throws IOException
	{
	ReadCredentials R= new ReadCredentials();
		
	List<String> forder=R.orderreader();
	
	for (String tem : forder)
	
	{
	System.out.println("Main Method  "+ tem);
	
	}


}
}