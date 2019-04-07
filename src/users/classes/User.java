package users.classes;

public abstract class User {

	/*
	 * Attributes
	 */
	
	String userName;
	String firstName;
	String lastName;
	String password;

	/*
	 * Constructor
	 */

	public User( String firstName, String lastName, String userName, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
	}

	/*
	 * Getters And Setters
	 */


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	/*
	 * toString uses " " as delimiter
	 */

	@Override
	public String toString() {
		return  firstName + " " + lastName + " " + userName + " " + password + " ";
	}

	/*
	 * Behavior
	 */

	

}
