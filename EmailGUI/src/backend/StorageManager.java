/**
 * 
 */
package backend;

interface IStorageManager {
	
	int openConnection(int type);
	
	void addOrUpdateData(int id, byte[] data);
	
	void search(String searchStr);
	
	byte[] getData(int key);
	
	void deleteData(int key);
}

/**
 * @author andreyf
 * This component would look at received/saved emails
 * it can search these emails. For some cases such as storage
 * it will also save it in the DB, however search functionality
 * will be disabled.
 */
public class StorageManager implements IStorageManager {

	@Override
	public int openConnection(int type) {

		final int EMAIL = 0;
		final int SETTINGS = 1;
		final int CONTACTS = 2;
		
		switch(type) {
		case EMAIL:
		{
			// connect to DB
			// prepare to query emails
		}
		break;
		case SETTINGS:
		{
			// connect to DB
			// prepare to query emails
		}
		break;
		case CONTACTS:
		{
			// connect to DB
			// prepare to query emails
		}
		break;
		}
		return 0;
	}

	@Override
	public void addOrUpdateData(int id, byte[] data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public byte[] getData(int key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteData(int key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void search(String searchStr) {
		// TODO Auto-generated method stub
		
	}


}
