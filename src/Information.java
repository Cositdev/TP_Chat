import java.rmi.*;

public interface Information extends Remote {

// Ligne de commentaire
public String getInformation() throws RemoteException;

}