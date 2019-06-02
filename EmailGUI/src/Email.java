import java.time.LocalDateTime;
import java.util.Date;

public class Email {

	private String sender;
	private String recipient;
	private String cc;
	private String subject;
	private LocalDateTime date;
	private String message;

	public Email(String sender, String recipient, String cc, String subject, String message) {
		this.sender = sender;
		this.recipient = recipient;
		this.cc = cc;
		this.subject = subject;
		this.message = message;
		this.date = LocalDateTime.now();

	}

	public LocalDateTime getDate() {
		return date;
	}

	public String getSender() {
		return sender;
	}

	public String getRecipient() {
		return recipient;
	}

	public String getMessage() {
		return message;
	}

	public String generateEmail() {
		String email = "From: " + sender + "\n" + "To: " + recipient + "\n" + "CC: " + cc + "\n" + "Date: " + date + "\n"
				+ "Subject: " + subject + "\n\n" + message;
		
		return email;
		
		
	}

}
