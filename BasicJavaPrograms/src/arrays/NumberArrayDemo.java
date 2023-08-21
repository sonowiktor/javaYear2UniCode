package arrays;
import java.util.Scanner;


public class NumberArrayDemo {

	public static void main(String[] args) {
		
		//declare an array to store 12 int numbers
		int[] numbers = new int[12]; 
		//initialise each element
		numbers[0] = 4;
		numbers[1] = 2;
		numbers[2] = 4;
		numbers[3] = 60;		
		numbers[4] = 3;
		numbers[5] = 6;
		numbers[6] = 4;
		numbers[7] = 62;		
		numbers[8] = 5;
		numbers[9] = 10;		
		numbers[10] = 111;
		numbers[11] = 43;			
		
		
		
		/* PROCESS NUMBERS */
		
		//loop through each number in array
		for (int i=0; i < numbers.length; i++) {
			//print out current element (i) in array
			System.out.println(numbers[i]);
		}
		
		//loop through each number in array in reverse order
		for (int i=11; i >= 0; i--) {
			//print out current element (i) in array
			System.out.println(numbers[i]);
		}
		
		
		
		/* FIND LARGEST NUMBER */
		
		//variable to store largest number, initialsed at 0
		int largestNum = 0;
		
		//loop through each number in array
		for (int i=0; i < numbers.length; i++) {
			//check if current numbers element (i) is greater than the
			//current largest number stored in the variable
			if (numbers[i] > largestNum) {
				//update the largest numbers
				largestNum = numbers[i];
			}
		}	
		
		//print out the result of the largest numbers
		System.out.println("The largest numbers is " + largestNum);
		
		
		
		/* COUNT EVEN NUMBERS */
		
		//variable to store a count of even numberss
		int countEven = 0;
		
		//loop through each number in array
		for (int i=0; i < 12; i++) {
			//if the remainder of the current numbers element (i)
			//when divided by 2 is 0, then it must be even
			if (numbers[i] % 2 == 0) {
				//increment count by 1
				countEven++;
			}
		}
		
		//output result showing the count of even numbers
		System.out.println("The amount of even numbers in our array is " + countEven);
		
		
		
		/* READ INPUT AND CALCULATE AVERAGE*/
		
		//declare a new array
		int[] numArr2 = new int[5];
		
		//create a Scanner object
		Scanner sc = new Scanner(System.in);
		
		//variable to hold sum
		int sum=0;
		
		//loop through each element in array
		for (int j = 0; j < numArr2.length; j++) {
			//prompt for and read input
			System.out.println("Input number " + (j+1));
			numArr2[j] = sc.nextInt();
			//accumulate sum
			sum+=numArr2[j];
		}
		
		//output average
		System.out.println("Average is: " + (sum/numArr2.length));

		sc.close();
	}

}
