package controller;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import test.MockEmail;

public class Email implements IEmail {

	private long id;
	private List toAddresses;
	private List fromAddresses;
	private List attachments;
	private String subject;
	private String msgBody;
	private LocalDateTime date;
	
	public Email(long id, String subject, String toAddresses, String fromAddresses, String msgBody, String attachments) {
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
		this.date = LocalDateTime.now();
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

		return this.toAddresses;
	}

	@Override
	public List getFromAddresses() {
		return this.fromAddresses;
	}

	@Override
	public String setMessageBody() {
		return this.msgBody;
	}

	@Override
	public void AddAttachments(List attachments) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getMessageBodyString() {
		return this.msgBody;
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

	
	public static List<IEmail> CreateEmails(int count, int idOffset, boolean hasAttachments) {
		
		String[] emailBdy = new String[10];
		
		emailBdy[0] = "Hi professor Farag,\r\n" + 
				"\r\n" + 
				"We would like to schedule a sprint 2 demo for Monday, if anything is available after 1030am or before 115pm, or after 230pm\r\n" + 
				"\r\n" + 
				"Thanks,\r\n" + 
				"\r\n" + 
				"Daniyal and Andrew\r\n";
		
		emailBdy[1] = "Hi everyone,\r\n" + 
				"The end of the project- sprint2 is approaching this Sunday at 11:59 PM. Sprint Demos for projects are happening on Monday (06/17). Also, early Demos on Friday( 06/14) can be scheduled for the groups who like to do it early.\r\n" + 
				"Please pick a time that suits the whole team and send me an email to confirm the demo time. Securing time will be based on first come first serve.\r\n" + 
				"Here are all the available time slots to choose from\r\n" + 
				"Friday (06/14)\r\n" + 
				"•	12:00 pm to 12:15 pm\r\n" + 
				"•	1:30 pm to 1:45 pm\r\n" + 
				"•	1:45pn to 2:00 pm\r\n" + 
				"•	2:00 pm to 2:15 pm\r\n" + 
				"•	2:15 pm to 2:30 pm\r\n" + 
				"•	2:30 pm to 2:45 pm\r\n";
		
		emailBdy[2] = "Hi Everyone,\r\n" + 
				"After a few requests to extend the Design Document Final submission. I am happy to announce that, the due for the Design Document Final Documentation has been extended until Friday, June 14th at 11:59 PM \r\n" + 
				"I hope that helps with your classes workload.\r\n" + 
				"Warm regards,\r\n" + 
				"Sara\r\n";
		
		emailBdy[3] = "From: Andrew Frantsuzov\r\n" + 
				"Sent: Tuesday, June 11, 2019 4:14:07 PM\r\n" + 
				"To: Daniyal Adzhiyev\r\n" + 
				"Subject: Design doc outstanding work planning \r\n" + 
				" \r\n" + 
				"Hello Daniyal,\r\n" + 
				"Just FYI, we have two parts of the doc we need to complete. U want to split up the work? Let me know which one you want to pick to do from 2 sections below? We have to assume Sara says no and we need to finish it by EOD Wednesday.\r\n" + 
				" \r\n" + 
				"1 Sequence diagrams, class diagrams ~2 HRS\r\n" + 
				"2.2 Decomposition Description \r\n" + 
				"Provide a decomposition of the subsystems in the architectural design. Supplement with text as needed. You need to give an object-oriented description. For an OO description, put subsystem model, interface specifications, class diagrams, generalization hierarchy diagram(s) (if any), and sequence diagrams here. \r\n" + 
				"// This section will be completed as you doing the implementation of the project. Don’t complete for this phase of submission\r\n";
		
		emailBdy[4] = "Course Evaluations (+2 points) \r\n" + 
				"Hello,\r\n" + 
				"\r\n" + 
				"we have almost completed Spring quarter. I would appreciate if you complete the course and instructor evaluation and upload the certificate of completion via CANVAS. Your responses are anonymous; I will not be given the opportunity to review the anonymous student responses until after grades have been posted. The online evaluation is available until June 18th, 2019.\r\n" + 
				"\r\n" + 
				"Thank you in advance for taking the time to complete the survey and share your feedback with me.\r\n" + 
				"\r\n" + 
				"Fatma \r\n";
		
		List emails = new ArrayList();
		String attachments = null;
		if (hasAttachments)
		{
			attachments = "I am an attachment, for testing you could insert text and simulate virus scanning";
		}
		
		for (int i = 0; i<count; i++) {
			long emailId = idOffset + i;
			
			emails.add(new MockEmail(
					idOffset + i, 
					"Message Subject " + emailId, 
					"mockaddr1@mockdomain.com, mockaddr2@mockdomain.com",
					"mockaddr1@mockdomain.com, mockaddr2@mockdomain.com",
					emailBdy[i % 4],
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
