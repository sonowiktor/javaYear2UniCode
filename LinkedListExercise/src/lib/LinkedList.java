package lib;

public class LinkedList {
	private Node head;

	public LinkedList(Node h){
		head = h;
	}
	public Node getHead(){
		return head;
	}
	public void setHead(Node n){
		head = n;
	}
	public void insertAfter(Node newNode, Node prev){
		newNode.setNext(prev.next());
		prev.setNext(newNode);
	}

	public void deleteAfter(Node prev){
		prev.setNext(prev.next().next());
	}
	
	public void changeNextItem(Node n, String str){
		n.next().setItem(str);
		}
	
	public void replaceAfter(Node newNode, Node prev){
		newNode.setNext(prev.next().next());
		prev.setNext(newNode);
		}
	
	 public void swap(Node n){
		 Node first = n.next();
		 Node second = first.next();
		 first.setNext(second.next());
		 second.setNext(first);
		 n.setNext(second);
		 }
	 
	 public void changeAll(String colour){
		 Node current = head;
		 while(current != null){
		 current.setItem("black");
		 current = current.next();
		 }
		 }


	public String toString(){
		String str = "";
		Node current = head;
		while(current != null){
			str = str + current.getItem();
			current = current.next();
			if (current != null){
				str = str + ", ";
			}
		}
		return str;
	}
}
