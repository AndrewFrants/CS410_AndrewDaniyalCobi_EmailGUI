/**
 * 
 */
package backend;

import java.util.List;

import test.MockEmail;


/**
 * @author andreyf
 *
 */
public class MailAPI implements IMailAPI {

	@Override
	public int openConnection() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List getNewEmails(List knownEmails) {
		
		// TODO switch to storage call 
		return MockEmail.CreateMockEmails(2, 0, true);
	}

	@Override
	public void deleteEmail() {
		// TODO Auto-generated method stub
		
	}
}
