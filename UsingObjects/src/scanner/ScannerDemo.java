package scanner;

/* Program to show how to read input from the keyboard using a Scanner.
 *
 * The program prompts the user for some information, reads the input 
 * from the keyboard, and then echoes it back.
 */

import java.util.Scanner;  //remember to import the Scanner

public class ScannerDemo
{
	public static void main(String[] arg)  
	{
		//create a Scanner object for keyboard input
		Scanner sc = new Scanner(System.in);		

		System.out.println("Type your address, and press Enter");
		String address = sc.nextLine();	//read a whole line
		System.out.println("You live at " + address);

		System.out.println("Type your 1st name, and press Enter");
		String name = sc.next();	//read next token as String
		System.out.println("Hello " + name);

		System.out.println("Enter your age: ");
		int age = sc.nextInt();		//read next token as an int
		System.out.println("You are " + age + " years old");

		//...prompt for some other information and process it,
		// e.g. last name, gender...

		sc.close(); //close the Scanner
	}
}

