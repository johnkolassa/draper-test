package DataObjects;

import java.util.Scanner;

public abstract class Request {
	protected int id;
	
	public abstract String readToLine();
	
	public static Request readfromline(String s) {
		Scanner lineReader = new Scanner(s);
		
		String type = lineReader.next(); // Read in the type and amount of the transaction
		int amount = lineReader.nextInt();
		
		lineReader.close();
		
		if (type.equals("Access")) { // Determine what kind of transaction to create
			return(new AccessRequest());
		} else {
			return(new AccountRequest());
		}
		
	}
	
}