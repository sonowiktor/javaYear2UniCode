package textio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderProcessor {

	public static void main(String[] args) throws FileNotFoundException {
		List<OrderLine> stock = new ArrayList<OrderLine>();

		Scanner in = new Scanner(new File("stock.txt"));

		String line;
		String[] arr;

		while (in.hasNextLine()) {
			line = in.nextLine();

			arr = line.split(" ");
			if (arr.length == 4) {

				stock.add(new OrderLine(arr[0] + " " + arr[1],Integer.parseInt(arr[2]),Integer.parseInt(arr[3])));

			} else if (arr.length == 3) {

				stock.add(new OrderLine(arr[0],Integer.parseInt(arr[1]),Integer.parseInt(arr[2])));

			}

		}

		in.close();

		PrintWriter out = new PrintWriter(new File("reorder.txt"));

		for (OrderLine o : stock) {
			if (o.getQuantity() < 10) {
				out.println(o.getId() + " : Please reorder " + (100-o.getQuantity()));
			}
		}

		out.close();


	}

}
