package myPackage;

import java.util.Scanner;
import java.io.*;

public class MyClass implements Serializable {
	public String name;
	public int age;
	public String school;
	
	public MyClass() {
		this("David", 22, "Stonehill");
	}
	
	public MyClass(String name, int age, String school) {
		this.name = name;
		this.age = age;
		this.school = school;
	}
	
	public static void save(Object o) {
		try {
			FileOutputStream fileOut = new FileOutputStream("savefile.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(o);
			out.close();
			fileOut.close();
			System.out.println("Serialized data is saved in savefile.ser");
			
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
	}
	
	public static MyClass load() {
		try {
			FileInputStream fileIn = new FileInputStream("savefile.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			MyClass mc = (MyClass) in.readObject();
			in.close();
			fileIn.close();
			System.out.println("Serialized data was loaded form savefile.ser");
			return mc;
		} catch (IOException e) {
			e.printStackTrace();
			return new MyClass();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return new MyClass();
		}
		
		
	}
	
	public static void main(String[] args) {
		File f = new File("savefile.ser");
			
		if (!f.exists()) {
			Scanner input = new Scanner(System.in);
			
			String name = input.next();
			int age = input.nextInt();
			String school = input.next();
			
			input.close();
			
			MyClass one = new MyClass(name,age,school);
			MyClass.save(one);
		}
		
		MyClass two = MyClass.load();
		System.out.println(two.name + " " + two.age + " " + two.school);
	}
}
