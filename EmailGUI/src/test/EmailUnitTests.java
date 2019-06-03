package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import backend.AuthenticationManager;
import controller.EmailManager;

class EmailUnitTests {

	EmailManager manager;
	AuthenticationManager securityMgr;
	
	@BeforeEach
	void setUp() throws Exception {

		securityMgr = new AuthenticationManager();
		
		manager = new EmailManager(securityMgr.getMailManager());
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testEmailManager() {
		assertNotNull(manager, "manager was null");
	}

	@Test
	void testGetEmails() {
		fail("Not yet implemented");
	}

	@Test
	void testGetEmailsDelta() {
		fail("Not yet implemented");
	}

	@Test
	void testSendEmails() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveEmailDrafts() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveEmails() {
		fail("Not yet implemented");
	}

}
