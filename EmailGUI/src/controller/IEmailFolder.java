package controller;
import java.util.List;

public interface IEmailFolder {
	
	List getEmails();
	
	List removeEmail();
	
	List markAsRead(List emails);
	
	void refreshFolder();
}
