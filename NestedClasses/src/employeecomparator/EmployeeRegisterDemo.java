package employeecomparator;

import java.util.Comparator;

public class EmployeeRegisterDemo {
	
	public static void printEmployees(EmployeeRegister reg) {
		for (Employee e : reg) {
			System.out.print(e.getName().getFullName() + " -- Salary is " + e.getSalary() + " -- Start date: " + e.getStartDate().getDateString() + "\n");
		}
	}

	public static void main(String[] args) {
        EmployeeRegister reg = new EmployeeRegister("Finance");
		
		reg.addEmployee(new Employee(new Name("Anna", "Holdon"), new Date(1,3,2009), 10000));
		reg.addEmployee(new Employee(new Name("Tom", "Ford"), new Date(5,5,2013), 15500.50));	
		reg.addEmployee(new Employee(new Name("Katie", "Wood"), new Date(4,1,2010), 25000.50));
		reg.addEmployee(new Employee(new Name("Dharmesh", "Palal"), new Date(1,12,2012), 12000));
		
		//using external class comparator
		reg.sortEmployeeRegister(new EmployeeNameComparator());
		
		System.out.println("After Employee Name Comparator (external)\n=====");
		printEmployees(reg);
		
		
		//using inner class comparator
		reg.sortEmployeeRegister(new EmployeeNameReverseComparator());
		
		System.out.println("\nAfter Employee Name Reverse Comparator (inner)\n=====");
		printEmployees(reg);
		
		
		//using anonymous class comparator
		reg.sortEmployeeRegister(new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.getStartDate().compareTo(e2.getStartDate());
			}
		});
		
		System.out.println("\nAfter Employee Date Comparator (anonymous)\n=====");
		printEmployees(reg);
		
		
		//using lambda expression comparator
		reg.sortEmployeeRegister((Employee e1, Employee e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
		
		System.out.println("\nAfter Employee Salary Comparator (lambda)\n=====");
		printEmployees(reg);
	}
	
	/* Inner named class comparator to compare employees by their name in reverse */
	public static class EmployeeNameReverseComparator implements Comparator<Employee> {

		@Override
		public int compare(Employee e1, Employee e2) {
			return e2.getName().compareTo(e1.getName());
		}
		
	}

}
