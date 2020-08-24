package Users;

import java.util.ArrayList;

import DataObjects.Account;
import Readers.AccountReader;

public class Admin extends User{

	// No Arg Constructor
	public Admin() {
		this(1000, "John", "Kolassa");
	}
	
	public Admin(int id, String firstName, String lastName) {
		// TODO Auto-generated constructor stub
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
	// cancel an account in the list
	public void cancel(Account a) {
		int i = aList.indexOf(a);
		aList.remove(i);
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
		b.deposit(i);
	}
	// Return all accounts
	public ArrayList<Account> getAll(){
		return aList;
	}
	
	// Post
	public void post() {
		ar.post();
	}
	@Override
	public String readToLine() {
		StringBuilder s = new StringBuilder();
		s.append(id+" "+firstName+" "+lastName);
		
		for (Account acc : aList) {
			s.append(" " + acc.getID());
		}
		
		return s.toString();

	}
	public int getID() {
		return id;
	}

}
