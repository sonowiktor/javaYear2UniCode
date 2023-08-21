package main;
import lib.Node;
import lib.LinkedList;

public class ListApp {

	public static void main(String[] args){
		Node n4 = new Node("green", null);
		Node n3 = new Node("orange", n4);
		Node n2 = new Node("blue", n3);
		Node n1 = new Node("red", n2);
		
		
		System.out.println(n4.getItem());
		n3.next().setItem("grey");


		LinkedList list = new LinkedList(n1);
		System.out.println(list.getHead().getItem());
		System.out.println(n2.next().getItem());

		System.out.println(list);
		
		Node another1 = new Node ("pink", null);
		list.insertAfter(another1, n2);
		list.deleteAfter(n3);
		System.out.println(list);
		

		Node another = new Node("purple", null);
		list.insertAfter(another, n2);

		System.out.println(list);

		list.deleteAfter(n1);

		System.out.println(list);
	}
}
