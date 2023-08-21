package binaryio;


import java.io.IOException;


public class RegisterIOdemo {

	public static void main(String[] args) {
		NameRegisterIO reg = new NameRegisterIO();
		reg.addFirst(new Name("Fred","Dare"));
		reg.addFirst(new Name("Carol", "Akinson"));
		reg.addFirst(new Name("Tom", "Might"));

		System.out.println("List 1 " + reg.getRegisterContent());

		System.out.println("Writing List 1 to file...");
		reg.writeNameListToFile();


		NameRegisterIO other = new NameRegisterIO();
		//need try block as readNameListFromFile throws exceptions
		try {
			other.readNameListFromFile();
		}
		catch (IOException e){
			e.printStackTrace();
			System.out.println("Error reading");
		}
		catch (ClassNotFoundException c) {
			System.out.println("Class Not found");
		}

		System.out.println("\nReading List 1 from file into List 2...");
		System.out.println("List 2 " + other.getRegisterContent());

		System.out.println("\nInserting name 'Another name' into List 1");
		reg.addFirst(new Name("Another", "Name"));

		System.out.println("\nReading List 1 from file and adding to List 1...");
		reg.readAndAddNameListFromFile();

		System.out.println("List 1 " + reg.getRegisterContent());

		System.out.println("\nWriting names from List 2 to file...");
		other.writeNamesToFile();

		System.out.println("\nReading names of List 2 from file and adding to List 2...");
		other.readAndAddNamesFromFile();
		System.out.println("List 2 " + other.getRegisterContent());


	}

}
