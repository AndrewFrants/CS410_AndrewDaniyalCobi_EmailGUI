/**
 * 
 */
package controller;

import java.util.List;

/**
 * Returns contacts
 */
public interface IDirectoryManager {

	void newContact(IContact contact);
	
	List<IContact> searchContacts(String srchString, String srchFirst, String srchLast);
	
	void removeContact();
}
