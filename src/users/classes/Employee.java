package users.classes;

import classes.Date;

public abstract class Employee extends User {

	/*
	 * Attributes
	 */
	
	double salary ; 

	String job ;

	/*
	 * Constructor
	 */

	public Employee(String firstName, String lastName, String userName, String password, double salary) {
		super(firstName, lastName, userName, password);
	
		this.salary = salary;
	
	}



	
	/*
	 * Getters And Setters
	 */



	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}



	/*
	 * toString uses " " as delimiter
	 */

	
	/*
	 * Behavior
	 */
	
	

}
