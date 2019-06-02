/**
 * 
 */
package backend;

import java.awt.List;

interface IContact {
	
	boolean hasThumbnail();
	
	byte[] getThumbnail();
	
	String getFirstName();
	
	String getLastName();
	
	String getEmailAddreess();
}

interface IDirectoryAdapter {
	
	int openConnection();
	
	/*
	 * Get the list of IContacts
	 */
	List searchUser(String srchString, String srchFirst, String srchLast);
}

/**
 * @author andreyf
 *
 */
public class DirectoryAdapter implements IDirectoryAdapter {

	@Override
	public int openConnection() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List searchUser(String srchString, String srchFirst, String srchLast) {
		// TODO Auto-generated method stub
		return null;
	}



}
