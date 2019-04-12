package actors.classes;

import java.util.LinkedList;

import helping.classes.Message;

public abstract class User {

	
	/*
	 * Attributes
	 */

	protected String userName;
	protected String firstName;
	protected String lastName;
	protected String password;

	protected LinkedList<Message> messageList = new LinkedList<Message>();

	
	
	
	/*
	 * Constructor
	 */

	public User(String firstName, String lastName, String userName, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;

		this.messageList = new LinkedList<Message>();
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

	public LinkedList<Message> getMessageList() {
		return messageList;
	}

	public void setMessageList(LinkedList<Message> messageList) {
		this.messageList = messageList;
	}

	
	
	/*
	 * toString uses "&" as delimiter
	 */

	@Override
	public String toString() {
		StringBuilder stringBuilder =  new StringBuilder(firstName + "&" + lastName + "&" + userName + "&" + password + "&");
		stringBuilder.append(messageList.size()+"&");
		
		for (Message x: messageList) {
			stringBuilder.append(x.toString());
		}
		return stringBuilder.toString();
	}

	
	
	/*
	 * Adders
	 */

	public Message addMessage(String from, String to, String subject, String content) {
		messageList.add(0, new Message(from, to, subject, content));
		return messageList.getFirst();
	}
	
	
	/*
	 * Behavior
	 */
}
