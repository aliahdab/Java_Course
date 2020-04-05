package test;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Person[] persons = new Person[3];
		persons[0] = new Person("Ali", 2);
		persons[1] = new Person("Nahla", 5);
		persons[2] = new Person("malla", 3);
	
	int x=0;
	int y=x;
	x=x+12;
	System.out.println(y);
		
	}
}
