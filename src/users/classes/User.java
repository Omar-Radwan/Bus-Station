package users.classes;

public class User {

	/*
	 * Attributes
	 */

	String userName;
	String firstName;
	String lastName;
	String password;
	String type;

	/*
	 * Constructor
	 */

	public User(String userName, String firstName, String lastName, String password, String type) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.type = type;
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

	public String getJob() {
		return type;
	}

	public void setJob(String job) {
		this.type = job;
	}

	/*
	 * toString uses " " as delimiter
	 */

	@Override
	public String toString() {
		return userName + " " + firstName + " " + lastName + " " + password + " " + type + " ";
	}
	
	/*
	 * Behavior
	 */
	
	

}
