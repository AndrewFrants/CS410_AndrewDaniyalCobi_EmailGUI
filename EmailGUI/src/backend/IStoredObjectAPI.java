package backend;

/*
 * Anything that can be stored must derive from this
 * API 
 */
public interface IStoredObjectAPI<T> {
	
	/*
	 * The unique key
	 */
	long getKey();
	
	/*
	 * This helps the storage manager know which table to use
	 * to save this object
	 */
	int getObjectType();
	
	byte[] serialize();
	
	T deserialize(byte[] serialized);
	
}