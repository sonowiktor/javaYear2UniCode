package binaryio;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.ListIterator;


public class NameRegisterIO implements Iterable<Name> {

	//Fields
	private LinkedList<Name> list;

	//Constructors
	public NameRegisterIO() {
		list = new LinkedList<Name>();
	}

	//Methods

	//Writes a single list object to a file
	public void writeNameListToFile() {
		//using a finally block to ensure stream is closed.

		ObjectOutputStream oos = null;

		try {
			oos = new ObjectOutputStream(new FileOutputStream("nameListObj.dat"));
            oos.writeObject(list);
            oos.flush();
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("Error writing");
        }
        finally {
        	//this block will always execute, even if an exception occurs, ensuring the stream is closed.
        	 try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Error closing");
			}

        }
    }


	//Writes the contents of a list to a file
	public void writeNamesToFile() {
        //using try-with-resources statement, the stream is automatically closed when exiting the try block.
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("nameObjs.dat"))) {

            for (Name n : list) {
            	oos.writeObject(n);
            }
            oos.writeObject(null);

            oos.flush();
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("Error writing");
        }
    }


	//Reads a list object from a file and assigns it to list field
	public void readNameListFromFile() throws IOException, ClassNotFoundException {

		//method throws exceptions, rather than catching them, so caller must handle them.
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("nameListObj.dat"));

		list = (LinkedList<Name>) ois.readObject();

		ois.close();
	}


	//Reads a list object from a file and adds it to list field
	public void readAndAddNameListFromFile() {

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("nameListObj.dat"))){

            list.addAll(0, (LinkedList<Name>) ois.readObject());
            ois.close();
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("Error reading");
        }
        catch (ClassNotFoundException c) {
            System.out.println("Class Not found");
        }

    }


	//Reads name objects from a file and adds them to a list
	public void readAndAddNamesFromFile() {

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("nameObjs.dat"))) {

			Name n = null;

			while ((n = (Name) ois.readObject()) != null) {
				list.add(n);
			}

			ois.close();
		}
		catch (IOException e){
			e.printStackTrace();
			System.out.println("Error reading");
		}
		catch (ClassNotFoundException c) {
			System.out.println("Class Not found");
		}

	}

	public void addFirst(Name e) {
		list.addFirst(e);
	}

	public boolean remove(Name e) {
		return list.remove(e);
	}

	public Name getLast() {
		return list.getLast();
	}

	public int size() {
		return list.size();
	}

	public boolean isRegisterEmpty() {
		return list.isEmpty();
	}

	public ListIterator<Name> iterator() {
		return list.listIterator();
	}

	public String getRegisterContent() {
		String s = "";
		for (Name n : list) {
			s += "<" + n.getFullName() + ">";
		}
		return s;
	}

	public String toString() {
		return "NameRegister:[list=" + list + "]";
	}
}
