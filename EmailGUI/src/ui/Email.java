package ui;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import controller.IEmail;

public class Email implements IEmail {

	private String sender;
	private String recipient;
	private String cc;
	private String subject;
	private LocalDateTime date;
	private String message;
	private long id;
	
	public Email(String sender, String recipient, String cc, String subject, String message) {
		this.sender = sender;
		this.recipient = recipient;
		this.cc = cc;
		this.subject = subject;
		this.message = message;
		this.date = LocalDateTime.now();
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}


	@Override
	public long getKey() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public int getObjectType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public byte[] serialize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object deserialize(byte[] serialized) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public List getToAddresses() {

		List<String> toAddresses = new ArrayList<String>();
		toAddresses.add(this.recipient);
		
		return toAddresses;
	}

	@Override
	public List getFromAddresses() {
		List<String> fromAddresses = new ArrayList<String>();
		fromAddresses.add(this.sender);
		return fromAddresses;
	}

	@Override
	public String setMessageBody() {
		return this.message;
	}

	@Override
	public void AddAttachments(List attachments) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getMessageBodyString() {
		return this.message;
	}

	@Override
	public boolean hasAttachments() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List getAttachments() {
		// TODO Auto-generated method stub
		return null;
	}

	public String generateEmail() {
		String email = "From: " + sender + "\n" + "To: " + recipient + "\n" + "CC: " + cc + "\n" + "Date: " + date + "\n"
				+ "Subject: " + subject + "\n\n" + message;
		
		return email;
		
		
	}

	@Override
	public String getSubject() {
		// TODO Auto-generated method stub
		return this.subject;
	}
}
