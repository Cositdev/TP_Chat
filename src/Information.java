import java.rmi.*;

//Je teste ma config Git
public interface Information extends java.rmi.Remote {
	public String passerMessage(String auteur,String message) throws java.rmi.RemoteException;
}
