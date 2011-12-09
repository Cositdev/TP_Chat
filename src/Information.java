import java.rmi.*;

public interface Information extends java.rmi.Remote {
	
	public String passerMessage(String auteur,String message) throws java.rmi.RemoteException;
	public String lireTout(String Nom)throws java.rmi.RemoteException;
	public void addUser(String username)throws java.rmi.RemoteException;
	public String userList()throws java.rmi.RemoteException;
	public void deconnexion(String username)throws java.rmi.RemoteException;
	public void who(String nom) throws java.rmi.RemoteException;
}