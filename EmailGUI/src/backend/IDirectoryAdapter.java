package backend;

import java.util.List;

import controller.IContact;

public interface IDirectoryAdapter {
	
	int openConnection();
	
	/*
	 * Search will return up to ~5 contacts at a time
	 * The return type is a list of IContact
	 */
	List<IContact> searchUser(String srchString, String srchFirst, String srchLast);
}