import java.rmi.*;

public interface Information extends Remote {

// Ligne de commentaire
	public String echo(String msg) throws java.rmi.RemoteException;
//une autre
}