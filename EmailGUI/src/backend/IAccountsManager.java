/**
 * 
 */
package backend;

import java.util.List;

/*
 * This class is the entry point to the application
 * The user is expected to input their account details
 * then the rest of the services will be initialized from here
 * this allows us to simplify password and token management so
 * that all the interfaces will be initialized
 */
public interface IAccountsManager {
	
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
	IMailAPI getMailManager();
	
	/*
	 * Gets the directory manager for this account
	 */
	IVirusScanner getVirusScanManager();
	
	/*
	 * Gets the directory manager for this account
	 */
	IStorageAPI getStorageManager();
}
