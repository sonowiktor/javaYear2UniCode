package using;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.DoubleStream;

public class Find_Match_and_Sort {

	public static void main(String[] args) {
		/* This program illustrates how streams can be sorted in combination with custom comparators.
		 * It also shows how some terminal operations return an Optional that may or may not have a value present.
		 * Furthermore, there are different means of finding elements or checking if elements exist in a stream.
		 */

		//Arrays.asList is a convenient way to create a fixed-size list that cannot be modified - doing so throws an exception
		List<String> fruits = Arrays.asList("Pineapple", "Kiwi", "Apple", "Banana", "Watermelon", "Grape", "Orange");

		System.out.println(" --- 1. Using sorted() - output");
		
		/* --- 1. Sorting a stream into its natural order using sorted() --- */
		fruits.stream().sorted().forEach(System.out::println); //uses the (natural order) comparator to sort stream with the intermediate sorted() operation

		
		System.out.println("\n --- 2. Using findFirst() and Optional - output");
		
		/* --- 2. Finding the first element of a stream using findFirst() and Optional --- */
		Optional<String> firstElem = fruits.stream().sorted().findFirst(); //returns an Optional value as stream may be empty

		//can check if optional holds a value using isPresent
		if (firstElem.isPresent()) {
			System.out.println("First string element from natural order sort is... " + firstElem.get()); //gets the actual value of the optional element
		}
		

		System.out.println("\n --- 3. Using sorted(Comparator) and max(Comparator) - output");
		
		/* --- 3. Sorting a stream into a custom order using sorted(Comparator) and using max(Comparator) to get the maximum element --- */
		fruits.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println); //use custom comparator to sort (based on string length) and then print out the list

		//use custom comparator find the maximum value of a stream (based on string length). An Optional is returned, as the stream may be empty.
		String maxLength = fruits.stream().max(Comparator.comparing(String::length)).orElse("No string found"); //orElse provides an alternative value if the Optional is empty
		System.out.println("\nMax length string is... " + maxLength);

		
		System.out.println("\n --- 4. Using findAny() and anyMatch - output");
		
		/* --- 4. Finding and matching any element using findAny() and anyMatch --- */
		String len5 = fruits.stream().filter(s -> s.length() == 5).findAny().orElse("No fruit found"); //orElse provides an alternative value if an element is not found
		//a filter can be followed by a find to retrieve a given element
		System.out.println("Fruit of length 5 is: " + len5);

		//if you do not want to retrieve an element and just want to check if it exists you can use anyMatch, which accepts a predicate
		System.out.println("\nAny match with Banana? " + fruits.stream().anyMatch(s -> s.equals("Banana")));


		
		/* --- TO DO : tasks --- */

		/* TASK 1. Use the noneMatch terminal operation, that is similar to anyMatch (accepting a predicate), 
		 * but returns true if no elements match the given predicate. You should check that no element
		 * in the list of fruits matches the string "Toast".
		 */
		System.out.println("\nNo match with Toast? " + fruits.stream().noneMatch(s -> s.equals("Toast")));


		/* TASK 2. Use the allMatch terminal operation - the opposite of noneMatch.
		 * Use IntStream.of (example in BuildingStreams.java) to generate a stream of
		 * 5 even numbers, then provide allMatch with a suitable predicate to ascertain whether
		 * all elements are indeed even. Make one of the numbers odd and test it then returns false.
		 */
		 System.out.println("\nAll numbers even? " + IntStream.of(2,4,6,8,10).allMatch(x -> x % 2 == 0));


		/* TASK 3. Use the min() terminal operation on a DoubleStream.
		 * Use DoubleStream.of to generate a stream of 5 decimal point numbers.
		 * Then use the min() terminal operation that does not require a Comparator as min and max of numbers
		 * are well defined. This will return an OptionalDouble, which you can invoke the orElse method on
		 * to return -1 if a number is not found. You should ensure it works correctly and outputs the minimum number regardless of its position in the stream.
		 */
		 double minNum = DoubleStream.of(4.4, 2.7, 6.2, 10.1).min().orElse(-1);
		 System.out.println("Minimum double is: " + minNum + "\n");


		/* TASK 4. Use the sorted(Comparator) intermediate operation shown above.
		 * Ensure the Name class is within your project and then use Arrays.asList to easily create
		 * a List of 3 Name objects, each with different first and last names.
		 * You should then use a stream pipeline and provide the sorted method with a Comparator that
		 * sorts them based on their first name, and then prints them out using the forEach terminal operation.
		 */
		 List<Name> names = Arrays.asList(new Name("Joe", "Bloggs"), new Name("Anna", "Knowls"), new Name("Ben", "Rock"));
		 names.stream().sorted(Comparator.comparing(Name::getFirstName)).forEach(System.out::println);

		
		/* TASK 5. Using the same list you created from the previous task, use the mapToInt(...) intermediate operation
		 * to map Name objects to integers based on their length. Follow this with a call to the then max() terminal
		 * operation, that will return an OptionalInt. If this is present, you should output the result it stores. */
		 OptionalInt maxLengthName = names.stream().mapToInt(n -> n.getFullName().length()-1).max(); //-1 to remove space between first and last name
		 if (maxLengthName.isPresent()) {
			 System.out.println("\nMax length of name is " + maxLengthName.getAsInt());
		 }
		 
		 //or an alternative approach
		 maxLengthName.ifPresent(x -> System.out.println("Max length of name is " + x));

		

	}

}
