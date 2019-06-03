/**
 * 
 */
package controller;

import java.util.List;

import backend.IDirectoryAdapter;

/**
 * @author andreyf
 * This class connects to College Server to view/search/retrieve contacts
 * Typically we will always search for a contact
 */
public class DirectoryManager implements IDirectoryManager {

	private IDirectoryAdapter directory;
	
	public DirectoryManager(IDirectoryAdapter dirAPI)
	{
		this.directory = dirAPI;
	}
	
	@Override
	public void newContact(IContact contact) {
		// this will go to storage
	}

	@Override
	public List<IContact> searchContacts(String srchString, String srchFirst, String srchLast) {

		return this.directory.searchUser(srchString, srchFirst, srchLast);
		
	}

	@Override
	public void removeContact() {
		// TODO Auto-generated method stub
		
	}}
