package Readers;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import Users.Customer;

public class CustomerReader {

	// Members
	File filePath;
	ArrayList<Customer> cList;
	
	// No Arg Constructor
	public CustomerReader() {
		this("bin/customers/CustomerList.txt");
	}
	
	// Arg Constructor
	public CustomerReader(String s) {
		filePath = new File(s);
		cList = new ArrayList<Customer>();
		load();
	}
	
	// Read accounts from the file
	public void load() {
		try {
			Scanner fileReader = new Scanner(filePath);
				
			while (fileReader.hasNext()) {
				String s = fileReader.nextLine();
				
				cList.add(Customer.readFromLine(s));
			}
				
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Post account list to file
	public void post() {
		try {
			FileWriter fw = new FileWriter(filePath);
			
			for(Customer c : cList) {
				fw.write(c.readToLine() + '\n');
				c.post();
			}
			
			fw.close();
				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Add a customer
	public void add(Customer e) {
		cList.add(e);
	}
}
