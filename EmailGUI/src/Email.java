import java.time.LocalDateTime;
import java.util.Date;

public class Email {
	
	private String sender;
	private String recipient;
	private LocalDateTime date;
	private String message;
	
	public Email(String sender, String recipient, String message) {
		this.sender = sender;
		this.recipient = recipient;
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



	

}
