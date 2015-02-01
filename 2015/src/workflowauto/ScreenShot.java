package workflowauto;


import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
public class ScreenShot {
	
	public void getscreenshot(WebDriver driver,String screenname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		// java uitl date class SimpleDateFormat s=new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
		//Timestamp time= new Timestamp(System.currentTimeMillis());
		
	
		long millsec=System.currentTimeMillis();
		
		Date date= new Date(millsec);
				
		FileUtils.copyFile(source, new File("C:\\SanitySs\\"+screenname+"_"+date+".png"));
		
	}

}
