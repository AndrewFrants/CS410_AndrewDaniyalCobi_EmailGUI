package backend;

import java.awt.List;

public interface IDirectoryAdapter {
	
	int openConnection();
	
	/*
	 * Get the list of IContacts
	 */
	List searchUser(String srchString, String srchFirst, String srchLast);
}