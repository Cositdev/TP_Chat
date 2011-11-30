import java.rmi.*;
import java.rmi.server.*;

public class TestRMIServer extends UnicastRemoteObject implements Information {

   protected TestRMIServer() throws RemoteException {
      super();
   }
   //Methode de récupération d'informations
   public String getInformation()throws RemoteException {
      return "bonjour";
   }

}