package Users;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import DataObjects.Account;
import Readers.AccountReader;

public class Customer extends User {
	
	// No Arg Constructor
	public Customer() {
		this(1000, "Dave", "Draper");
	}
	
	// Arg Constructor
	public Customer(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		
		this.aList = new ArrayList<Account>();
		this.ar = new AccountReader();
	}
	
	// Add an account to the list
	public void add(Account a) {
		aList.add(a);
	}
	
	// Display Account List
	public void displayAccountList() {
		System.out.println("Account List:");
		for (Account a : aList) {
			System.out.println(a.getID());
		}
	}
	
	// View Balance
	public void viewBalance(Account a) {
		a.displayBalance();
	}
	
	// Deposit
	public void deposit(Account a, int i) {
		a.deposit(i);
	}
	
	// Withdraw
	public void withdraw(Account a, int i) {
		a.withdraw(i);
	}
	
	// Transfer
	public void transfer(Account a, Account b, int i) {
		a.withdraw(i);
		b.withdraw(i);
	}
	
	// Get an account from an ID
	public Account getAccount(int id) {
		for(Account acc : aList) {
			if (acc.getID() == id) {
				return acc;
			}
		}
			
		System.out.println("No Account with ID " + id + " found.");
		return null;
	}
	
	// Return all accounts
	public ArrayList<Account> getAll(){
		return aList;
	}
	
	// Post
	public void post() {
		ar.post();
	}
	
	// Request a new account
	public void request() {
		try {
			FileWriter fw = new FileWriter("bin/requests/AccountRequests.txt");
				
			fw.append(id + "");
				
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Request a new account
	public void requestAccess(int account) {
		try {
			FileWriter fw = new FileWriter("bin/requests/AccessRequests.txt");
					
			fw.append(id + " " + account);
					
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Return the ID
	public int getID() {
		return id;
	}
	
	// Read the data in the object to a string
	public String readToLine() {
		StringBuilder s = new StringBuilder();
		s.append(id+" "+firstName+" "+lastName);
		
		for (Account acc : aList) {
			s.append(" " + acc.getID());
		}
		
		return s.toString();
	}
	
	// Create a customer out of a string
	public static Customer readFromLine(String s) {
		Scanner stringReader = new Scanner(s);
		
		int id = stringReader.nextInt();
		String firstName = stringReader.next();
		String lastName = stringReader.next();
		
		Customer c = new Customer(id,firstName,lastName);
		
		while (stringReader.hasNext()) {
			c.add(c.ar.getByID(stringReader.nextInt()));
		}
		
		stringReader.close();
		
		return c;	
	}
	
	public static void main(String[] args) {
		Customer c = Customer.readFromLine("1000 Dave Draper 1111 2222 3333");
		
		c.request();
	}
}
