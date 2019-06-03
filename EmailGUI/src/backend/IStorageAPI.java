package backend;

import java.util.List;

public interface IStorageAPI {
	
	int openConnection(int type);
	
	void addOrUpdateData(long id, byte[] data);
	
	List search(String searchStr);
	
	byte[] getData(long key);
	
	void deleteData(long key);
}