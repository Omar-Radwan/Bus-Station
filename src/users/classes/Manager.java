package users.classes;

import classes.Date;

public class Manager extends Employee {

	/*
	 * Attributes
	 */

	/*
	 * Constructor
	 */

	public Manager(String firstName, String lastName, String userName, String password, double salary) {
		super( firstName, lastName, userName, password, salary);
		this.job = "Manager";
	}

	/*
	 * Getters And Setters
	 */

	/*
	 * toString uses " " as delimiter
	 */

	/*
	 * Behavior
	 */

}
