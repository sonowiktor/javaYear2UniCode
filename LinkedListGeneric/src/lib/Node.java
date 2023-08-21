package lib;

public class Node<E> {
	private E item;
	private Node<E> nextItem;

	public Node(E e, Node<E> n){
		item = e;
		nextItem = n;
	}
	public E getItem(){
		return item;
	}
	public void setItem(E e){
		item = e;
	}
	public Node<E> next(){
		return nextItem;
	}
	public void setNext(Node<E> n){
		nextItem = n;
	}
}
