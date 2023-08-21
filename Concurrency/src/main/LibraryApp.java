package main;

import lib.*;

public class LibraryApp {

		public static void main(String[] args) throws InterruptedException{
			Book book = new Book("Book0");
			Librarian p1 = new Librarian(book, "Intro to Java");
			Librarian p2 = new Librarian(book, "Data structures");
			p1.start();
			p2.start();
			p1.join();
			p2.join();	
			System.out.println(book.getName());
		}

}
