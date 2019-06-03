/**
 * 
 */
package backend;

import java.util.Hashtable;
import java.util.List;

/**
 * @author andreyf
 * This component would look at received/saved emails
 * it can search these emails. For some cases such as storage
 * it will also save it in the DB, however search functionality
 * will be disabled.
 */
public class StorageAPI implements IStorageAPI {

	Hashtable<Long, Object> inMemoryStorage;
	
	public StorageAPI()
	{
		inMemoryStorage = new Hashtable<Long, Object>();
	}
	
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
	public void addOrUpdateData(long id, byte[] data) {
		// TODO Auto-generated method stub
		this.inMemoryStorage.put(id, data);
	}

	@Override
	public byte[] getData(long key) {
		// TODO Auto-generated method stub
		return (byte[])this.inMemoryStorage.get(key);
	}

	@Override
	public void deleteData(long key) {
		this.inMemoryStorage.remove(key);
		
	}

	@Override
	public List search(String searchStr) {
		// TODO return some mock items
		return null;
	}


}
