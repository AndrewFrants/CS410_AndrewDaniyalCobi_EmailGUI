/**
 * 
 */
package backend;

import java.util.List;

import controller.IAccountsManager;


/**
 * @author andreyf
 *
 */
public class AuthenticationManager implements IAccountsManager,  IVirusScanner, IToken {

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
	public IMailAPI getMailManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IVirusScanner getVirusScanManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IStorageAPI getStorageManager() {
		// TODO Auto-generated method stub
		return null;
	}



}
