package main;

import java.util.ArrayList;

public class StringListDemo {
	ArrayList<String> list = new ArrayList<String>();
	
	System.out.println(list.toString());
	
	list.add(3);
	list.add(42);
	list.add(27);
	
	System.out.println(list.toString());

}
