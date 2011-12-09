import java.rmi.*;

//Je teste ma config Git
public interface Information extends java.rmi.Remote {
	
	public String passerMessage(String auteur,String message) throws java.rmi.RemoteException;
	public String lireTout()throws java.rmi.RemoteException;
	public void addUser(String username)throws java.rmi.RemoteException;
	public String userList()throws java.rmi.RemoteException;
}
