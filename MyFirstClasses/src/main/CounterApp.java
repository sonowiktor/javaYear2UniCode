package main; //this demonstration application resides in the main package

import lib.Counter; //the counter class is imported from the lib package in this project

public class CounterApp {
	
	public static void main(String[] args) {
		/* The first part of the following program demonstrates how you can informally 
		 * assess that your class behaves as you expect by using the constructors and
		 * some of the methods. To test it properly however you should create JUnit tests.
		 */
		
		System.out.println("Demonstrating some core functionality of the Counter...\n======");
		
		System.out.println("Using default constructor initialisation and get method...");
		Counter c = new Counter();
		System.out.println("Expected 0: Actual: " + c.getCount());
		
		System.out.println("Using increment method...");
		c.increment();
		c.increment();
		System.out.println("Expected 2: Actual: " + c.getCount());
		
		System.out.println("Using set method...");
		c.setCount(10);
		System.out.println("Expected 10: Actual: " + c.getCount());
		
		
		System.out.println("\nUsing custom constructor initialisation...");
		Counter c1 = new Counter(5); //Note: creating a second object instance of the Counter class (which has its own state)
		System.out.println("Expected 5: Actual: " + c1.getCount());
		
		System.out.println("Using reset method...");
		c1.reset();
		System.out.println("Expected 0: Actual: " + c1.getCount());
		
		System.out.println("Using toString method...");
		System.out.println("Expected count=0: Actual: " + c1.toString());
		
		
		
		/* More commonly, the main method Java application will get used to meet one or more
		 * desired use cases resulting in some meaningful or interesting functionality
		 * 
		 *  e.g. Use a counter object to print out a count down from 10.
		 *  The output should be: 10 9 8 7 6 5 4 3 2 1 Blast Off!
		 */
		
		System.out.println("\nBlast off counter demo\n----");
		Counter blastOff = new Counter();
		
		//When you comment out the code below it will initially not compile, as you need to add
		//the decrement() method to the Counter class.
		
		/*for (blastOff.incrementBy(10); !blastOff.isZero(); blastOff.decrement()) {
			System.out.print(blastOff.getCount() + " ");
		}
		
		System.out.println("Blast off!");*/
		
	}
}
