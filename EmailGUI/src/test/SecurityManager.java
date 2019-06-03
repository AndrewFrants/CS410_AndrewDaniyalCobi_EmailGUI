package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import backend.DirectoryAdapter;
import backend.IDirectoryAdapter;
import backend.IMailAPI;
import backend.IStorageAPI;
import backend.IToken;
import backend.IVirusScanner;
import backend.MailAPI;
import backend.StorageAPI;
import controller.IAccountsManager;

class MockSecurityManager implements IAccountsManager,  IVirusScanner, IToken {

	List accounts;
	
	public MockSecurityManager() {
		List accounts = new ArrayList();
		accounts.add("MockAccount");
	}
	
	@Override
	public int scanFiles(int id, List attachments) {
		return 1;
	}

	@Override
	public boolean isScanCompleted(int requestId) {

		return true;
	}

	@Override
	public boolean isVerified(int requestId) {
		return true;
	}

	@Override
	public void initialize(String accountName, String userName, String password) {
		
	}

	@Override
	public List getConfiguredAccounts() {

		return accounts;
	}

	@Override
	public void switchAccountTo(String accountName) {
		if (!accounts.contains(accountName)) {
			throw new InputMismatchException("Invalid account specified");
		}
	}

	@Override
	public List getAccountsRequiringRefresh() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean areAccountSettingsValid() {

		return true;
	}

	@Override
	public IDirectoryAdapter getDirectoryManager() {

		return new DirectoryAdapter();
	}

	@Override
	public IMailAPI getMailManager() {
		
		return new MailAPI();
	}

	@Override
	public IVirusScanner getVirusScanManager() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public IStorageAPI getStorageManager() {
		// TODO Auto-generated method stub
		return new StorageAPI();
	}

	@Override
	public String getAuthToken() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

class SecurityManagerUnitTests {

	SecurityManager securityManager;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
}
