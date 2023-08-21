package textio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Program to demonstrate how to populate a list from a data file.
 * Each data item is enclose is enclosed in angled brackets <>.
 * In this example we use a list of order lines. Each line of the data file is
 * in the form <id><unitPrice><quantity>. This has the benefit of being able to
 * have white space inside the angled brackets (e.g. Baked Beans is read in as
 * one string). The list is terminated with an <end> token. Ensure the data file
 * has no surplus white space before, between or after these delimiters. e.g.
 * <Milk><99><10>
 * <Tinned Tomatoes><50><3>
 * <end>
 *
 * @author la
 */


public class OrderProcessor2 {

	public static void main(String[] args) throws FileNotFoundException {
		List<OrderLine> stock = new ArrayList<OrderLine>();

		//Create a scanner to read the text data file
        Scanner sc = new Scanner(new File("stock2.txt"));

        //Set the scanner's delimiters to angle brackets <> and new lines
        //Note: "[<>\r\n]+" is a Regular Expression pattern - you may look it up!
        sc.useDelimiter("[<>\r\n]+");

        String id = sc.next();           //get first element
        while (!id.equals("end") ) {     //while not terminator

        	int unitPrice = sc.nextInt();         //get next element(s)
        	int quantity = sc.nextInt();

        	//create and add an orderline to the list
            stock.add(new OrderLine(id, unitPrice, quantity));

            id = sc.next();              //read the next element
        }
        sc.close();


		//check contents of stock list
		for (OrderLine o : stock) {
			System.out.println(o.toString());
		}

	}

}
