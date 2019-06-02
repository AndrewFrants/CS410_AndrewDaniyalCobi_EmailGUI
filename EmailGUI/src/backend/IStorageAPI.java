package backend;

public interface IStorageAPI {
	
	int openConnection(int type);
	
	void addOrUpdateData(int id, byte[] data);
	
	void search(String searchStr);
	
	byte[] getData(int key);
	
	void deleteData(int key);
}