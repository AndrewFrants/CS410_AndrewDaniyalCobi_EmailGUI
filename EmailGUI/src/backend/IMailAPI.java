package backend;

import java.util.List;

/*
 * API for retrieving emauls
 */
public interface IMailAPI {
	
	int openConnection();
	
	/*
	 * Get new emails
	 * prevEmails - Optional. If specified returns only emails not in this list
	 */
	List getNewEmails(List prevEmails);
	
	void deleteEmail();
}