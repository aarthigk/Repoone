package workflowauto;

public class taskenum {

	enum Status{
		Ready(1),Waiting(2),Completed(3);
		
		private int value;
		private Status(int value)
		{
			this.value=value;
		}
	}
		public static void main(String args[])
		{
			for (Status sa:Status.values())
				System.out.println(sa+""+sa.value);
		}
	
	
	
}
