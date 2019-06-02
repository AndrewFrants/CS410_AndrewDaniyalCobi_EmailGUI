/**
 * 
 */
package backend;

import java.awt.List;

/*
 * This class is the entry point to the application
 * The user is expected to input their account details
 * then the rest of the services will be initialized from here
 * this allows us to simplify password and token management so
 * that all the interfaces will be initialized
 */
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

/* 
 * If a backend service relies on token based auth
 * this interface will be passed to it to get the token
 */
interface IToken {

	String getAuthToken();
}

/**
 * @author andreyf
 *
 */
public class SecurityManager implements IAccountManger,  IVirusScanner, IToken {

	@Override
	public String getAuthToken() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int scanFiles(int id, List attachments) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isScanCompleted(int requestId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isVerified(int requestId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void initialize(String accountName, String userName, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List getConfiguredAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void switchAccountTo(String accountName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List getAccountsRequiringRefresh() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean areAccountSettingsValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IDirectoryAdapter getDirectoryManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IMailManager getMailManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IVirusScanner getVirusScanManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IStorageManager getStorageManager() {
		// TODO Auto-generated method stub
		return null;
	}



}
