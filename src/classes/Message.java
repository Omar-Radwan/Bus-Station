package classes;

public class Message {
	
	String from ; 
	String to; 

	String subject;
	String content;

	public Message(String from, String to, String subject, String content) {
		super();
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.content = content;
	}
	
}
