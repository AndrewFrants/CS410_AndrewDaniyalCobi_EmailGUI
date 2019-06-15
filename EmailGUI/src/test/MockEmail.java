/**
 * 
 */
package test;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import controller.IEmail;

/**
 * @author andreyf
 *
 */
public class MockEmail implements IEmail {

	private long id;
	private List toAddresses;
	private List fromAddresses;
	private List attachments;
	private String subject;
	private String msgBody;
	
	/**
	 * 
	 */
	public MockEmail(long id, String subject, String toAddresses, String fromAddresses, String msgBody, String attachments) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.toAddresses = new ArrayList();
		this.fromAddresses = new ArrayList();
		this.attachments = new ArrayList();

		this.toAddresses.addAll(Arrays.asList(toAddresses.split(",")));
		this.toAddresses.addAll(Arrays.asList(fromAddresses.split(",")));
		if (attachments != null) {
			this.toAddresses.addAll(Arrays.asList(attachments.split(",")));
		}
		this.msgBody = msgBody;
		this.subject = subject;
	}

	@Override
	public long getKey() {

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
		// TODO Auto-generated method stub
		return this.toAddresses;
	}

	@Override
	public List getFromAddresses() {
		// TODO Auto-generated method stub
		return this.toAddresses;
	}

	@Override
	public String setMessageBody() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void AddAttachments(List attachments) {
		// TODO Auto-generated method stub
		this.attachments.addAll(attachments);
	}

	@Override
	public String getMessageBodyString() {
		// TODO Auto-generated method stub
		return this.msgBody;
	}

	@Override
	public boolean hasAttachments() {
		// TODO Auto-generated method stub
		return this.attachments.isEmpty();
	}

	@Override
	public List getAttachments() {
		// TODO Auto-generated method stub
		return this.attachments;
	}

	public static List CreateMockEmails(int count, int idOffset, boolean hasAttachments) {
		
		List emails = new ArrayList();
		String attachments = null;
		if (hasAttachments)
		{
			attachments = "I am an attachment, for testing you could insert text and simulate virus scanning";
		}
		
		for (int i = 0; i<count; count++) {
			long emailId = idOffset + i;
			
			emails.add(new MockEmail(
					idOffset + i, 
					"Mock email " + emailId, 
					"mockaddr1@mockdomain.com, mockaddr2@mockdomain.com",
					"mockaddr1@mockdomain.com, mockaddr2@mockdomain.com",
					"Mock message body",
					attachments));
		}
		
		return emails;
	}

	@Override
	public String getSubject() {
		// TODO Auto-generated method stub
		return this.subject;
	}
}
