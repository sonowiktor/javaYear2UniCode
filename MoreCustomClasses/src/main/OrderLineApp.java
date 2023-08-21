package main;

import lib.OrderLine;

public class OrderLineApp {

	public static void main(String[] args) {
		//Use Constructors
				OrderLine line1 = new OrderLine();  //default constructor
				OrderLine line2 = new OrderLine("Cookie"); 
				OrderLine line3 = new OrderLine("Apple", 20, 6); 
				
				//show order lines
				System.out.println("1: " + line1.toString());
				System.out.println("2: " + line2.toString());
				System.out.println("3: " + line3.toString());
				System.out.println();
				
				//modify some values
				line1.setId("Baked Beans");
				line1.setUnitPrice(55);
				line1.setQuantity(4);
				
				line2.setUnitPrice(10);
				line2.setQuantity(25);
				
				line3.setId("Orange");
				
				//show new state
				System.out.println("1: " + line1.toString());
				System.out.println("2: " + line2.toString());
				System.out.println("3: " + line3.toString());
				System.out.println();
				
				//work out total cost
				int totalCost = line1.getCost() + line2.getCost() + line3.getCost();
						
				//Print order
				System.out.println("1:\t" + line1.getQuantity() 
						+ " * " + line1.getId()
						+ "\t@ " + line1.getUnitPrice() + "p"
						+ "\t" + line1.getCost() + "p");
				
				System.out.println("2:\t" + line2.getQuantity() 
						+ " * " + line2.getId()
						+ "\t@ " + line2.getUnitPrice() + "p"
						+ "\t" + line2.getCost() + "p");

				System.out.println("3:\t" + line3.getQuantity() 
						+ " * " + line3.getId()
						+ "\t@ " + line3.getUnitPrice() + "p"
						+ "\t" + line3.getCost() + "p");

				System.out.println("Total cost = " + totalCost + "p");
			}

	}

