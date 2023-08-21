package lib;

public class MathsThread1 extends Thread {
	private Counter counter;
	
	public MathsThread1 (Counter c) {
		counter = c;
	}
	
	public void run() {
		try {
			int x = counter.getValue();
			int random = (int)Math.random()*100;
			Thread.sleep(random);
			counter.setValue(x + 5);
			}catch(InterruptedException ie){
			System.out.println(ie.getMessage());
		}

	}

}
