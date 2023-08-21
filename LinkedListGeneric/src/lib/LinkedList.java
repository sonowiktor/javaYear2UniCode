package lib;

public class LinkedList<E> {
	private Node<E> head;

	public LinkedList(Node<E> h){
		head = h;
	}
	public Node<E> getHead(){
		return head;
	}
	public void setHead(Node<E> n){
		head = n;
	}
	public void insertAfter(Node<E> newNode, Node<E> prev){
		newNode.setNext(prev.next());
		prev.setNext(newNode);
	}

	public void deleteAfter(Node<E> prev){
		prev.setNext(prev.next().next());
	}
	
	public boolean find(E item){
		   boolean found = false;
		   Node<E> current = head;
		   while (!found && current != null){
			    if (current.getItem().equals(item)){
				   found = true; 	
		 	   }
		   current = current.next();
		   }
		   return found;
		}


	public String toString(){
		String str = "";
		Node<E> current = head;
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
