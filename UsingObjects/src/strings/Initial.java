package strings;
import java.util.Scanner;
public class Initial {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("Please input a first name");
		String myFirstName = sc.nextLine();
		System.out.println("Please input a second name");
		String mySecondName = sc.nextLine();
		char a, b;
		String smallInitials, email;
		
		String myName = myFirstName + " " + mySecondName;
		
		a = myFirstName.charAt(0);
		b = mySecondName.charAt(0);
		
		smallInitials = (a + "" + b).toLowerCase();
		email = smallInitials + "@dmu.ac.uk";
		System.out.println(email);
	}

}
