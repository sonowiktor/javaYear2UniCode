package main;
import java.io.*;
import java.util.*;

public class democlass {

	public static void main(String[] args) {
		try {
		ArrayList<String> demo = new ArrayList<String>();
		FileReader fr = new FileReader("ass.txt");
		BufferedReader reader = new BufferedReader(fr);
		String line;
		while((line = reader.readLine()) != null) {
			demo.add(line);
			
		}
		reader.close();
		
		for(String s : demo) {
			System.out.println(s);
		}
		} catch (Exception e) {
			System.out.println("Error: "+ e.getMessage());
			System.exit(0);
		}
	}
}	
