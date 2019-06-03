/**
 * 
 */
package controller;

import java.util.List;

import backend.IStoredObjectAPI;

/**
 * @author andreyf
 *
 */
public interface IEmail extends IStoredObjectAPI {
	
	long getId();
	
	List getToAddresses();
	List getFromAddresses();
	
	/*
	 * Save the message body in UTF-16
	 */
	String setMessageBody();
	
	/*
	 * Saves attachments as byte[]
	 */
	void AddAttachments(List attachments);
	
	String getMessageBodyString();

	boolean hasAttachments();
	
	List getAttachments();
}