/**
 * 
 */
package backend;

import java.awt.List;

interface IEmail {
	
	List get_To_Addresses();
	List get_From_Addresses();
	
	byte[] getMessageBody();

	boolean hasAttachments();
	
	List getAttachments();
}

interface IMailManager {
	
	int OpenConnection();
	
	List getNewEmails();
	
	void deleteEmail();
}

/**
 * @author andreyf
 *
 */
public class MailManager implements IMailManager {

	@Override
	public int OpenConnection() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List getNewEmails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmail() {
		// TODO Auto-generated method stub
		
	}


}
