/**
 * 
 */
package test;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import controller.IContact;
import controller.IEmail;

/**
 * @author andreyf
 *
 */
public class MockContact implements IContact {

	byte[] thumbnail;
	String first;
	String last;
	
	public MockContact(String first, String last, byte[] thumbnail) {
		this.first = first;
		this.last = last;
		this.thumbnail = thumbnail;
	}
	
	@Override
	public boolean hasThumbnail() {
		return thumbnail != null;
	}

	@Override
	public byte[] getThumbnail() {
		return thumbnail;
	}

	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return first;
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return last;
	}

	@Override
	public String getEmailAddreess() {
		// TODO Auto-generated method stub
		return null;
	}
	

	public static List CreateMockContacts(int count) {
		
		List contacts = new ArrayList();
		
		for (int i = 0; i < count; count++) {

			contacts.add(new MockContact(
					"first" + i,
					"last" + i,
					null));
		}
		
		return contacts;
	}
}
