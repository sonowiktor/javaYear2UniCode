package lib;

public class Node {
	private String item;
	private Node nextItem;

	public Node(String str, Node n){
		item = str;
		nextItem = n;
	}
	public String getItem(){
		return item;
	}
	public void setItem(String str){
		item = str;
	}
	public Node next(){
		return nextItem;
	}
	public void setNext(Node n){
		nextItem = n;
	}
}
