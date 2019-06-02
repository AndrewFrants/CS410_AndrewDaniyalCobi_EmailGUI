/**
 * 
 */
package backend;

import java.awt.List;

interface IAccountManger {
	
	/*
	 * Initialize an account
	 */
	void initialize(String accountName, String userName, String password);
	
	/*
	 * For UI display or account selection
	 */
	List getConfiguredAccounts();
	
	/*
	 * For UI display or account selection
	 */
	void switchAccountTo(String accountName);
	
	/*
	 * Function that returns a list of accounts that require
	 * reinitialization.
	 */
	List getAccountsRequiringRefresh();
	
	/*
	 * Check account settings are valid
	 */
	boolean areAccountSettingsValid();
	
	/*
	 * Gets the directory manager for this account
	 */
	IDirectoryAdapter getDirectoryManager();
	
	/*
	 * Gets the directory manager for this account
	 */
	IMailManager getMailManager();
	
	/*
	 * Gets the directory manager for this account
	 */
	IVirusScanner getVirusScanManager();
	
	
	/*
	 * Gets the directory manager for this account
	 */
	IStorageManager getStorageManager();
}

interface IVirusScanner {
	
	/*
	 * List of byte[] to pass to virus scanner
	 * returns requestId
	 * id is a user passed in id of the content
	 * subsequently this id can be used to check
	 * attachments
	 */
	int scanFiles(int id, List attachments);

	boolean isScanCompleted(int requestId);
	
	/*
	 * Pass request id to check if attachments were verified
	 * Hote: Call isScanCompleted to make sure scan was completed
	 * first before taking actions
	 */
	boolean isVerified(int requestId);
}

interface IToken {

	void initialize(String username, String password);
	
	String getAuthToken();
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
public class SecurityManager implements IDirectoryAdapter {

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
