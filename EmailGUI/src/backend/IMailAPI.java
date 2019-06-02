package backend;

import java.awt.List;

public interface IMailAPI {
	
	int OpenConnection();
	
	List getNewEmails();
	
	void deleteEmail();
}