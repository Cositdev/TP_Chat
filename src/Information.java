import java.rmi.*;
// Commentaire � enlever
public interface Information extends Remote {

public String getInformation() throws RemoteException;

}