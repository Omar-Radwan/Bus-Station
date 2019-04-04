package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import users.classes.User;

public class Database {

	/*
	 * Attributes
	 */

	String pathname;
	HashMap<String, User> userNameToUserMap;

	/*
	 * Constructor
	 */

	public Database(String filePath) {
		super();
		this.pathname = filePath;
		this.userNameToUserMap = new HashMap<String, User>();
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

	public HashMap<String, User> getNameToUserDataBase() {
		return userNameToUserMap;
	}

	public void setNameToUserDataBase(HashMap<String, User> nameToUserDataBase) {
		this.userNameToUserMap = nameToUserDataBase;
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

	public void loadUser(String line) {

		String[] tokens = line.split(" ");

		if (tokens[0].equals("Manager")) {

		}

		else if (tokens[0].equals("Driver")) {

		}

		else if (tokens[0].equals("Passenger")) {

		}

	}

	/*
	 * Adds new user to the file and to the database
	 */

	public void registerUser() {

	}

	/*
	 * Function that checks if there exists a user with user name and password given
	 */

	public User authenticate(String userName, String password) {

		User searchResult = userNameToUserMap.get(userName);
		return (searchResult == null || !searchResult.getPassword().equals(password)) ? null : searchResult;

	}
	


}
