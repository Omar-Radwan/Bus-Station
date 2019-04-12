package helping.classes;

public class Message {

	/*
	 * Attributes
	 */

	private String from;
	private String to;
	private String subject;
	private String content;
	private boolean isOpened;

	/*
	 * Constructor
	 */

	public Message(String from, String to, String subject, String content) {
		super();
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.content = content;
		this.isOpened = false;
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

	public boolean isOpened() {
		return isOpened;
	}

	public void setOpened(boolean isOpened) {
		this.isOpened = isOpened;
	}

	/*
	 * toString uses "&" as delimiter
	 */

	@Override
	public String toString() {
		return from + "$" + to + "$" + subject + "$" + content + "$" + isOpened + "&";
	}

	/*
	 * Behavior
	 */

	public String data() {

		return "From: " + from + "\nSubject: " + subject;
	}

}
