package controller;

interface IContact {
	
	boolean hasThumbnail();
	
	byte[] getThumbnail();
	
	String getFirstName();
	
	String getLastName();
	
	String getEmailAddreess();
}
