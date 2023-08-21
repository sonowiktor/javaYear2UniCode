package main;

import lib.employee.Date;
import lib.employee.Employee;
import lib.employee.Name;

public class EmployeeDemo {
    
    public static void main(String[] args) {

    	// Create a default instance of Employee
        Employee emp = new Employee();
        System.out.println(emp.toString() + "\n");

        // Note how set methods are used - passing new object instances of Name and Date
        emp.setName(new Name("Joe", "Bloggs"));
        emp.setStartDate(new Date(10,11,2013));
        
        emp.setSalary(12500);
        System.out.println(emp.toString() +"\n");
        
        // Note how methods of the Name or Date class can be called by first
        // retrieving the object and then calling the method using dot notation
        System.out.println("Full name is " + emp.getName().getFullName());
        System.out.println("Start date is " + emp.getStartDate().getDateString());
        
        System.out.println("Annual salary is " + emp.getSalary());

       
        System.out.println("\nCreating another employee...");
        
        // Create a custom instance of Employee by providing Name and Date objects
        Employee emp1 = new Employee(new Name("Tom", "Ford"), new Date(1,3,2009), 15500.50);
        
        // Note how first name can be updated by retrieving Name object and then calling its method
        emp1.getName().setFirstName("George");
        
        System.out.println(emp1.toString());
       
        
        //testing if two employees are equal
        if (emp.equals(emp1)) {
        	System.out.println("The two employees are equal");
        } else {
        	System.out.println("The two employees are not equal");
        }

        
    }
    
}
