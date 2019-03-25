package users.classes;

public class User {
	
	String userName;
	String firstName; 
	String lastName;
	String password;
	
	String job;
	
	//---------------------------------------------------------------------------
	
	public User(String userName, String firstName, String lastName, String password, String job) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.job = job;
	}

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
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
	//---------------------------------------------------------------------------
	//---------------------------------------------------------------------------

}
