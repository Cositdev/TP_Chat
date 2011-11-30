import java.rmi.*;
// Commentaire à enlever
public interface Information extends Remote {

public String getInformation() throws RemoteException;

}