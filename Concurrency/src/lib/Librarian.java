package lib;


public class Librarian extends Thread {
	Book book;
	String name;

	public Librarian(Book b, String str){
		book = b;
		name = str;
	}

	public void run() {
		book.setName(name);
		System.out.println("Changed to: " + book.getName());
	}




}
