/**
 * 
 */
package controller;

import java.util.List;


/**
 * @author andreyf
 *
 */
public class EmailBag implements IEmailFolder {

	/**
	 * 
	 */
	List<IEmail> emails;
	
	public EmailBag(String folderName, IEmailManager mgr) {
		// TODO Auto-generated constructor stub
		emails = Email.CreateEmails(14, 0, false);
	}


	@Override
	public List getEmails() {

		return emails;
	}

	@Override
	public List removeEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List markAsRead(List emails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void refreshFolder() {
		// TODO Auto-generated method stub
		
	}
}
