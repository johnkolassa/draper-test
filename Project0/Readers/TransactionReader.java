package Readers;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import DataObjects.Transaction;

public class TransactionReader {
	
	// Members
	File filePath;
	ArrayList<Transaction> tList;

	// No Arg Constructor
	public TransactionReader() {
		this("bin/accounts/TransactionTest.txt");
	}
	
	// Arg Constructor
	public TransactionReader(String s) {
		filePath = new File(s);
		tList = new ArrayList<Transaction>();
		load();
	}
	
	// Read transaction history from the file
	public void load() {
		try {
			Scanner fileInput = new Scanner(filePath);
			while(fileInput.hasNext()) {
				String s = fileInput.nextLine();
				
				tList.add(Transaction.readFromLine(s));
			}
			
			fileInput.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Post transaction history to the file
	public void post() {
		try {
			FileWriter fw = new FileWriter(filePath);
			
			for(int i = 0; i < tList.size(); i++) {
				fw.write(tList.get(i).readToLine() + '\n');
			}
			
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Add a transaction to the list
	public void add(Transaction e) {
		tList.add(e);
	}
	
	// Return the balance of current transactions
	public int getBalance() {
		int balance = 0;
		
		for (Transaction t : tList) {
			if (t instanceof DataObjects.Deposit) {
				balance += t.getAmount();
			}
			else {
				balance -= t.getAmount();
			}
		}
		
		return balance;
	}
	
}
