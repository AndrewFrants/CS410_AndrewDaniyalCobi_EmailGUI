package backend;

/* 
 * Internal to Backend
 * If a backend service relies on token based auth
 * this interface will be passed to it to get the token
 */
public interface IToken {

	String getAuthToken();
}