package backend;

import java.util.List;

public interface IVirusScanner {
	
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