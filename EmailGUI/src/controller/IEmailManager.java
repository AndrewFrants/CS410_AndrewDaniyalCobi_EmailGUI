package controller;

import java.util.List;

public interface IEmailManager {

	List<IEmail> getEmails(String folderName);
	
	
	List getEmailsDelta(String folderName, List prevList);
	
	
	/*
	 * Sends email will send the email
	 * Note: Email must have been saved to drafts
	 */
	void sendEmails(List ids);
	
	/*
	 * Takes a list of IEMails and saves them to
	 * the drafts folder.
	 */
	void saveEmailDrafts(List emails);
	
	/*
	 * 
	 */
	void RemoveEmails(List ids);
}