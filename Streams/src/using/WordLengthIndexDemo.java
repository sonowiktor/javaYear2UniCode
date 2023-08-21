package using;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class WordLengthIndexDemo {

	public static void main(String[] args) {
        List<String> words = Arrays.asList("Apple", "doo", "mo", "Bowefwefweofjwoefjw", "bandereergr", "Ananas", "Mango", "Boon", "Beer", "Banana", "Beer");
		
		Map<Integer, Set<String>> dictionary = words.stream().collect(groupingBy(String::length, TreeMap::new, mapping(String::toLowerCase, toCollection(TreeSet::new))));
	
		System.out.println(dictionary.toString());

	}

}
