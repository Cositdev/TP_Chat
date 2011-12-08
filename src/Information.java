import java.rmi.*;

public interface Information extends java.rmi.Remote {
	public String passerMessage(String auteur,String message) throws java.rmi.RemoteException;
}