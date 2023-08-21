package main;
import lib.*;

public class MathsThreadApp {

	public static void main(String[] args) throws InterruptedException {
		Counter counter = new Counter(5);
		MathsThread1 m1 = new MathsThread1(counter);
		MathsThread2 m2 = new MathsThread2(counter);
		m1.start();
		m2.start();
		m1.join();
		m2.join();
		System.out.println(counter.getValue());


	}

}
