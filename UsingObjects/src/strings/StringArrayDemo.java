package strings;

public class StringArrayDemo {

	public static void main(String[] args) {
		String[] fruit = new String[6];
		fruit[0] = "grape";
		fruit[1] = "orange";
		fruit[2] = "apple";
		fruit[3] = "banana";
		fruit[4] = "pear";
		fruit[5] = "strawberry";
		
		String fruits = (fruit[0] + " " + fruit[1] + " " + fruit[2] + " " + fruit[3] + " " + fruit[4] + " " + fruit[5]);
		
		System.out.println(fruits.toUpperCase());
		
		

	}

}
