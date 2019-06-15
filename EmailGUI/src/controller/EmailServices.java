/**
 * 
 */
package controller;

import backend.AuthenticationManager;
import backend.IAccountsManager;

/**
 * @author andreyf
 *
 */
public class EmailServices implements IEmailServices {

	IEmailManager emailMgr;
	IDirectoryManager dirMgr;
	IAccountsManager accountMgr;
	
	public EmailServices() {
		accountMgr = new AuthenticationManager();
		accountMgr.initialize("accountName", "userName", "password");
		emailMgr = new EmailManager(accountMgr.getMailManager());
		dirMgr = new DirectoryManager(accountMgr.getDirectoryManager());
	}

	@Override
	public IDirectoryManager getDirManager() {
		return dirMgr;
	}

	@Override
	public IEmailManager getEmailManager() {
		return emailMgr;
	}

}
