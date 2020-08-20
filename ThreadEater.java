package myPackage;

import java.util.*;

public class ThreadEater extends Thread {
	
	static int count = 100;
	boolean adder;
	
	public static Deque<Integer> dq;
	Random r = new Random();
	
	public ThreadEater(boolean adder) {
		this.adder = adder;
		
		if (dq == null) {
			dq = new LinkedList<Integer>();
		}
	}
	
	public void add() {
		
		synchronized(dq) {
			if (dq.size() < 5) {
				Integer i = new Integer(r.nextInt(10000));
				dq.addLast(i);
			}
		}
	}
	
	public void remove() {
		
		synchronized(dq) {
			if (dq.size() > 0) {
				Integer i = dq.removeFirst();
				count--;
				
				if (isPrime(i.intValue())) {
					System.out.println(i + " is prime!");
				} else {
					System.out.println(i + " is not prime!");
				}
			}
		}
		
		if (count == 0) {System.exit(0);}
	}
	
	public boolean isPrime(int n) {
		if (n <= 1) {
			return false; 
		}
		
		for (int i = 2; i < n; i++) {
			if (n % i == 0) return false;
		}
		
		return true;
	}
	
	public void run() {
		while (true) {
			if (adder) {
				add();
			} else {
				remove();
			}
		}
	}
	
	public static void main(String[] args) {
		ThreadEater trAdd = new ThreadEater(true);
		ThreadEater trRemove = new ThreadEater(false);
		
		trAdd.start();
		trRemove.start();
	}
}
