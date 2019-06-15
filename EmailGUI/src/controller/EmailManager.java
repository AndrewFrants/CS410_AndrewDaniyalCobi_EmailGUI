/**
 * 
 */
package controller;

import java.util.List;

import backend.IMailAPI;

/**
 * @author andreyf
 *
 */
public class EmailManager implements IEmailManager {

	EmailBag emails;
	
	public EmailManager(IMailAPI mailAPI) {
		emails = new EmailBag("folderName", this);
	}

	@Override
	public List getEmails(String folderName) {
		return emails.getEmails();
	}

	@Override
	public List getEmailsDelta(String folderName, List prevList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendEmails(List ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveEmailDrafts(List emails) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void RemoveEmails(List ids) {
		// TODO Auto-generated method stub
		
	}

}
