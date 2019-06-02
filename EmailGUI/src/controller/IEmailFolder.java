package controller;
import java.awt.List;

public interface IEmailFolder {
	
	List getEmails();
	
	List removeEmail();
	
	List markAsRead(List emails);
	
	void refreshFolder();
}
