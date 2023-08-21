package functions;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class WritingFunctions {

	public static void main(String[] args) {
		//A function that adds 5 to its argument
		Function<Integer, Integer> addFive =  x -> x+5;
		
		System.out.println("Adding five to each element...");
		
		//Stream.of is a simple way of generating a stream. In this case, the map method
		//requires a Function to apply to each element - addFive is applied.
		Stream.of(1,2,3,4,5).map(addFive).forEach(i -> System.out.print(i + " "));
		
		
		//An 'add' function that accepts an argument and returns another function that 
		//accepts a second argument, and adds these together, returning the result
		Function<Integer, Function<Integer, Integer>> add =  x -> (y -> x + y);
		
		System.out.println("\n\nResult of add function 2 + 6: " + add.apply(2).apply(6));
		
		//An alternate 'add' function using the BiFunction interface type, which simply
		//accepts two arguments and produces a result (adding them together in this case)
		BiFunction<Integer, Integer, Integer> addBi = (x, y) -> x + y;
		
		System.out.println("\nResult of bi add function 4 + 3: " + addBi.apply(4, 3));

		
		//This function accepts a Name object and returns a String in the format: Surname, Initial
		Function<Name, String> nameFormatter = n -> n.getFamilyName() + ", " + n.getFirstName().charAt(0);
		
		System.out.println("\nApplying the name formatter...");
		Stream.of(new Name("James", "Bond"), new Name ("Eve", "Moneypenny")).map(nameFormatter).forEach(System.out::println);
		
		
		//A function to calculate the length of the provided String
		ToIntFunction<String> strLength = s -> s.length();
		
		System.out.println("\nLength of strings: apple, banana, pear...");
		Stream.of("apple", "banana", "pear").mapToInt(strLength).forEach(System.out::println);
		

		
		//TRY MORE FUNCTIONS HERE...
	}

}
