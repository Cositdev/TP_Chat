import java.rmi.*;
import java.rmi.server.*;

public class TestRMIServer extends UnicastRemoteObject implements Information {
	
   protected TestRMIServer() throws RemoteException {
      super();
   }
   public String echo(String msg) throws RemoteException{
	   return "["+msg+"]";
   }
	public static void main(String arg[]){
		try{
			TestRMIServer serveurRMI = new TestRMIServer();
			Naming.rebind("ServeurRMI", serveurRMI);
			System.out.println("Serveur pret");
			
		}catch (Exception e) {
			System.err.println("Erreur "+ e + "lors du lancement du server RMI");
		}
	}

}