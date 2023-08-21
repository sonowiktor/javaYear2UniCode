package exceptions;

public class DivideDemo {

	public static int divide( int a, int b) {
		int result = a / b ;
		return result;
	}


	public static void main(String[] args) {

		int x = 0;
		int y = 0;
		int answer = 0;
		
		x = Integer.parseInt(args[0]);
		y = Integer.parseInt(args[1]);
		
		answer = divide(x,y);

		System.out.println(args[0] + " / " + args[1] + " = " + answer);

	}

}
