package main;
import lib.Node;
import lib.LinkedList;

public class ListApp {

	public static void main(String[] args){
		Node<String> n4 = new Node<>("green", null);
		Node<String> n3 = new Node<>("orange", n4);
		Node<String> n2 = new Node<>("blue", n3);
		Node<String> n1 = new Node<>("red", n2);

		LinkedList<String> list = new LinkedList<>(n1);

		System.out.println(list);

		Node<String> another = new Node<>("purple", null);
		list.insertAfter(another, n2);

		System.out.println(list);

		list.deleteAfter(n1);

		System.out.println(list);
		
	}
}
