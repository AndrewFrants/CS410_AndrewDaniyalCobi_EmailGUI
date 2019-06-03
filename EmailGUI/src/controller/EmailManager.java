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

	/**
	 * 
	 */
	public EmailManager(IMailAPI mailAPI) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List getEmails(String folderName) {
		// TODO Auto-generated method stub
		return null;
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
