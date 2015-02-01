package workflowauto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class TaskValidation {
	
	public static void main(String args[]) throws IOException {
		
		Task s =new Task();
		List <String> screen = new ArrayList<String>();
		taskdb t= new taskdb();
		List <String> dbbase = new ArrayList<String>();
		
		ReadOrder ro= new ReadOrder();
		List<String> Ordernum=ro.orderreader();
		s.TaskScreenData(Ordernum.get(0));
		t.TaskNameDBdata(Ordernum.get(0));
	
		
	 for (String temp : Ordernum)
	 {
		screen = s.TaskScreenData(Ordernum.get(0));
		System.out.print("Screen Values :: " + screen);
		
		
		dbbase = t.TaskNameDBdata(Ordernum.get(0));
		System.out.print("DB Values :: " +dbbase);
		
		if(screen.equals(dbbase))
		{
			System.out.println("Pass");
		}

		else
			System.out.println("Pass");

			}
		
	}
}
