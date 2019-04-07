package classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

import users.classes.User;

public class Database {

	/*
	 * Attributes
	 */

	String pathname;
	LinkedList<User> usersList;

	/*
	 * Constructor
	 */

	public Database(String filePath) {
		super();
		this.pathname = filePath;
		this.usersList = new LinkedList<User>();
	}

	/*
	 * Getters And Setters
	 */

	public String getFilePath() {
		return pathname;
	}

	public void setFilePath(String filePath) {
		this.pathname = filePath;
	}

	/*
	 * Loads users from file to database
	 */

	public void loadAllUsers() throws IOException {

		File file = new File(pathname);
		FileReader fileReader = new FileReader(file);

		BufferedReader bufferedReader = new BufferedReader(fileReader);

		while (bufferedReader.ready()) {
			String line = bufferedReader.readLine();

			loadUser(line);
		}
	}

	/*
	 * Initializes one user by fields read from file and adds it to database
	 */

	public User loadUser(String line) {

		StringTokenizer st = new StringTokenizer(line);

		String[] userFields = new String[5];
		userFields[0] = st.nextToken();
		userFields[1] = st.nextToken();
		userFields[2] = st.nextToken();
		userFields[3] = st.nextToken();
		userFields[4] = st.nextToken();

		if (userFields[0].equals("Manager")) {

		} else if (userFields[0].equals("Driver")) {

		}

		else if (userFields[0].equals("Passenger")) {

		}
		return null;

	}

	/*
	 * Adds new user to the file and to the database
	 */

	public void registerUser(User x) throws IOException {

		File file = new File(pathname);
		FileWriter fileWriter = new FileWriter(file);

		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

	}

	/*
	 * Function that checks if there exists a user with user name and password given
	 */

	public User authenticate(String userName, String password) {

		for (User x : usersList)
			if (x.getUserName().equals(userName) && x.getPassword().equals(password))
				return x;

		return null;

	}

	/*
	 * 
	 */

	public void addUserToTheFile() {

	}

}
