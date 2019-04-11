package classes;

public class Message {
	
	
	/*
	 * Attributes
	 */
	
	private String from ; 
	private String to; 
	private String subject;
	private String content;

	
	/*
	 * Constructor
	 */

	public Message(String from, String to, String subject, String content) {
		super();
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.content = content;
	}
	
	
	/*
	 * Getters and setters
	 */
	
	
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	/*
	 * toString uses "&" as delimiter
	 */
	
	
	@Override
	public String toString () {
		return to+"$"+from+"$"+subject+"$"+content+"&";
	}


	public  String data() {

		return "From: "+from+"\nSubject: "+subject;
	}



	
	/*
	 * Adders
	 */
	
	/*
	 * Behavior
	 */
	
}
