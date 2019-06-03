/**
 * 
 */
package backend;

import java.util.List;

import test.MockContact;

/**
 * @author andreyf
 * This class connects to College Server to view/search/retrieve contacts
 * Typically we will always search for a contact
 */
public class DirectoryAdapter implements IDirectoryAdapter {

	public DirectoryAdapter()
	{
		
	}
	
	@Override
	public int openConnection() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public List searchUser(String srchString, String srchFirst, String srchLast) {
		// TODO replace with actual impl
		
		return MockContact.CreateMockContacts(5);
	}



}
