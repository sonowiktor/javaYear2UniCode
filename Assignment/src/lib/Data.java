package lib;
import java.io.*;
import java.util.*;

public class Data {
	public static void main(String[] args) {
		String a = "Vienna is the most beautiful city in Europe";
		String a2[] = a.split(",");
		String b = "Mary has two cats and five guinea pigs";
		String b2[] = b.split(",");
		String c = "Smoking cigarettes is not good for teenagers";
		String c2[] = c.split(",");
		String d = "If you do not know Sweet Caroline we can't be friends";
		String d2[] = d.split(",");
		String e = "Pineapple does not belong on pizza";
		String e2[] = e.split(",");
		
		ArrayList<String[]> textDoc = new ArrayList<>();
		textDoc.add(a2);
		textDoc.add(b2);
		textDoc.add(c2);
		textDoc.add(d2);
		textDoc.add(e2);
		
		for (String[] s : textDoc)
				System.out.println(s);
		
		
		
		

	}
	
	
}
