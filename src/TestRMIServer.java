import java.rmi.*;
import java.rmi.server.*;

public class TestRMIServer extends UnicastRemoteObject implements Information {

   protected TestRMIServer() throws RemoteException {
      super();
   }

   public String getInformation()throws RemoteException {
      return "bonjour";
   }

}