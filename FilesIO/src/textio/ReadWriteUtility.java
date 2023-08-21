package textio;


import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadWriteUtility {

	public static void main(String[] args) throws IOException {
		/* This program shows some new utility features added in the 7th and 8th release of the Java language. In particular the
		 * Files class provides simple ways of reading and writing to files either by converting a string to byte form, or reading to
		 * and writing from a list of lines. The Paths class makes it easier to work with paths, and in combination with Files, you can
		 * create, copy and remove files and directories.
		 *
		 * You can also yield a stream pipeline of strings or paths by reading from a file or directory.
		 */


		//output string to be used for purpose of example
		String outputData = "This is a random string\n";
		outputData += "used for the purpose of an example\n";
		outputData += "to show show data can easily be written to a file in byte form\n";
		outputData += "by using the Files utility class.";

		//attempt to create a new temp directory within this project and catch exception if it already exists
		try {
			Files.createDirectory(Paths.get("temp"));
		} catch (FileAlreadyExistsException e) {
			System.out.println("temp directory already exists...\n\n");
		}



		/* --- READ AND WRITE STRINGS (IN BYTE FORM) TO/FROM A FILE --- */

		//writes a string (in byte form) to a file called test.txt in the temp directory
		Files.write(Paths.get("temp/test.txt"), outputData.getBytes());

		//makes a copy to testCopy.txt - no need to check if file already exists as it is deleted at end of program
		Files.copy(Paths.get("temp/test.txt"), Paths.get("temp/testCopy.txt"));

		//read entire byte content of a file and then place it in a string
		byte[] inputBytes = Files.readAllBytes(Paths.get("temp/testCopy.txt"));
		String inputData = new String(inputBytes);

		//verify data read back in correctly from testCopy.txt
		System.out.println("Checking data read back in from file...\n===\n" + inputData);

		/* ------------------------------------------------------------ */



		/* --- READ AND WRITE LINES (OF STRINGS) TO/FROM A FILE --- */

		//read all lines from testCopy.txt and populate a list of type string
		List<String> lines = Files.readAllLines(Paths.get("temp/testCopy.txt"));

		//verify data read back into list
		System.out.println("\n\nChecking content of list...\n===\n" + lines.toString());


		//write a list out to a file test.txt - this places each element on a new line
		Files.write(Paths.get("test2.txt"), lines);

		//as readAllLines returns a List<String> you can iterate over it using a for-each loop
		System.out.println("\n\nProcessing line by line using for-each... (outputting in uppercase)\n===");
		for (String line : Files.readAllLines(Paths.get("test2.txt"))) {
			System.out.println(line.toUpperCase());
		}

		//you can do the same by invoking a forEach method directly on the list returned
		System.out.println("\n\nProcessing line by line using forEach... (outputting substrings - first 10 characters)\n===");
		Files.readAllLines(Paths.get("test2.txt")).forEach(s -> System.out.println(s.substring(0, 10)));

		/* ------------------------------------------------------------ */



		//create a new file and store the path returned, and handle potential exception if it already exists
		System.out.println("\n\nAttempting to create new file test3.txt...\n");
		Path path;
		try {
			path = Files.createFile(Paths.get("test3.txt"));
		} catch (FileAlreadyExistsException e) {
			System.out.println("file test3.txt already exists...");
			path = Paths.get("test3.txt");
		}

		//output string (containing names formatted on new lines) to be used for purpose of example
		String outputNames = "Joe Ram\n";
		outputNames += "Fred CPU\n";
		outputNames += "Joe Core\n";
		outputNames += "Tom Quad\n";
		outputNames += "Kerry Core";

		//writes a string (in byte form) to a file called test.txt in the temp directory
		Files.write(Paths.get("test3.txt"), outputNames.getBytes());


		/* --- READ LINES FROM A FILE AND YIELD A STREAM (OF STRINGS) --- */

		//read lines from a file into a stream of strings. This is executed within a try-with-resources block
		//so that the underlying file is closed when the operation is complete. This is possible because the
		//Stream interface extends AutoCloseable.
		try (Stream<String> stream  = Files.lines(path)) {

			System.out.println("\n\nStreaming through lines, filtering by Core, then printing results\n===");

			//filter stream and print results
			stream.filter(s -> s.contains("Core")).forEach(System.out::println);

		} catch (IOException e) {
			System.out.println("Failed to open or close file " + path);
		}


		System.out.println("\n\nStreaming through lines, mapping into Name objects, then printing each Name in the list\n===");

		//The yielded stream is directly operated on, mapping each line into a String[], which in turn maps to Name objects, which are collected into a list
		List<Name> names = Files.lines(path).map(s -> s.split(" ")).map(arr -> new Name(arr[0], arr[1])).collect(Collectors.toList());

		//print toString of each name to check they were created and added correctly
		names.forEach(System.out::println);

		//A version of the above code that uses try-with-resources to ensure the associated file that yields a stream is closed
		/*try (Stream<String> stream = Files.lines(path)) {
			List<Name> names2 = stream.map(s -> s.split(" ")).map(arr -> new Name(arr[0], arr[1])).collect(Collectors.toList());
			names2.forEach(System.out::println);
		} catch (IOException e) {
			System.out.println("Failed to open or close file " + path);
		}*/


		//optional string used to store value being searched for (which may or may not exist)
		Optional<String> foundCPU = null;

		//reads lines from a file and yields a stream of strings
		try (Stream<String> stream  = Files.lines(path)) {

			System.out.println("\n\nReading lines into a stream, and looking for first instance of name containing CPU if it exists\n===");

			//this operation will be handled lazily, such that if "CPU" is found, the file will close immediately, without reading any further lines
			//to check this is happening, the onClose operation is used in the pipeline, as well as a peek, that allows each element to be printed for debugging
			foundCPU = stream.onClose(() -> System.out.println("File has now been closed...\n"))
							 .peek(s -> System.out.println("Processed line: " + s))
							 .filter(s -> s.contains("CPU"))
							 .findFirst();

			//... you can try removing CPU from the outputNames String variable further above. This will allow you to see each line in the file is then processed.

		} catch (IOException e) {
			System.out.println("Failed to open or close file " + path);
		}

		//check if "CPU" was found - if so, print it out, else do nothing
		foundCPU.ifPresent(v -> System.out.println("The name " + v + " is present in the file..."));

		/* ------------------------------------------------------------ */



		/* --- READ CONTENTS OF A DIRECTORY AND YIELD A STREAM (OF PATHS) --- */

		//reads entries of current project root directory and yield a stream of their paths
		try (Stream<Path> entries = Files.list(Paths.get("."))) {

			System.out.println("\n\nReading entries of current project root directory into a stream of paths, and outputting them\n===");

			entries.forEach(System.out::println);

		} catch (IOException e) {
			System.out.println("Failed to read entries");
		}


		//reads root entries including descendants in subdirectories and yield a stream of their paths
		try (Stream<Path> entries = Files.walk(Paths.get("."))) {

			System.out.println("\n\nReading entries (and subdirectories) of current project root directory into a stream of paths, and outputting them\n===");

			entries.forEach(System.out::println);

		} catch (IOException e) {
			System.out.println("Failed to read entries");
		}

		/* ------------------------------------------------------------ */


		//delete testCopy.txt - if this was not done then potential exception would need to be caught earlier in program when testCopy is created via a copy.
		Files.deleteIfExists(Paths.get("temp/testCopy.txt")); //done for purpose of example, to show how to delete a file if it exists.
	}

}
